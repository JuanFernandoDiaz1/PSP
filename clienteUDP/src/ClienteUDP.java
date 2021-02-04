import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteUDP {
    // Los argumentos proporcionan el mensaje y el nombre del servidor
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getLocalHost();

            byte[] buffer = null;
            Mensaje ms = new Mensaje();
            System.out.print("Introduce el texto: ");
            ms.setTexto(sc.nextLine());
            System.out.println();
            System.out.println();


            buffer = toBytes(ms);
            //buffer = userInput.getBytes(StandardCharsets.UTF_8);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, inetAddress, 1234);

            if (datagramSocket != null) {
                datagramSocket.send(peticion);
            }


            datagramSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] toBytes(Mensaje ms) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream (bytes);
        os.writeObject(ms);
        os.close();
        return bytes.toByteArray();
    }
}
