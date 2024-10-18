package com.example.practicaconversor1.modelo;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.MonedaRepository;

import java.util.ArrayList;

public class ConversorModelo {
    private MonedaRepository monedaRepository;

    public void setMonedaRepository(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    public float obtenerMult() throws ExcepcionMoneda {
        ArrayList<MonedaVO> listaMonedas = monedaRepository.ObtenerListaMonedas();
        MonedaVO dolarVO = listaMonedas.get(0);
        return dolarVO.getMultiplicador();
    }

    public double conversion(double euros) throws ExcepcionMoneda {
        return euros * obtenerMult();

    }
}