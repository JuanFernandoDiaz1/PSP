import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socketCliente = new Socket("localhost", 1234);
            System.out.println("El cliente esta listo para comunicar");

            Mensaje mensaje = new Mensaje();
            mensaje.setTexto("Holaaaa");

            ObjectOutputStream perSal = new ObjectOutputStream( socketCliente.getOutputStream());
            
            perSal.writeObject(mensaje);
            System.out.println("Envio: " + mensaje.getTexto());

            perSal.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
