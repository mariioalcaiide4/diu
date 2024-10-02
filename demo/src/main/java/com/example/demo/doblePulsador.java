package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

public class doblePulsador extends Application {
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

        //Creamos los contadores que vamos a utilizar

        pulsador contador = new pulsador();
        pulsador contador2 = new pulsador();

        // Creamos las escenas que vamos a utilizar para los contadores ya creados

        Stage escenario1 = new Stage();
        contador.start(escenario1);

        Stage escenario2 = new Stage();
        contador2.start(escenario2);

        contador.numPulsacionesProperty().bindBidirectional(contador2.numPulsacionesProperty());



    }
}
