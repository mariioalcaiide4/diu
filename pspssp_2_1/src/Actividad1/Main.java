package Actividad1;

public class Main {
    public static void main (String[] args){

        hilo1 h1 = new hilo1();
        hilo2 h2 = new hilo2();

        h1.start();
        h2.start();


    }
}
