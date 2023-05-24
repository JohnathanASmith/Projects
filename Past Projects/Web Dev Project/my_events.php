<!--Johnathan Smith-->
<?php
require './includes/header.php';
require_once '../../mysqli_connect.php';
if (!isset($_SESSION['email'])) {
    echo "<main>";
    echo "<h2>We are sorry, but you must be logged in as a registered user</h2>";
    echo "<h3>Use the Register link to create an account</h2></main>";
    include('./includes/footer.php');
    exit;
  }
?>

<main>
    <section id="users_events">
        <div id="created_events">
            <h2>Created Events</h2>
            <?php


            if (isset($_GET['createPage'])) {
                $createPage = $_GET['createPage'];
            } else {
                $createPage = 1;
            }
            if (isset($_GET['createStart'])) {
                $createStart = $_GET['createStart'];
            } else {
                $createStart = 1;
            }


            $query = "SELECT COUNT(*) AS numEvents FROM Final_Events WHERE host = ?";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            $createrow = mysqli_fetch_assoc($result);
            $createnumEvents = $createrow['numEvents'];
            mysqli_stmt_free_result($stmt);

            define("COLS", 1);
            define("ROWS", 2);
            $create_per_page_img = COLS * ROWS;

            $create_offset = ($create_per_page_img * $createPage) - $create_per_page_img;
            if (($create_per_page_img * $createPage) > $createnumEvents) {
                $createEnd = $createnumEvents;
            } else {
                $createEnd = $create_per_page_img * $createPage;
            }

            $query = "SELECT name, description, thumbnail, host from Final_Events Where host = ? LIMIT $create_per_page_img OFFSET $create_offset";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            ?>


            <p id="eventCount">Displaying
                <?= $createStart ?> to
                <?= $createEnd ?> of
                <?= $createnumEvents ?> Events
            </p>
            <table id="eventTable">

                <?php


                while ($createrow = mysqli_fetch_assoc($result)) {
                    echo "<tr>";
                    echo "<td class = 'eventPost'><img src='show_image.php?email=" . $createrow['host'] . "&image=" . $createrow['thumbnail'] . "' alt='" . $createrow["thumbnail"] . "' width='80' height='54'>";
                    echo "<div class='eventPostDescription'>";
                    echo "<h3>Title: " . $createrow['name'] . "</h3>";
                    echo "<span>Description: " . $createrow['description'] . "</span>";
                    echo "</div>";
                    echo "</td>";
                    echo "</tr>";
                }

                ?>
            </table>
            <table id=pagTable>
                <?php
                if ($createPage == 1 && ($createnumEvents > $create_per_page_img)) {
                    echo "<tr>";
                    echo "<td></td><td class = 'next'><a href='my_events.php?createPage=" . ($createPage + 1) . "&createStart=" . ($createStart + $create_per_page_img) . "'>Next&gt&gt</a></td>";
                    echo "</tr>";
                } elseif ($createPage == 1 && ($createnumEvents <= $create_per_page_img)) {
                    echo "";
                } elseif ($createPage > 1 && ($createStart + $create_per_page_img > $createnumEvents)) {
                    echo "<tr>";
                    echo "<td class = 'back'><a href='my_events.php?createPage=" . ($createPage - 1) . "&createStart=" . ($createStart - $create_per_page_img) . "'>&lt&ltPrev</a></td><td></td>";
                    echo "</tr>";
                } else {
                    echo "<tr>";
                    echo "<td class= 'back'><a href='my_events.php?createPage=" . ($createPage - 1) . "&createStart=" . ($createStart - $create_per_page_img) . "'>&lt&ltPrev</a></td><td class = 'next'><a href='my_events.php?createPage=" . ($createPage + 1) . "&createStart=" . ($createStart + $create_per_page_img) . "'>Next&gt&gt</a></td>";
                    echo "</tr>";
                }
                ?>

            </table>
        </div>

        <div id="joined_events">
            <h2>Joined Events</h2>
            <?php


            if (isset($_GET['joinedPage'])) {
                $joinedPage = $_GET['joinedPage'];
            } else {
                $joinedPage = 1;
            }
            if (isset($_GET['joinedStart'])) {
                $joinedStart = $_GET['joinedStart'];
            } else {
                $joinedStart = 1;
            }


            $query = "SELECT COUNT(*) AS numEvents FROM Final_guests WHERE guest = ?";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            $joinrow = mysqli_fetch_assoc($result);
            $numEvents = $joinrow['numEvents'];
            mysqli_stmt_free_result($stmt);

                //Because all the events a user has joined arent saved in one place relative to hhe user the pagnation doesnt work.
            define("COLS2", 1);
            define("ROWS2", 100);
            $joined_per_page_img = COLS2 * ROWS2;

            $joined_offset = ($joined_per_page_img * $joinedPage) - $joined_per_page_img;
            if (($joined_per_page_img * $joinedPage) > $numEvents) {
                $joinedEnd = $numEvents;
            } else {
                $joinedEnd = $joined_per_page_img * $joinedPage;
            }

            $query = "SELECT Event_id from Final_guests where guest = ?";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            mysqli_stmt_free_result($stmt);

            ?>

            <p id="eventCount">Displaying
                <?= $joinedStart ?> to
                <?= $joinedEnd ?> of
                <?= $numEvents ?> Events
            </p>
            <table id="eventTable">

                <?php

                while ($joinrow = mysqli_fetch_assoc($result)) {
                    $query = "SELECT name, description, thumbnail, host from Final_Events where Event_id = ?";
                    $stmt = mysqli_prepare($dbc, $query);
                    mysqli_stmt_bind_param($stmt, 's', $joinrow['Event_id']);
                    mysqli_stmt_execute($stmt);
                    $result2 = mysqli_stmt_get_result($stmt);
                    $row2 = mysqli_fetch_assoc($result2);
                    echo "<tr>";
                    echo "<td class = 'eventPost'><img src='show_image.php?email=" . $row2['host'] . "&image=" . $row2['thumbnail'] . "' alt='" . $row2["thumbnail"] . "' width='80' height='54'>";
                    echo "<div class='eventPostDescription'>";
                    echo "<h3>Host: " . $row2['host'] . "</h3>";
                    echo "<h3>Title: " . $row2['name'] . "</h3>";
                    echo "<span>Description: " . $row2['description'] . "</span>";
                    echo "</div>";
                    echo "</td>";
                    echo "</tr>";
                }
                ?>
            </table>
            <table id=pagTable>
                <?php
                if ($joinedPage == 1 && ($numEvents > $joined_per_page_img)) {
                    echo "<tr>";
                    echo "<td></td><td class = 'next'><a href='my_events.php?joinedPage=" . ($joinedPage + 1) . "&joinedStart=" . ($joinedStart + $joined_per_page_img) . "'>Next&gt&gt</a></td>";
                    echo "</tr>";
                } elseif ($joinedPage == 1 && ($numEvents <= $joined_per_page_img)) {
                    echo "";
                } elseif ($joinedPage > 1 && ($joinedStart + $joined_per_page_img > $numEvents)) {
                    echo "<tr>";
                    echo "<td class = 'back'><a href='my_events.php?joinedPage=" . ($joinedPage - 1) . "&joinedStart=" . ($joinedStart - $joined_per_page_img) . "'>&lt&ltPrev</a></td><td></td>";
                    echo "</tr>";
                } else {
                    echo "<tr>";
                    echo "<td class= 'back'><a href='my_events.php?joinedPage=" . ($joinedPage - 1) . "&joinedStart=" . ($joinedStart - $joined_per_page_img) . "'>&lt&ltPrev</a></td><td class = 'next'><a href='my_events.php?joinedPage=" . ($joinedPage + 1) . "&joinedStart=" . ($joinedStart + $joined_per_page_img) . "'>Next&gt&gt</a></td>";
                    echo "</tr>";
                }
                ?>

            </table>
        </div>
    </section>
</main>

<?php include './includes/footer.php'; ?>