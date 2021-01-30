import java.util.concurrent.ThreadLocalRandom;

public class Parte2 extends Thread {
    
    private final static int INT_MAX=105345;

    private final static int  DIM=3;

    private static int[][] matriz= new int [DIM][DIM];

    private int mayor = -1;

    private int mayorFila= -1;

    private int idThread;

    private int fila;

    public Parte2(int pIdThread, int pFila){
        this.idThread=pIdThread;
        this.fila=pFila;
    }

    public static void crearMatriz(){
        for(int i=0; i<DIM;i++){
            for (int j=0;j<DIM;j++){
                matriz[i][j]= ThreadLocalRandom.current().nextInt(0,INT_MAX);
            }
            System.out.println("Matriz: ");
            System.out.println("============================");
            imprimirMatriz();
        }
    }

    public static void imprimirMatriz(){
        for(int i=0; i<DIM;i++){
            for (int j=0;j<DIM;j++){
                System.out.println(matriz[i][j]+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        for(int j=0; j<DIM;j++){
            if(this.mayorFila<matriz[this.fila][j]){
                this.mayorFila=matriz[this.fila][j];
            }
        }
            if(this.mayorFila>mayor){
                try{
                    Thread.sleep(250);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            
                mayor =this.mayorFila;
                String warn =String.format("===========Nuevo maximo encontrado====== \n"+
                "ID Thread: %d - Maximo local actual: % d - Maximo global: %d \n"+
                "\n",
                this.idThread,
                mayor,
                this.mayorFila
                );
                System.out.println(warn);
            }
            
            String msg = String.format("ID Thread: %d - Maximo Local: %d -  Maximo Global: %d ",
            this.idThread,  this.mayorFila, mayor 
            );
            System.out.println(msg);
    }

    public static void main (String[] args){
        System.out.println("Busqueda concurrente por una matriz");
        Parte2.crearMatriz();
        System.out.println();
        System.out.println("iniciando la busqueda por la matriz \n");
        
        Parte2[] bThreads = new Parte2[DIM];
        for (int i=0; i<DIM; i++){
            bThreads[i]= new Parte2(i,i);
            bThreads[i].start();;
        }
    }

}
