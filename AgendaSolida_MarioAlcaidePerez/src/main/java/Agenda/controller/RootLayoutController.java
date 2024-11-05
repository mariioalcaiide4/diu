package Agenda.controller;

import Agenda.modelo.ExcepcionPersona;
import javafx.fxml.FXML;

public class RootLayoutController {
    MainApp agenda=new MainApp();

    public RootLayoutController() throws ExcepcionPersona {
    }

    @FXML
    private void handleShowBirthdayStatistics() {
        agenda.showBirthdayStatistics();
    }
}
