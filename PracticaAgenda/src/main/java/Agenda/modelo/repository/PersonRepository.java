package Agenda.modelo.repository;

import Agenda.modelo.ExcepcionPersona;
import Agenda.modelo.PersonVO;

import java.util.ArrayList;

public interface PersonRepository {
    ArrayList<PersonVO> ObtenerListaPersonas() throws ExcepcionPersona;

    void añadirPersona(PersonVO var1) throws ExcepcionPersona;

    void borrarPersona(Integer var1) throws ExcepcionPersona;

    void editarPersona(PersonVO var1) throws ExcepcionPersona;

    int lastIdPersona() throws ExcepcionPersona;

    ArrayList<PersonVO> ObtenerListaReservas() throws ExcepcionPersona;

    void añadirReserva(PersonVO var1) throws ExcepcionPersona;

    void borrarReserva(Integer var1) throws ExcepcionPersona;

    void editarReserva(PersonVO var1) throws ExcepcionPersona;

    int lastIdReserva() throws ExcepcionPersona;
    }

