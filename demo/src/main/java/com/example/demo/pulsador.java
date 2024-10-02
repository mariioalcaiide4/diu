package com.example.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class pulsador extends Application {

    private IntegerProperty numPulsaciones = new SimpleIntegerProperty(0);
    private Button btMas, btReset, btMenos;
    private Label numero;

    private void botonPulsar(int opcion) {

        if (opcion == 1) {
            numPulsaciones.set(numPulsaciones.get() + 1);
        } else if (opcion == -1) {
            numPulsaciones.set(numPulsaciones.get() - 1);
        } else {
            numPulsaciones.set(0);
        }
    }


    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox contenedor = new VBox();
            contenedor.setAlignment(Pos.CENTER);

            numero = new Label();
            numero.setText("0");
            numero.setAlignment(Pos.CENTER);
            numero.setFont(Font.font("Ani", 50));
            numero.setStyle("-fx-base: #b6e7c9;");

            HBox raiz = new HBox();
            raiz.setPadding(new Insets(30, 30, 30, 30));
            raiz.setSpacing(20);
            raiz.setAlignment(Pos.CENTER);

            btMas = new Button();
            btReset = new Button();
            btMenos = new Button();

            btMas.setText("+");
            btMas.setTextAlignment(TextAlignment.CENTER);
            btMas.setStyle("-fx-base: #b6e7c9; -fx-font: 22 arial;");
            btMas.setOnAction(e ->botonPulsar(+1));

            btMenos.setText("-");
            btMenos.setTextAlignment(TextAlignment.CENTER);
            btMenos.setStyle("-fx-base: #b6e7c9; -fx-font: 22 arial;");
            btMenos.setOnAction(e ->botonPulsar(-1));

            btReset.setText("R");
            btReset.setTextAlignment(TextAlignment.CENTER);
            btReset.setStyle("-fx-base: #b6e7c9; -fx-font: 22 arial;");
            btReset.setOnAction(e ->botonPulsar(0));

            numPulsaciones.addListener(((observableValue, oldValue, newValue) -> {numero.setText(String.valueOf(newValue));}));

            raiz.getChildren().addAll(btMas, btReset, btMenos);

            contenedor.getChildren().addAll(raiz, numero);

            Scene escena = new Scene(contenedor, 800, 600);
            escenarioPrincipal.setTitle("Contador");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public IntegerProperty numPulsacionesProperty(){
        return numPulsaciones;}


}
