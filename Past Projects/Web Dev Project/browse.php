<?php
require './includes/header.php';
require_once '../../mysqli_connect.php';

if (!isset($_SESSION['email'])) {
    echo "<h2>We are sorry, but you must be logged in as a registered user</h2>";
    echo "<h3>Use the Register link to create an account</h2></main>";
    include('./includes/footer.php');
    exit;
}
?>

<main>
    <section id="users_events">
        <div id="created_events">
            <h2>All Events</h2>
            <h3>Click an image to get to event join page</h3>
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


            $query = "SELECT COUNT(*) AS numEvents FROM Final_Events";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            $row = mysqli_fetch_assoc($result);
            $numEvents = $row['numEvents'];
            mysqli_stmt_free_result($stmt);

            define("COLS", 1);
            define("ROWS", 6);
            $create_per_page_img = COLS * ROWS;

            $create_offset = ($create_per_page_img * $createPage) - $create_per_page_img;
            if (($create_per_page_img * $createPage) > $numEvents) {
                $createEnd = $numEvents;
            } else {
                $createEnd = $create_per_page_img * $createPage;
            }

            $query = "SELECT Event_id, name, description, thumbnail, host from Final_Events LIMIT $create_per_page_img OFFSET $create_offset";
            $stmt = mysqli_prepare($dbc, $query);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            ?>


            <p id="eventCount">Displaying
                <?= $createStart ?> to
                <?= $createEnd ?> of
                <?= $numEvents ?> Events
            </p>
            <table id="eventTable">

                <?php


                while ($row = mysqli_fetch_assoc($result)) {
                    echo "<tr>";
                    echo "<td class = 'eventPost'><a href='join_event.php?host=".$row['host']."&title=".$row['name']."&description=".$row['description']."&event_id=".$row['Event_id']."&thumbnail=".$row['thumbnail']."'><img src='show_image.php?email=".$row['host']."&image=" . $row['thumbnail'] . "' alt='" . $row["thumbnail"] . "' width='80' height='54'></a>";
                    echo "<div class='eventPostDescription'>";
                    echo "<h3>Host: " . $row['host'] . "</h3>";
                    echo "<h3>Title: " . $row['name'] . "</h3>";
                    echo "<span>Description: " . $row['description'] . "</span>";
                    echo "</div>";
                    echo "</td>";
                    echo "</tr>";
                }

                ?>
            </table>
            <table id=pagTable>
                <?php
                if ($createPage == 1 && ($numEvents > $create_per_page_img)) {
                    echo "<tr>";
                    echo "<td></td><td class = 'next'><a href='my_events.php?createPage=" . ($createPage + 1) . "&createStart=" . ($createStart + $create_per_page_img) . "'>Next&gt&gt</a></td>";
                    echo "</tr>";
                } elseif ($createPage == 1 && ($numEvents <= $create_per_page_img)) {
                    echo "";
                } elseif ($createPage > 1 && ($createStart + $create_per_page_img > $numEvents)) {
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
    </section>
</main>

<?php include './includes/footer.php'; ?>