<?php 
	include_once '../reg_conn.php';
	session_start();
	if (isset($_SESSION['email']))  {
		$firstname = $_SESSION['fname'];
		$message = "Welcome back $firstname";
		$message2 = "You are now logged in";
	} else { 
		$message = 'You have reached this page in error';
		$message2 = 'Please use the menu at the right';	
	}
require 'includes/header.php';
?>
	<main>
	<?php 
		// Print the message:
		echo '<h2>'.$message.'</h2>';
		echo '<h3>'.$message2.'</h3>';
		?>
	</main>
	<?php // Include the footer and quit the script:
	include ('./includes/footer.php'); 
	?>
	