<?php 
include_once '../secure_conn.php';
require 'includes/header.php';
if (isset($_POST['send'])) {
	$errors = array();
	
	$email= filter_var(trim($_POST['email']), FILTER_SANITIZE_EMAIL);
	if (empty($email))
		$errors['email'] = 'An email address is required:';
	else {

		$valid_email = filter_var($email, FILTER_VALIDATE_EMAIL);	
		if ($valid_email)
			$email = $valid_email;
		else
			$errors['email'] = 'A valid email is required:';
	}
	
	$password = filter_var(trim($_POST['password']), FILTER_SANITIZE_STRING);
	if (empty($password))
		$errors['pw']= "A password is required";

	while (!$errors){ 
		require_once ('../../mysqli_connect.php'); 
	
		$sql = "SELECT firstName, emailAddr, pw, folder FROM Final_reg_users WHERE emailAddr = ?";
		$stmt = mysqli_prepare($dbc, $sql);
		mysqli_stmt_bind_param($stmt, 's', $email);
		mysqli_stmt_execute($stmt);
		$result=mysqli_stmt_get_result($stmt);
		$rows = mysqli_num_rows($result);
		if ($rows==0) 
			$errors['no_email'] = "That email address wasn't found";
		else { 
			$result2=mysqli_fetch_assoc($result); 
			$pw_hash=$result2['pw'];
			if (password_verify($password, $pw_hash )) { 
				$firstName = $result2['firstName'];

				$email = $result2['emailAddr'];
				$folder = $result2['folder'];
				session_destroy();
				session_start();
				$_SESSION['fname'] = $firstName;
				$_SESSION['email'] = $email;
				$_SESSION['folder'] = $folder;

				header('Location: logged_in.php');

				
				exit;
			}
			else {
				$errors['wrong_pw'] = "That isn't the correct password";
			}
		} 
	   } 	
} 
?>
	<main>
		<section>
			<div class="wrap">
        <form method="post" action="login.php">
			<fieldset>
				<legend>Registered Users Login</legend>
				<?php 

            	if ($errors['email']) 
                    echo "<div style='color: Red; font-weight: bold;'>{$errors['email']}</div>"; 
				if ($errors['no_email']) 
                    echo "<div style='color: Red; font-weight: bold;'>{$errors['no_email']}</div>";
				?>
			 <p>	
                <label for="email">Email: </label>
                <input name="email" id="email" type="text"
				<?php if (isset($email) &&!$errors['no_email']) {
                    echo 'value="' . htmlspecialchars($email) . '"';
                } ?>>
            </p>
				<?php if ($errors['pw']) 
                    echo "<div style='color: Red; font-weight: bold;'>{$errors['pw']}</div>";
                   
					if ($errors['wrong_pw']) 
                    echo "<div style='color: Red; font-weight: bold;'>{$errors['wrong_pw']}</div>";
				?>
            <p>                    
                <label for="pw">Password: </label>
                <input name="password" id="pw" type="password">
            </p>
            <p>
                <input name="send" type="submit" value="Login">
            </p>
		</fieldset>
        </form>
		</div>
		</section>
	</main>
<?php include './includes/footer.php'; ?>