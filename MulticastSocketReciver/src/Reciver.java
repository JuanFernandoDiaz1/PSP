import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Reciver {
    public static void main(String[] args) {
        try {
            InetAddress localGroup = InetAddress.getByName("239.0.0.255");
            MulticastSocket multicastSocket = new MulticastSocket();
            multicastSocket.joinGroup(localGroup);

            System.out.println("joined to group");
            String text="";
            byte[] buffer = new byte[1026];

            System.out.println("Waiting...");
            while (!text.trim().equals("*")){
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(datagramPacket);

                text = new String(datagramPacket.getData());
                System.out.println("Mensaje recibido " + text);

            }
            multicastSocket.leaveGroup(localGroup);
            multicastSocket.close();
            System.out.println("Multicast Group leave");
         } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
