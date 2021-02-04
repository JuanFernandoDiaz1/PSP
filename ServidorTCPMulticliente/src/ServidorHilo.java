import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServidorHilo extends Thread {
    private Socket socket;
    private BufferedReader canalentrada;
    private PrintWriter salida;
    private int idSessio;

    public ServidorHilo(Socket socket, int id) {
        this.socket = socket;
        this.idSessio = id;
        try {
            canalentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        try {

            while ((cadena = canalentrada.readLine()) != null) {
                System.out.println("El cliente con idSesion " + this.idSessio + " dice: " + cadena);

                salida.println(cadena.toUpperCase());
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
