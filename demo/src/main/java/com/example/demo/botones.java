package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class botones extends Application {
    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            HBox raiz = new HBox();
            raiz.setPadding(new Insets(20, 20, 20, 20));
            raiz.setSpacing(10);
            raiz.setAlignment(Pos.CENTER);

            Button btTexto, btTextoImagen, btImagen;
            btTexto = new Button();
            btTextoImagen = new Button();
            btImagen = new Button();

            btTexto.setText("Pulsar");

            Image imagen = new Image("file:resources/litro.jpg", 100, 100, true, true);
            btTextoImagen.setGraphic(new ImageView(imagen));
            btTextoImagen.setText("Beber");
            btTextoImagen.setGraphicTextGap(20);
            btTextoImagen.setFont(Font.font("Ani", 30));

            Image imagen2 = new Image("file:resources/furbo.jpg", 100, 100, true, true);
            btImagen.setGraphic(new ImageView(imagen2));

            raiz.getChildren().addAll(btTexto, btTextoImagen, btImagen);

            Scene escena = new Scene(raiz, 400, 120);
            escenarioPrincipal.setTitle("Botones");
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

















