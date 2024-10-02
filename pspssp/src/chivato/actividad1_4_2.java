package chivato;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class actividad1_4_2 {
    public static void main(String[] args) throws IOException {

        //Creo directorio

        File direccion = new File("/home/usuario/Dropbox/mariano/IdeaProjects/pspssp/out/production/pspssp");

        //Creo el proceso

        ProcessBuilder primo = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "chivato.actividad1_4", "Felipe");

        // Se establece donde se ejecuta

        primo.directory(direccion);

        //Inicio el proceso

        Process proceso = primo.start();

        try {
            InputStream illo = proceso.getInputStream();
            int c;
            while ((c = illo.read()) != -1){
                System.out.print((char)c);}
            illo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int valorSal;
        try {
            valorSal = proceso.waitFor();
            System.out.println("Valor de salida " + valorSal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }

    }


