package Actividad1;

public class hilo2 extends Thread{
    public hilo2(){
        System.out.println("Hilo 2 creado");
    }

    @Override
    public void run(){
        for (int i = 0; i > -1; i++){
            System.out.println("TAC");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
