package com.example.practicaconversor1;


import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;
import com.example.practicaconversor1.controller.ConversorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    
    MonedaRepositoryImpl monedaRepository = new MonedaRepositoryImpl();
    ConversorController controller = new ConversorController();
    private Stage escenarioPrincipal;
    private AnchorPane conversor;

    public static void main(String[] args) {
        try {
            MonedaRepositoryImpl monedarepositoryImpl = new MonedaRepositoryImpl();
            MonedaVO monedaPrueba = new MonedaVO("prueba", 1.2F);
            monedarepositoryImpl.addMoneda(monedaPrueba);
        } catch (ExcepcionMoneda var5) {
            ExcepcionMoneda e = var5;
            System.out.println(e.imprimirMensaje());
        }
    }

    /*
    public void start(Stage escenarioPrincipal){
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Contador de Monedas");
        initConversor();
    }

    public void initConversor(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/ConversorView.fxml"));
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
*/

 }


