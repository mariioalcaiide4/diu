package paquete2;

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

    private Button btMas, btReset, btMenos;
    private Label numero;

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            btMas = new Button();
            btReset = new Button();
            btMenos = new Button();

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

            raiz.getChildren().addAll(btMas, btMenos, btReset);

            contenedor.getChildren().addAll(raiz, numero);

            Scene escena = new Scene(contenedor, 800, 600);
            escenarioPrincipal.setTitle("Contador");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private int numPulsaciones = 0;

    private void botonPulsar(int opcion) {
        if (opcion == 1) {
            numero.setText(String.valueOf(++numPulsaciones));

    } else if(opcion ==-1)

    {
        numero.setText(String.valueOf(--numPulsaciones));
    } else {
        numPulsaciones = 0;
        numero.setText("R");
    }

    }

public static void main(String[] args){
        launch(args);
}

}
