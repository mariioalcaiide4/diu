package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class hiperenlaces extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox raiz = new VBox();
            raiz.setPadding(new Insets(50));
            raiz.setSpacing(10);

            Label lbElige;
            lbElige = new Label("Puedes visitar los sigueintes enlaces");

            Hyperlink hlEducacion = new Hyperlink("Educación Andalucia");
            Hyperlink hlFPA = new Hyperlink("FPA");
            Hyperlink hlAlAndalus = new Hyperlink("IES Al-Ándalus");

            hlEducacion.setVisited(true);
            hlFPA.setVisited(true);
            hlAlAndalus.setVisited(true);

            VBox.setMargin(hlEducacion, new Insets(0, 0, 0, 30));
            VBox.setMargin(hlFPA, new Insets(0, 0, 0, 30));
            VBox.setMargin(hlAlAndalus, new Insets(0, 0, 0, 30));

            raiz.getChildren().addAll(lbElige, hlEducacion, hlFPA, hlAlAndalus);

            Scene escena = new Scene(raiz, 350, 200);
            escenarioPrincipal.setTitle("Hiperenlaces");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

public static void main(String[] args) {
    launch(args);

    }

}

















