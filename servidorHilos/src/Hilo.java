import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Hilo extends Thread{
    private ServerSocket servidor;
    private Socket socketCliente;
    private BufferedReader canalEntrada;
    private PrintWriter salida;

    public void run(){
        try{
            servidor = new ServerSocket(1234);
            String cadena ="";

            System.out.println("Esperando conexion con el cliente...");
            socketCliente = servidor.accept();

            System.out.println("El cliente se ha conectado...");
            canalEntrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(socketCliente.getOutputStream(), true);
            while((cadena= canalEntrada.readLine())!= null){
                System.out.println("Se ha recibido " + cadena);
                sleep(1000);
                salida.println(cadena.toUpperCase());
            }
            System.out.println("Cerrando conexion");
            canalEntrada.close();

        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
