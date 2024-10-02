package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class chivato extends Application{
    @Override
    public void start(Stage escenarioPrincipal){
        try {
           BorderPane raiz = new BorderPane();
           raiz.setStyle("fx-base: #ffe4c4;"
           + " -fx-background-image: url('furbo.jpg');"
           + " -fx-background-position: center;"
           + " -fx-background-repeat: no-repeat;");

           HBox hbBotones = new HBox(10);
           hbBotones.setPadding(new Insets(10));
           hbBotones.setAlignment(Pos.CENTER_RIGHT);
           Button btAceptar, btCancelar;
           btCancelar = new Button("Cancelar");
           btCancelar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
           btAceptar = new Button("Aceptar");
           btAceptar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
           hbBotones.getChildren().addAll(btAceptar, btCancelar);

           raiz.setBottom(hbBotones);

           Scene escena = new Scene(raiz, 500, 500);
           escenarioPrincipal.setTitle("Estilos");
           escenarioPrincipal.setScene(escena);
           escenarioPrincipal.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }


}
