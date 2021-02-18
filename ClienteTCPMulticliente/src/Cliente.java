import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    protected static Socket socket;
    private static BufferedReader canalentrada;
    private static PrintWriter salida;
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            socket = new Socket("127.0.0.1", 10578);
            canalentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            String respuesta = "";
            String saludo="";

            System.out.print("Escribe tu nombre: ");
            String nombre = teclado.nextLine();
            System.out.println("");

            System.out.println("Envio: " + nombre);
            salida.println(nombre);

            while(saludo.compareToIgnoreCase("0")!=0){
                System.out.print("Escribe: ");
                saludo = teclado.nextLine();
                System.out.println("");

                System.out.println(nombre +" "+ saludo);
                salida.println(saludo);

                respuesta = canalentrada.readLine();
                System.out.println("Servidor devuelve: " + respuesta);

            }


            canalentrada.close();
            salida.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
