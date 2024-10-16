package Actividad1;

public class hilo1 extends Thread {
    public hilo1() {
        System.out.println("Hilo 1 creado");
    }

    @Override
    public void run() {
        for (int i = 0; i > -1; i++) {
            System.out.println("TIC");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

