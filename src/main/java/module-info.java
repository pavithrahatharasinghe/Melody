module com.example.melody {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.melody to javafx.fxml;
    exports com.example.melody;
}