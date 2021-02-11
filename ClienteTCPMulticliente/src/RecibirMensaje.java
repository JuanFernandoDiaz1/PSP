import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirMensaje extends Thread{
    private Socket cliente;
    public RecibirMensaje(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try{
            String cadena ="";
            BufferedReader canalEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            while((cadena= canalEntrada.readLine())!= null){
                System.out.println("Se ha recibido " + cadena);
                sleep(1000);
            }
            System.out.println("Cerrando conexion");
            canalEntrada.close();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
