package com.example.conversion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        try {
            MonedaRepositoryImpl monedarepositoryImpl = new MonedaRepositoryImpl();
            MonedaVO monedaPrueba = new MonedaVO("prueba", 1.2F);
            monedarepositoryImpl.addMoneda(monedaPrueba);
        } catch (ExcepcionMoneda e) {
            throw new RuntimeException(e);
        }
    }
}