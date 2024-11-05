package Agenda.modelo;

public class ExcepcionPersona extends Exception {
    private String mensaje_error;
    public ExcepcionPersona(){
    }

    public ExcepcionPersona(String ms){this.mensaje_error=ms;}
    public String imprimirMensaje() {return this.mensaje_error;}






}
