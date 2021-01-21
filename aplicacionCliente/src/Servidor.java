import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int numpuerto=8080;
        try{
            ServerSocket servidor = new ServerSocket(1234);
            String cadena ="";

            System.out.println("Esperando conexion con el cliente...");
            Socket cliente = servidor.accept();

            System.out.println("El cliente se ha conectado...");
            BufferedReader canalentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
             while((cadena= canalentrada.readLine())!= null){
                 salida.println(cadena.toUpperCase());
                 System.out.println("Se ha recibido " + cadena);
             }
            System.out.println("Cerrando conexion " + cadena);
             canalentrada.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
