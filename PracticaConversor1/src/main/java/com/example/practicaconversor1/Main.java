package com.example.practicaconversor1;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main {

    private Stage escenarioPrincipal;
    private AnchorPane conversor;


    public void start(Stage escenarioPrincipal){
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Contador de Monedas");
        initConversor();
    }

    public void initConversor(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/ConversorView.fxml"));
            conversor = (AnchorPane) loader.load();
            Scene scene = new Scene(conversor);
            escenarioPrincipal.setScene(scene);
            escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Stage getEscenarioPrincipal(){
        return escenarioPrincipal;
    }



    }
}

