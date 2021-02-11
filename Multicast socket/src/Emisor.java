import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Emisor {
    static final int PORT = 12345;
    static final String GROUP_NAME= "239.0.0.255";
    public static void main(String[] args) {
        BufferedReader terminaInput = new BufferedReader(new InputStreamReader(System.in));

        try {


            MulticastSocket multicastSocket = new MulticastSocket();
            InetAddress localGroup = InetAddress.getByName(GROUP_NAME);

            String text = "";

            while (!text.trim().equals("*")) {
                System.out.println("Mensaje para difusion");
                text = terminaInput.readLine();

                DatagramPacket datagramPacket = new DatagramPacket(text.getBytes(), text.length(), localGroup, PORT);

                multicastSocket.send(datagramPacket);
            }
            multicastSocket.close();
            System.out.println("CLOSED");
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
