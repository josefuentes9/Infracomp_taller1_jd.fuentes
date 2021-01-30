import java.time.chrono.MinguoChronology;
import java.util.Scanner;

public class MainTwo implements Runnable{
  
    private String nombre;
    private boolean par;
    private static int contador;
    private static int time;

    public MainTwo(String nombre, boolean par) {
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

        Thread t1 = new Thread(new MainTwo("Thread 1", true));
        Thread t2 = new Thread(new MainTwo("Thread 2", false));
        input.close();


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
