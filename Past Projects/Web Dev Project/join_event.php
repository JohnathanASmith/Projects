<?php
require './includes/header.php';
require_once '../../mysqli_connect.php';
//ini_set('display_errors', 1);
if (!isset($_SESSION['email'])) {
  echo "<main>";
  echo "<h2>We are sorry, but you must be logged in as a registered user</h2>";
  echo "<h3>Use the Register link to create an account</h2></main>";
  include('./includes/footer.php');
  exit;
}


if (isset($_POST['submit'])) {
  $sql = "INSERT into Final_guests (Event_id, guest) VALUES (?, ?)";
  $stmt = mysqli_prepare($dbc, $sql);
  $email = $_SESSION['email'];
  mysqli_stmt_bind_param($stmt, 'is', $_GET['event_id'], $email);
  mysqli_stmt_execute($stmt);
}


?>

<main>
  <section>
    <div id="created_events">
      <h2>Event</h2>

      <table id="eventTable">

        <?php
        echo "<tr>";
        echo "<td class = 'eventPost'><img src='show_image.php?email=" . $_GET['host'] . "&image=" . $_GET['thumbnail'] . "' alt='" . $_GET["thumbnail"] . "' width='80' height='54'>";
        echo "<div class='eventPostDescription'>";
        echo "<h3>Host: " . $_GET['host'] . "</h3>";
        echo "<h3>Title: " . $_GET['title'] . "</h3>";
        echo "<span>Description: " . $_GET['description'] . "</span>";
        echo "</div>";
        echo "</td>";
        echo "</tr>";
        ?>
      </table>


      <?php

      $query = "SELECT guest from Final_guests where Event_id = ?";
      $stmt = mysqli_prepare($dbc, $query);
      mysqli_stmt_bind_param($stmt, 'i', $_GET['event_id']);
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);
      mysqli_stmt_free_result($stmt);
      $rows = mysqli_num_rows($result);

      $guests = array();
      $attending = false;

      while ($row = mysqli_fetch_assoc($result)) {
        array_push($guests, $row['guest']);
        if ($row['guest'] == $_SESSION['email']) {
          $attending = true;
          
        }
      }

      if (!$attending) {
        ?>
        <form
        action="join_event.php?host=<?= $_GET['host'] ?>&title=<?= $_GET['title'] ?>&description=<?= $_GET['description'] ?>&event_id=<?= $_GET['event_id'] ?>&thumbnail=<?= $_GET['thumbnail'] ?>"
        method="post">
        <label for="submit">Join Event by pressing
        <input type="submit" name="submit" value="Submit" id="submit"></label>
        </form>
        <?php
        if ($rows == 0) {?>
          <h3>Nobody has joined this event</h3>
        <?php  
        } else {?>
        <h2>Guests</h2>
        <?php
        foreach ($guests as $guest) {
          echo $guest;
          echo "<br>";
        }
        }
      } else {?>
        <h3>Already part of this Event</h3>
        <h2>Guests</h2>
        <?php 
        foreach ($guests as $guest) {
          echo $guest;
          echo "<br>";
        }
      }


      ?>
    </div>
  </section>
</main>

<?php include './includes/footer.php'; ?>