package Agenda.diu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class PersonVO {

    int code;
    String firstName;
    String lastName;
    String street;
    int postalCode;
    String city;
    String birthday;

    public PersonVO(int code, String firstName, String lastName) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonVO(int code, String firstName, String lastName, String street, int postalCode, String city, String birthday) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.birthday = birthday;
    }

    public PersonVO(String m, String p, String d, String c, Integer cp, String br) {
    }

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

    public Integer getCodigoPostal(){ return postalCode;}
    public void setCodigoPostal(int postalCode) {this.postalCode = postalCode;}

    public String getCiudad(){return city;}
    public void setCiudad(String city) {this.city = city;}

    public String getNacimiento(){return birthday;}
    public void setNacimiento(String birthday) {this.birthday = birthday;}

    public String toString() {
        return "Persona{nombre completo=" + this.firstName  + this.lastName + ", codigo= " + this.code + ", direccion= " + this.street + ", codigo postal" + this.postalCode + ", ciudad=" + this.city + ", nacimiento=" + this.birthday + '}';
    }

}


