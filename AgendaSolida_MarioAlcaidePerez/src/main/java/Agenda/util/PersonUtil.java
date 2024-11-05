package Agenda.util;

import Agenda.view.Person;
import Agenda.modelo.PersonVO;

import java.util.ArrayList;

//Clase para cambiar la clase PersonVO a Person y viceversa

public class PersonUtil {

    public static PersonVO parsePersonPersonVO (Person persona){
        if (persona == null) {
            return null;
        }else {
            return new PersonVO(persona.getCode(), persona.getFirstName(), persona.getLastName(), persona.getStreet(), persona.getCity(), persona.getPostalCode(), persona.getBirthday());
        }
    }

    public static ArrayList<Person> parsePersonVOPerson(ArrayList<PersonVO> listaPersonVO) {
        if (listaPersonVO == null) {
            return null;
        }else {
            ArrayList<Person> listaPersonas = new ArrayList<>();
            for (PersonVO personVO : listaPersonVO) {
                listaPersonas.add(new Person(personVO.getCodigo(), personVO.getNombre(), personVO.getApellido(), personVO.getDireccion(), personVO.getCiudad(), personVO.getCodigoPostal(), personVO.getNacimiento()));
            }
            return listaPersonas;
        }
    }
}







