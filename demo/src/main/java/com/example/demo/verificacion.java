package com.example.demo;

import javafx.application.Application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class verificacion extends Application {

    @Override
    public void start(Stage escenarioPrincipal){
        try {
            VBox raiz = new VBox();
            raiz.setPadding(new Insets(70));
            raiz.setSpacing(30);

            Label lbElige = new Label("Marca las casillas");
            lbElige.setFont(Font.font(30));

            CheckBox cbNavegador, cbManosLibres, cbLunas;
            cbNavegador = new CheckBox("Navegador");
            cbManosLibres = new CheckBox("Manos Libres");
            cbLunas = new CheckBox("Lunas tintadas");
            cbLunas.setAllowIndeterminate(true);

            VBox.setMargin(cbNavegador, new Insets(0, 0, 0, 30));
            VBox.setMargin(cbManosLibres, new Insets(0, 0, 0, 30));
            VBox.setMargin(cbLunas, new Insets(0, 0, 0, 30));

            raiz.getChildren().addAll(lbElige, cbNavegador, cbManosLibres, cbLunas);

            Scene escena = new Scene(raiz, 450, 250);
            escenarioPrincipal.setTitle("Casillas de verificación");
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
