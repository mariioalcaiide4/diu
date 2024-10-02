package chivato;

import java.io.*;

public class actividad1_5 {

    public static void main(String[] args) throws IOException {
            File direccion = new File("/home/usuario/Dropbox/mariano/IdeaProjects/pspssp/out/production/pspssp");
            ProcessBuilder primo = new ProcessBuilder(new String[]{"/home/usuario/.jdks/openjdk-23/bin/java", "chivato.actividad1_7", "Felipe"});
            primo.directory(direccion);
            Process proceso = primo.start();

            try {
                InputStream joe = proceso.getErrorStream();
                BufferedReader brer =
                    new BufferedReader(new InputStreamReader(joe));
                String liner = null;
                while ((liner = brer.readLine()) != null)
                      System.out.println("ERROR > " + liner);
            } catch (IOException ioe) {
                ioe.printStackTrace();
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










