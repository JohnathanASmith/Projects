module com.example.oopfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.oopfinalproject to javafx.fxml;
    exports com.example.oopfinalproject;
}