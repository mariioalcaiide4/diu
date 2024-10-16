package com.example.practicaconversion;

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