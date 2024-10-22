package Agenda.diu;

import java.util.ArrayList;

public interface PersonRepository {
    ArrayList<PersonVO> ObtenerListaPersonas() throws ExcepcionPersona;

    void añadirPersona(PersonVO var1) throws ExcepcionPersona;

    void borrarPersona(Integer var1) throws ExcepcionPersona;

    void editarPersona(PersonVO var1) throws ExcepcionPersona;

    int lastId() throws ExcepcionPersona;
}