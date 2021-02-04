import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ServidorUDP {
    public static void main(String args[]) {
        String textReceived = null;
        try {
            DatagramSocket datagramSocket = new DatagramSocket(1234);
            byte[] receive = null;


            receive = new byte[1000];


            // Construimos el DatagramPacket para recibir los datos
            DatagramPacket datagramPacket = new DatagramPacket(receive, receive.length);

            // recibimos los datos en un buffer de bytes
            datagramSocket.receive(datagramPacket);

            Mensaje ms = new Mensaje();
            ms = toMs(receive);
            System.out.println("Client: " + ms.getTexto());


            datagramSocket.close();
            //receive = new byte[1000];


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Mensaje toMs(byte[] recibido) throws IOException, ClassNotFoundException {

        ByteArrayInputStream byteArray = new ByteArrayInputStream(recibido); // bytes es el byte[]
        ObjectInputStream is = new ObjectInputStream(byteArray);
        Mensaje aux = (Mensaje)is.readObject();
        is.close();
        return aux;
    }
}
