import java.time.chrono.MinguoChronology;
import java.util.Scanner;

public class Main extends Thread {
  
    private String nombre;
    private boolean par;
    private static int contador;
    private static int time;

    public Main(String nombre, boolean par) {
        System.out.println("This code is outside of the thread");
        this.nombre = nombre;
        this.par = par;
    }

    public static void main(String[] args) {
        try{
        Scanner input = new Scanner(System.in);
        System.out.println("tiempo time out");
        time = input.nextInt();
        System.out.println("numero");
        contador = input.nextInt();
        input.close();

        Main t1 = new Main("Thread 1", true);
        Main t2 = new Main("Thread 2", false);


      t1.start();
      t2.start();
      Thread.sleep(time);
        }
        catch(Exception e){

        }
    }
    public void run() {
    try {
        for(int i=0; i<=contador;i++){
            if(par==true){
            System.out.println("nombre del thread: "+nombre+" Contando numeros: "+ i);
            Thread.sleep(time);
            this.par=false;
            }
            else{
                this.par=true;
            }
            
        }
    }
    catch (Exception e){
        System.out.println("Saliendo");
    }
    }
  }
