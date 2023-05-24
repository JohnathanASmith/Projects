<?php
session_start();
include './includes/title.php';
echo '<script src="./js/tooltip.js"></script>';
echo '<script src="./js/slideshow.js"></script>';
//ini_set('display_errors', 1);
$currentPage = basename($_SERVER['SCRIPT_FILENAME']);
require_once('../../mysqli_connect.php');
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="description"
        content="Need a platform to plan, find or discover events? Try Event it! Create an account an start planning, joining and discovering events for you!">
    <meta name="keywords" content="Plan, Discover, Event, Social, Connect">
    <title>Event It
        <?php if (isset($title)) {
            echo "&mdash;$title";
        } ?>
    </title>
    <link rel="stylesheet" href="styles/main.css" />
    <?php
    if ($currentPage == 'create_acct.php' || $currentPage == 'login.php' || $currentPage == 'create_event.php' || $currentPage == 'admin_upload.php') { ?>
        <link rel="stylesheet" href="styles/form.css">
    <?php }
    ?>
    <?php if (!isset($_SESSION['email'])) { ?>
        <link rel="stylesheet" href="styles/logged_out.css">
    <?php }
    $sql = "SELECT emailAddr from Final_admin_users where emailAddr = ?";
    $stmt = mysqli_prepare($dbc, $sql);
    mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    if (mysqli_num_rows($result) >= 1) { ?>
        <link rel="stylesheet" href="styles/admin.css">
        <?php
    }

    if ($currentPage == 'index.php') {?>
        <link rel="stylesheet" href="styles/slideshow.css">
    <?php
    }
    ?>
    <link rel="stylesheet" href="styles/mediaq.css" />

</head>

<body>
    <header class="tooltip-container">
        <a href="index.php"><img src="images/EventLogo.jpg" alt="EventLogo" width="100" height="100" /></a>
        <h2 id="tooltip-button">Event It</h2>
        <p id="tooltip-text">You should make and event!!!</p>
    </header>

    <?php
    $currentPage = basename($_SERVER['SCRIPT_FILENAME']); ?>

    <nav id="main_nav">
        <ul>
            <li><a href="index.php" <?php if ($currentPage == 'index.php') {
                echo 'class="current"';
            } ?>>Home</a></li>
            <?php
            if (isset($_SESSION['email'])) {
                ?>
                <li><a href="my_events.php" <?php if (($currentPage == 'create_event.php') || ($currentPage == 'my_events.php')) {
                    echo 'class="current"';
                } ?>>My Events</a>
                    <ul>
                        <li><a href="create_event.php" <?php if ($currentPage == 'create_event.php') {
                            echo 'class="current"';
                        } ?>>Create Event</a></li>
                    </ul>
                </li>
                <li><a href="browse.php" <?php if ($currentPage == 'browse.php') {
                    echo 'class="current"';
                } ?>>Browse</a>
                </li>
                <li><a href="account.php" <?php if ($currentPage == 'account.php') {
                    echo 'class="current"';
                } ?>>Account</a>
                </li>
                <li><a href="logged_out.php" <?php if ($currentPage == 'logged_out.php') {
                    echo 'class="current"';
                } ?>>Log
                        Out</a></li>
                <?php
                if (mysqli_num_rows($result) >= 1) { ?>
                    <li><a href="admin_upload.php" <?php if ($currentPage == 'admin.upload.php') {
                        echo 'class="current"';
                    } ?>>Admin</a></li>

                    <?php
                }

                mysqli_free_result($result);

            } else {
                ?>
                <li><a href="create_acct.php" <?php if ($currentPage == 'create_acct.php') {
                    echo 'class="current"';
                } ?>>Create Account</a></li>
                <li><a href="login.php" <?php if ($currentPage == 'login.php') {
                    echo 'class="current"';
                } ?>>Login</a></li>
                <?php
            }
            ?>
        </ul>
    </nav>