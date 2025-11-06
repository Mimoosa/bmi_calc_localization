module org.example.bmi_app_localization {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.bmi_app_localization to javafx.fxml;
    exports org.example.bmi_app_localization;
}