module com.example.melody {
    requires javafx.controls;
    requires javafx.fxml;
    requires mp3agic;
    requires java.desktop;


    opens com.example.melody to javafx.fxml;
    exports com.example.melody;
}