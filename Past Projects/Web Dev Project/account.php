<?php require './includes/header.php';
require_once '../../mysqli_connect.php';

$sql = "SELECT firstName, lastName, emailAddr, why FROM Final_reg_users WHERE emailAddr = ?";
$stmt = mysqli_prepare($dbc, $sql);
mysqli_stmt_bind_param($stmt, 's', $_SESSION['email']);
mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);
$result = mysqli_fetch_assoc($result);

if (!isset($_SESSION['email'])) {
    echo "<main>";
    echo "<h2>We are sorry, but you must be logged in as a registered user</h2>";
    echo "<h3>Use the Register link to create an account</h2></main>";
    include('./includes/footer.php');
    exit;
  }
?>

<main>
    <section>
        <div class="wrap">
            <h2>Account Information</h2>
            <p>
                Firstname:
                <?= $result['firstName'] ?>
            </p>
            <p>
                Lastname:
                <?= $result['lastName'] ?>
            </p>
            <p>
                Email:
                <?= $result['emailAddr'] ?>
            </p>
            <p>
                Why you joined:
                <?= $result['why'] ?>

            </p>
        </div>
    </section>
</main>

<?php include './includes/footer.php'; ?>