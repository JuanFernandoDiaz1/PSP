import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Persona extends Thread {
    protected Socket socket;
    private BufferedReader canalentrada;
    private PrintWriter salida;


    public Persona() {
    }

    @Override
    public void run() {
        try {
            Scanner teclado = new Scanner(System.in);
            socket = new Socket("127.0.0.1", 10578);
            canalentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            String respuesta = "";
            String saludo="";

            while(saludo.compareToIgnoreCase("0")!=0){
                System.out.print("Escribe: ");
                saludo = teclado.nextLine();
                System.out.println("");

                System.out.println("Envio: " + saludo);
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
