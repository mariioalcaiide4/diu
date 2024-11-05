package Agenda.modelo;

import Agenda.modelo.repository.PersonRepository;
import Agenda.util.PersonUtil;
import Agenda.view.Person;

import java.util.ArrayList;

public class AgendaModelo {
     PersonRepository personRepository;
    public void setPersonRepository(PersonRepository personRepository) {this.personRepository = personRepository;}

    public ArrayList<Person> obtenerPersonas() throws ExcepcionPersona{
        ArrayList<PersonVO> listilla = personRepository.ObtenerListaPersonas();
        return PersonUtil.parsePersonVOPerson(listilla);
    }

    public void anadirPersona(Person persona) throws ExcepcionPersona {
        personRepository.añadirPersona(PersonUtil.parsePersonPersonVO(persona));
    }

    public void editarPersona(Person persona) throws ExcepcionPersona {
        personRepository.editarPersona(PersonUtil.parsePersonPersonVO(persona));

    }

    public void borrarPersona(int code) throws ExcepcionPersona{
        personRepository.borrarPersona(code);
    }


}
