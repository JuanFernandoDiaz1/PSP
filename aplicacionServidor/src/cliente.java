import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try {
            Socket socketCliente = new Socket("localhost", 1234);
            System.out.println("El cliente esta listo para comunicar");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);

            Scanner teclado = new Scanner(System.in);
            String cadena="";

            while (cadena.compareToIgnoreCase("0")!=0) {

                System.out.print("Envia: ");
                cadena = teclado.nextLine();

                salida.println(cadena);

                cadena = entrada.readLine();
                System.out.println("Respuesta: " + cadena);


            }
            entrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
