module com.example.scenebuilder20 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.scenebuilder20 to javafx.fxml;
    exports com.example.scenebuilder20;
    exports com.example.scenebuilder20.controller;
    opens com.example.scenebuilder20.controller to javafx.fxml;
}