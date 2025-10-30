module org.example.bmi_app_localization {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bmi_app_localization to javafx.fxml;
    exports org.example.bmi_app_localization;
}