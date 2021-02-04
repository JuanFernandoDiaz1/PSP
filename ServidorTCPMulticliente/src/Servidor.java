import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String args[]) throws IOException {
        ServerSocket ss;
        System.out.println("Inicializando servidor... ");
        try {
            ss = new ServerSocket(10578);

            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("El cliente con id " + idSession + " se ha conectado");
                ServidorHilo sh = new ServidorHilo(socket, idSession);
                sh.start();
                idSession++;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

