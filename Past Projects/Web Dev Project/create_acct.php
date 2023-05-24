<?php
// ini_set('display_errors', 1);

require_once '../secure_conn.php';

require 'includes/header.php';

if (isset($_POST['submit'])) {
    $errors = array();

    $firstname = filter_var(trim($_POST['firstname']), FILTER_SANITIZE_STRING);
    if (empty($firstname))
        $errors['firstname'] = "First name is required";

    $lastname = filter_var(trim($_POST['lastname']), FILTER_SANITIZE_STRING);
    if (empty($lastname))
        $errors['lastname'] = "Last name is required";

    $email = filter_var(trim($_POST['email']), FILTER_SANITIZE_EMAIL);
    if (empty($email)) {
        $errors['email'] = 'An email address is required:';
    } else {
        //check validity
        $valid_email = filter_var($email, FILTER_VALIDATE_EMAIL);
        if ($valid_email)
            $email = $valid_email;
        else
            $errors['email'] = 'A valid email is required:';
    }
    require_once '../../mysqli_connect.php'; //$dbc is the connection string set upon successful connection
    $sql = "SELECT emailAddr from Final_reg_users where emailAddr = ?";
    $stmt = mysqli_prepare($dbc, $sql);
    mysqli_stmt_bind_param($stmt, 's', $email);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    if (mysqli_num_rows($result) >= 1)
        $errors['exists'] = 'That email already exists in the database. Please log in or enter a different email';
    mysqli_free_result($result);

    $password1 = filter_var(trim($_POST['password1']), FILTER_SANITIZE_STRING);
    $password2 = filter_var(trim($_POST['password2']), FILTER_SANITIZE_STRING);
    // Check for a password:
    if (empty($password1) || empty($password2))
        $errors['pw'] = "Please enter the password twice";
    elseif ($password1 !== $password2)
        $errors['pwmatch'] = "The passwords don't match";
    else
        $password = $password1;

    $why = filter_var($_POST['Uintention']);

    $accepted = filter_var($_POST['terms']);
    if (empty($accepted) || $accepted != 'accepted')
        $errors['accepted'] = "You must accept the terms";

    if (!$errors) {

        //create user upload folder
		//Folder name is email stripped of non-alphanumeric characters
		$folder = preg_replace("/[^a-zA-Z0-9]/", "", $email);
		// make lowercase
		$folder = strtolower($folder);

        $sql2 = "INSERT into Final_reg_users (firstName, lastName, emailAddr, pw, why, folder) VALUES (?, ?, ?, ?, ?, ?)";
        $stmt2 = mysqli_prepare($dbc, $sql2);
        $pw_hash = password_hash($password, PASSWORD_DEFAULT);
        mysqli_stmt_bind_param($stmt2, 'ssssss', $firstname, $lastname, $email, $pw_hash, $why, $folder);
        mysqli_stmt_execute($stmt2);
        if (mysqli_stmt_affected_rows($stmt2)) {

            $dirPath = "../../user_thumbs/" . $folder;
            mkdir($dirPath, 0777);
			session_destroy();
			session_start();
			$_SESSION['email'] = $email;
			$_SESSION['fname'] = $firstname;
			$_SESSION['lname'] = $lastname;
			$_SESSION['folder'] = $folder;
			header('Location: acct_created.php');


        } else {
            echo "<main><h2>We're sorry. We are unable to add your account at this time.</h2><h3>Please try again later</h3></main>";
        }
        include 'includes/footer.php';
        exit;
    } // no errors
}
?>

<main>
    <section>
        <div class="wrap">
    <form method="post" action="create_acct.php">
        <fieldset>
            <legend>Create an Account</legend>

            <?php
            if ($errors['firstname'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['firstname']}</div>";
            ?>
            <p>
                <label for="fn">First Name:</label>
                <input type="text" name="firstname" id="fn" <?php
                if (isset($firstname))
                    echo 'value="' . htmlspecialchars($firstname) . '"';
                ?>>
            </p>

            <?php
            if ($errors['lastname'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['lastname']}</div>";
            ?>
            <p>
                <label for="ln">Last Name:</label>
                <input type="text" name="lastname" id="ln" <?php
                if (isset($lastname))
                    echo 'value="' . htmlspecialchars($lastname) . '"';
                ?>>
            </p>

            <?php
            if ($errors['email'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['email']}</div>";
            if ($errors['exists'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['exists']}</div>";
            ?>
            <p>
                <label for="email">Email:</label>
                <input type="text" name="email" id="email" <?php
                if (isset($email))
                    echo 'value="' . htmlspecialchars($email) . '"';
                ?>>
            </p>

            <?php
            if ($errors['pw'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['pw']}</div>";
            if ($errors['pwmatch'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['pwmatch']}</div>";
            ?>

            <p>
                <label for="pw1">Password: </label>
                <input name="password1" id="pw1" type="password">
            </p>
            <p>
                <label for="pw2">Confirm Password: </label>
                <input name="password2" id="pw2" type="password">
            </p>

            <p>
                <label for="intention">Why Event It?</label>
                <select name="Uintention" id="intention">
                    <option value="-">-</option>
                    <option value="post">Post Events</option>
                    <option value="join">Join Events</option>
                    <option value="browse">Browse Events</option>
                </select>
            </p>

            <?php if ($errors['accepted'])
                echo "<div style='color: Red; font-weight: bold;'>{$errors['accepted']}</div>"; ?>
            <p>

                <input style="float: left" type="checkbox" name="terms" value="accepted" id="terms" <?php if ($accepted) {
                    echo 'checked';
                } ?>> <label for="terms">I accept the terms of using this website</label>
            </p>



        </fieldset>
        <p><input style = "clear: both" type="submit" name="submit" value="Sign Up"></p>
    </form>
    </div>
    </section>
</main>

<?php
include 'includes/footer.php';
?>