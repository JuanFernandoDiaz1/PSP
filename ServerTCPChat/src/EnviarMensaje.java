import java.io.DataOutputStream;
import java.util.Scanner;

public class EnviarMensaje implements Runnable{
    private DataOutputStream out;

    public EnviarMensaje(DataOutputStream out){
        this.out = out;
    }

    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);
        try{
            String mensaje ="";
            do{
                mensaje = teclado.nextLine();
                out.writeUTF(mensaje);
            }while (!mensaje.equals("fin"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
