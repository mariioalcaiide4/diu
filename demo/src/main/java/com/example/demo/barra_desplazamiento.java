package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class barra_desplazamiento extends Application {

    @Override
    public void start(Stage escenarioPrincipal){
        try {
            ScrollPane sp = new ScrollPane();
            Image imagen = new Image("file:resources/furbo.jpg", 1000, 1000, true, true);
            sp.setContent(new ImageView(imagen));

            Scene escena = new Scene(sp, 500, 500);
            escenarioPrincipal.setTitle("Panel de desplazamiento");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);


    }
}
