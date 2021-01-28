import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Hilo extends Thread{
    private Socket socketCliente;
    private BufferedReader entrada;
    private PrintWriter salida;

    public void run(){
        try {
            socketCliente = new Socket("localhost", 1234);
            System.out.println("El cliente esta listo para comunicar");
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);

            Scanner teclado = new Scanner(System.in);
            System.out.print("Escribe el mensaje para enviar: ");
            String cadena = teclado.nextLine();
            System.out.println("");

            String tokens[]=cadena.split(" ");

            for(int x = 0; x< tokens.length;x++){
                sleep(500);
                System.out.println("Envia: " + tokens[x]);
                salida.println(tokens[x]);

                cadena = entrada.readLine();
                System.out.println("Respuesta: " + cadena);
                System.out.println();
            }

            entrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
