import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Hilo extends Thread{

    public void run(){
        try{
            ServerSocket servidor = new ServerSocket(1234);
            String cadena ="";

            System.out.println("Esperando conexion con el cliente...");
            Socket socketCliente = servidor.accept();

            System.out.println("El cliente se ha conectado...");
            BufferedReader canalEntrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            while((cadena= canalEntrada.readLine())!= null && cadena.compareToIgnoreCase("0")!=0){
                System.out.println("Se ha recibido " + cadena);
                sleep(1000);
                salida.println(cadena.toUpperCase());
            }
            System.out.println("Cerrando conexion");
            canalEntrada.close();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

}
