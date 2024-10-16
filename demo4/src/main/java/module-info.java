module paquete.demo4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens paquete.demo4 to javafx.fxml;
    exports paquete.demo4;
}