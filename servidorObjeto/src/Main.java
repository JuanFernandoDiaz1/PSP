import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try{

            ServerSocket servidor = new ServerSocket(1234);
            String cadena ="";

            System.out.println("Esperando conexion con el cliente...");
            Socket cliente = servidor.accept();

            System.out.println("El cliente se ha conectado...");

            ObjectInputStream inObjeto = new ObjectInputStream( cliente.getInputStream());
            Mensaje mensaje = (Mensaje) inObjeto.readObject();
            
            System.out.println("Recibo: " + mensaje.getTexto());

            System.out.println("Cerrando conexion " + cadena);

            inObjeto.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
