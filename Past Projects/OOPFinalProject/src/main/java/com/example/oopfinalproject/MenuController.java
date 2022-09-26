package com.example.oopfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;


public class MenuController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    Double total = (0.00);


    @FXML
    private SplitMenuButton Apps_Menu;

    @FXML
    private MenuItem Arroz_Con_Camarones_Item;

    @FXML
    private MenuItem Camarones_Rancheros_Item;

    @FXML
    private MenuItem Chori_Pollo_Tacos_Item;

    @FXML
    private MenuItem Coca_cola_Item;

    @FXML
    private MenuItem Drink_SizeLarge_Item;

    @FXML
    private MenuItem Drink_SizeMedium_Item;

    @FXML
    private MenuItem Drink_SizeSmall_Item;

    @FXML
    private SplitMenuButton Drink_menu_size;

    @FXML
    private SplitMenuButton Drinks_Menu;

    @FXML
    private MenuItem El_Cerro_Enchiladas_Item;

    @FXML
    private MenuItem Fajita_Nachos_Item;

    @FXML
    private MenuItem Fajita_Taco_Salad_Item;

    @FXML
    private MenuItem Fries_item;

    @FXML
    private MenuItem Green_Burrito_Item;

    @FXML
    private MenuItem HI_C_Item;

    @FXML
    private SplitMenuButton Main_Course_Menu;

    @FXML
    private MenuItem Minute_maid_item;

    @FXML
    private MenuItem Mountain_dew_Item;

    @FXML
    private MenuItem Pepsi_Item;

    @FXML
    private MenuItem Shrimp_Quesadillas_Item;

    @FXML
    private MenuItem Sopa_De_Pollo_Item;

    @FXML
    private MenuItem Sprite_Item;

    @FXML
    private Button Submit_Button;

    @FXML
    private MenuItem Sweet_Tea_Item;

    @FXML
    private MenuItem Taco_Salad_Item;

    @FXML
    private TextField Tip_textField;

    @FXML
    private MenuItem Water_Item;

    @FXML
    private MenuItem Wings_Item;

    @FXML
    private Button back_button;

    @FXML
    private Button card_button;

    @FXML
    private TextArea cart_textArea;

    @FXML
    private Button cash_button;

    @FXML
    private TextField change_TextField;

    @FXML
    private MenuItem elote_item;

    @FXML
    private MenuItem frita_item;

    @FXML
    private MenuItem guacamole_item;

    @FXML
    private TextField payment_TextField;

    @FXML
    private MenuItem queso_item;

    @FXML
    private MenuItem salad_item;

    @FXML
    private MenuItem soup_item;

    @FXML
    private TextArea tab_TextArea;

    @FXML
    private TextField time_TextField;

    @FXML
    private TextField total_Textfield;


    @FXML
    void Arroz_Con_Camarones_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Arroz Con Camarones $15.00\n");
        total = total + 15;
        total_Textfield.setText(Double.toString(total));

    }

    @FXML
    void Camarones_Rancheros_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Camarones Rancheros $15.00\n");
        total = total + 15;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Card_Button_Clicked(ActionEvent event) {
        time_TextField.setText("7-10");
        try {
            BigDecimal payment = new BigDecimal (payment_TextField.getText());
            BigDecimal total = new BigDecimal (total_Textfield.getText());
            BigDecimal change = payment.subtract(total, new MathContext(2));

            change_TextField.setText(currency.format(change));
        }
        catch(NumberFormatException ex){
            payment_TextField.setText("please Enter A Dollar Amount");
            payment_TextField.selectAll();
            payment_TextField.requestFocus();
        }

    }

    @FXML
    void Cash_Button_Clicked(ActionEvent event) {
        time_TextField.setText("7-10");
        try {
            BigDecimal payment = new BigDecimal (payment_TextField.getText());
            BigDecimal total = new BigDecimal (total_Textfield.getText());
            BigDecimal change = payment.subtract(total, new MathContext(2));

            change_TextField.setText(currency.format(change));
        }
        catch(NumberFormatException ex){
            payment_TextField.setText("please Enter A Dollar Amount");
            payment_TextField.selectAll();
            payment_TextField.requestFocus();
        }

    }

    @FXML
    void Chori_Pollo_Tacos_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Chori Pollo Tacos $13.00\n");
        total = total + 13;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Coca_cola_Item_clicked(ActionEvent event) {
        cart_textArea.appendText("Coca cola\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Drink_SizeLarge_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Large Drink $2.00\n");
        total = total + 2;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Drink_SizeMedium_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Medium Drink $1.50\n");
        total = total + 1.50;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Drink_SizeSmall_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Small Drink $1.00\n");
        total = total + 1;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void El_Cerro_Enchiladas_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("El Cerro Enchiladas $12.00\n");
        total = total + 12;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Fajita_Nachos_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Fajita Nachos $13.00\n");
        total = total + 13;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Fajita_Taco_Salad_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Fajita Taco Salad $12.00\n");
        total = total + 12;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Fries_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Carne Asada Fries $10.00\n");
        total = total + 10;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Green_Burrito_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Green Burrito $12.00\n");
        total = total + 12;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void HI_C_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("HI-C\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Minute_maid_item_clicked(ActionEvent event) {
        cart_textArea.appendText("Minute Maid\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Mountain_dew_Item_clicked(ActionEvent event) {
        cart_textArea.appendText("Mountain Dew\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Pepsi_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Pepsi\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Shrimp_Quesadillas_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Shrimp Quesadillas $12.00\n");
        total = total + 12;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Sopa_De_Pollo_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Sopa De Pollo $8.00\n");
        total = total + 8;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Sprite_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Sprite\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Submit_Button_Clicked(ActionEvent event) {
        String text_field = cart_textArea.getText();
        tab_TextArea.appendText(text_field);
    }

    @FXML
    void Sweet_Tea_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Sweet Tea\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Taco_Salad_Clicked(ActionEvent event) {
        cart_textArea.appendText("Taco Salad $10.00\n");
        total = total + 10;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Water_Item_clicked(ActionEvent event) {
        cart_textArea.appendText("Water\n");
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void Wings_Item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Buffalo Wings $12.00\n");
        total = total + 12;
        total_Textfield.setText(Double.toString(total));
    }


    @FXML
    void back_Button_Clicked(ActionEvent event) {
        total = 0.0;
        cart_textArea.setText("");
        tab_TextArea.setText("");
        payment_TextField.setText("");
        change_TextField.setText("");
        total_Textfield.setText("");
        time_TextField.setText("");
        Tip_textField.setText("");
    }

    @FXML
    void elote_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Mexican Street Corn $6.00\n");
        total = total + 6;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void frita_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Avocado Frita $8.00\n");
        total = total + 8;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void guacamole_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Guacamole and chips $7.00\n");
        total = total + 7;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void queso_item_clicked(ActionEvent event) {
        cart_textArea.appendText("Queso and Chips $5.00\n");
        total = total + 5;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void salad_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Garden Salad $7.00\n");
        total = total + 7;
        total_Textfield.setText(Double.toString(total));
    }

    @FXML
    void soup_item_Clicked(ActionEvent event) {
        cart_textArea.appendText("Chicken Tortilla Soup Bowl $9.00\n");
        total = total + 9;
        total_Textfield.setText(Double.toString(total));
    }

}
