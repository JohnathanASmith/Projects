<?php
require "./includes/header.php";
if (!isset($_SESSION['email'])) {
    echo "<main>";
    echo "<h2>We are sorry, but you must be logged in as a registered user</h2>";
    echo "<h3>Use the Register link to create an account</h2></main>";
    include('./includes/footer.php');
    exit;
  }
echo "<main><h1>Admins Only</h1>";
require_once('../../mysqli_connect.php'); //Connect to the database
if (isset($_POST['submit'])) {
    $email = filter_var(trim($_POST['email']));
    $folder = preg_replace("/[^a-zA-Z0-9]/", "", $email);
    // make lowercase:
    $folder = strtolower($folder);
    echo "$folder<br>";

    $dir = "../../user_thumbs/$folder"; // Define the directory to view.
    echo "$dir";
    $files = scandir($dir); // Read all the images into an array.
    foreach ($files as $image) {
        echo $image;
        if (substr($image, 0, 1) != '.') { // Ignore anything starting with a period.
            $image_loc = "../../user_thumbs/$folder/$image";
            chmod($image_loc, 0777);
            unlink($image_loc);
        } // End IF.
    } // End foreach loop.
    //Also, optinally, delete the empty folder
    //rmdir($dir);
    //Then delete the user image data
    echo "$email";

    $sql = "DELETE FROM Final_events WHERE host = '$email'";
    $result = mysqli_query($dbc, $sql);
    if ($result)
        echo "<h2>Files successfully deleted</h2></main>";
    else
        echo "<h2>There was a problem deleting the data</h2></main>";
    include "./includes/footer.php";
    exit;
} ?>
<form method="post" action="delete_events.php">
    <fieldset>Delete a user's uploads folder</fieldset>
    <label>Select the email address of the user's images to be deleted:
        <select name="email">
            <?php
            $sql = "SELECT emailAddr FROM Final_reg_users";
            $result = mysqli_query($dbc, $sql);
            if ($result) {
                while ($row = mysqli_fetch_assoc($result))
                    echo "<option>{$row['emailAddr']}</option>";
            } else {
                echo "We are unable to process your request at  this  time. Please try again later.";
                include 'includes/footer.php';
                exit;
            } ?>
        </select>
    </label><br>
    <input type="submit" name="submit" value="Delete this user's images and image data">
</form>
</main>
<?php include "./includes/footer.php"; ?>