import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Hilo extends Thread {
    private Socket socketCliente;
    private PrintWriter salida;

    public Hilo(Socket socket) {
        this.socketCliente = socket;
    }

    public void run() {
        try {

            System.out.println("El cliente esta listo para comunicar");

            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);

            Scanner teclado = new Scanner(System.in);
            System.out.print("Escribe el mensaje para enviar: ");
            String cadena = teclado.nextLine();
            System.out.println(" ");

            String tokens[] = cadena.split(" ");

            for (int x = 0; x < tokens.length; x++) {
                sleep(500);
                System.out.println("Envia: " + tokens[x]);
                salida.println(tokens[x]);
            }

            //salida.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
