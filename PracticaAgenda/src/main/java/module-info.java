module pack.scenebuilder {
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
    requires java.sql;

    opens Agenda to javafx.fxml;
    opens Agenda.controller to javafx.fxml;
    opens Agenda.modelo to javafx.fxml;

    exports Agenda.controller;
    exports Agenda.modelo;
    exports Agenda.modelo.repository;
    opens Agenda.modelo.repository to javafx.fxml;
    exports Agenda.modelo.repository.impl;
    opens Agenda.modelo.repository.impl to javafx.fxml;
    exports Agenda.view;
    opens Agenda.view to javafx.fxml;
}
