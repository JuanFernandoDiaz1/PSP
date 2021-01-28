import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("localhost", 1234);
            Hilo hilo = new Hilo(cliente);
            HiloRecibe hilo2 = new HiloRecibe(cliente);
            hilo.start();
            hilo.join();
            hilo2.start();
            hilo2.join();
            //cliente.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
