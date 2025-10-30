package org.example.bmi_app_localization;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label lblWeight;
    @FXML
    private TextField tfWeight;
    @FXML
    private Label lblHeight;
    @FXML
    private TextField tfHeight;
    @FXML
    private Button btnCalculate;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblResultNum;
    @FXML
    private Label lblInvalid;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;

    private ResourceBundle rb;

    public void initialize(){
        onLoadLanguage("en", "US");
    }

    public void onLoadLanguage(String language, String country){
        Locale mylocale = new Locale(language, country);
        rb = ResourceBundle.getBundle("MessagesBundle", mylocale);
        lblWeight.setText(rb.getString("lblWeight"));
        lblHeight.setText(rb.getString("lblHeight"));
        btnCalculate.setText(rb.getString("btnCalculate"));
        lblResult.setText(rb.getString("lblResult"));
        lblInvalid.setText(rb.getString("lblInvalid"));
        button1.setText(rb.getString("button1"));
        button2.setText(rb.getString("button2"));
        button3.setText(rb.getString("button3"));
        button4.setText(rb.getString("button4"));
    }
    public void onCalculateClick(ActionEvent actionEvent) {
        String weight = tfWeight.getText();
        Double weightDouble = Double.parseDouble(weight);
        String height = tfHeight.getText();
        Double heightDouble = Double.parseDouble(height);
        Double result = weightDouble / (heightDouble * heightDouble);
        System.out.println(result);
        DecimalFormat df = new DecimalFormat("#.##");
        String resultStr = df.format(result);
        lblResultNum.setText(resultStr);
    }

    public void onENClick(ActionEvent actionEvent) {
        onLoadLanguage("en", "US");
    }

    public void onFRCClick(ActionEvent actionEvent) {
        onLoadLanguage("fr", "FR");
    }

    public void onURClick(ActionEvent actionEvent) {
        onLoadLanguage("ur", "PA");
    }

    public void onVIClick(ActionEvent actionEvent) {
        onLoadLanguage("vi", "VI");
    }
}