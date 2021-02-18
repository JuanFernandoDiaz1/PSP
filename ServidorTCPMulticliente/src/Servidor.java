import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String args[]) throws IOException {
        //Socket socket;
        BufferedReader canalentrada;
        ServerSocket ss;
        System.out.println("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578);


            while (true) {
                Socket socket;
                socket = ss.accept();
                canalentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nombre = canalentrada.readLine();
                System.out.println(nombre);
                System.out.println("El cliente " + nombre + " se ha conectado");
                ServidorHilo sh = new ServidorHilo(socket, nombre);
                sh.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


