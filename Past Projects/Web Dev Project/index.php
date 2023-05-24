<!--Johnathan Smith-->
<?php require './includes/header.php'; ?>

<main>
  <section>
    <div class="wrap">
      <h1>What is Event It?</h1>
      <p>
        Event it is a one stop shop for everything to do with an event that a
        user plans. As a user you will be able to create events which have
        their own pages.
      </p>

      <!-- Slideshow container -->
      <div class="slideshow-container">

        <?php
        $dir = "./images"; // Define the directory to view.
        $files = scandir($dir); // Read all the images into an array.
        $start = 1;
        $final = 0;
        foreach ($files as $image) {
          if (substr($image, 0, 1) != '.') {
            $final += 1;
          }
        }

        foreach ($files as $image) {
          if (substr($image, 0, 1) != '.') { ?>
            <div class="mySlides fade"
            <?php 
            if ($start == 1) {
              ?>style="display:block"<?php
            } else {
              ?>style="display:none"<?php
            }
            ?>
            >
              <div class="numbertext"><?=$start?> / <?=$final?></div>
              <img src="./images/<?=$image?>" style="width:100%">
            </div>
            <?php
            $start +=1;
          }
        }
        ?>

        <!-- Next and previous buttons -->
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
      <br>

      <!-- The dots/circles -->
      <div style="text-align:center">
      <?php
      $dot_count =1;
      foreach ($files as $image) {
        if (substr($image, 0, 1) != '.') {
          ?>
          <span
          <?php
          if ($dot_count == 1) {
            ?>class="dot active"<?php
          } else {
            ?>class="dot"<?php
          }
          ?>
          onclick="currentSlide(<?=$dot_count?>)"></span>
          <?php
          $dot_count +=1;
        }
      }
      ?>
      </div>

      <form>
        <input type="button" value="Print" onClick="window.print()" />
      </form>
    </div>
  </section>
</main>

<?php include './includes/footer.php'; ?>