package org.example.bmi_app_localization;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map;
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

    private Map<String, String> localizedStrings;

    public void initialize(){
        onLoadLanguage("en", "US");
    }

    public void onLoadLanguage(String language, String country){
        Locale mylocale = new Locale(language, country);

        lblResult.setText("");
        localizedStrings = LocalizationService.getLocalizedStrings(mylocale);
        lblWeight.setText(localizedStrings.getOrDefault("weight", "Weight"));
        lblHeight.setText(localizedStrings.getOrDefault("height", "Height"));
        btnCalculate.setText(localizedStrings.getOrDefault("calculate", "Calculate"));

    }
    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            String weight = tfWeight.getText();
            Double weightDouble = Double.parseDouble(weight);
            String height = tfHeight.getText();
            Double heightDouble = Double.parseDouble(height);
            Double result = weightDouble / (heightDouble * heightDouble);
            System.out.println(result);
            DecimalFormat df = new DecimalFormat("#.##");
            lblResult.setText(localizedStrings.getOrDefault("result", "Your BMI is"));
            String resultStr = df.format(result);
            lblResultNum.setText(resultStr);

            // Save to database
            String language = Locale.getDefault().getLanguage(); // or store current locale
            BMIResultService.saveResult(weightDouble, heightDouble, result, language);

        } catch (NumberFormatException e) {
            lblResult.setText(localizedStrings.getOrDefault("invalid", "Invalid input"));
        }
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