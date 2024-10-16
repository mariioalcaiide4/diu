public class ThreadEjemplo extends Thread {
    public ThreadEjemplo(String string){super(string);}
    public void run(){
        for(int i = 0; i < 15; i++) System.out.println(i + " " + getName());
        System.out.println("Termina thread " + getName());}
    public static void main (String [] args){
        new ThreadEjemplo("Pepe").start();
        new ThreadEjemplo("Mario").start();
    }
}