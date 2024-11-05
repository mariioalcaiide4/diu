package Agenda.modelo;

import java.sql.Date;
import java.time.LocalDate;

public class PersonVO {

    //Atributos de la clase PersonVO

    int code;
    String firstName;
    String lastName;
    String street;
    String postalCode;
    String city;
    LocalDate birthday;

    //Constructor de la clase PersonVO

    public PersonVO(Integer code, String firstName, String lastName, String street, String city, String postalCode, LocalDate birthday) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.birthday = birthday;
    }

    //Getters y setters de la clase PersonVO

    public Integer getCodigo(){return code;}
    public void setCodigo(Integer code){this.code = code;}

    public String getNombre(){ return firstName;}
    public void setNombre(String firstName) {
        this.firstName = firstName;
    }

    public String getApellido(){ return lastName;}
    public void setApellido(String lastName) {this.lastName = lastName;}

    public String getDireccion(){ return street;}
    public void setDireccion(String street) {this.street = street;}

    public String getCodigoPostal(){ return postalCode;}
    public void setCodigoPostal(String postalCode) {this.postalCode = postalCode;}

    public String getCiudad(){return city;}
    public void setCiudad(String city) {this.city = city;}

    public LocalDate getNacimiento(){return birthday;}
    public void setNacimiento(LocalDate birthday) {this.birthday = birthday;}

    public String toString() {
        return "Persona{nombre completo = " + this.firstName  + " " + this.lastName + ", codigo= " + this.code + ", direccion = " + this.street + ", codigo postal = " + this.postalCode + ", ciudad = " + this.city + ", nacimiento = " + this.birthday + '}';
    }

}


