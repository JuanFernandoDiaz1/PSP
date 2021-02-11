import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        try{
            //Abre un nuevo servidor en el puerto 8000 que esperara 100 segundos y muestra un mensaje de espera
            ServerSocket socket = new ServerSocket(1234);
            socket.setSoTimeout(100000);
            System.out.println("Esperando conexiones");

            //Espera a que un cliente estableza la conexion
            Socket socket_cli = socket.accept();
            System.out.println("Conectado con el cliente!");

            //Recogeremos los datos recibidos por el cliente
            DataInputStream in = new DataInputStream(socket_cli.getInputStream());

            //Instanciamos las clases que nos permitira enviar datos al cliente
            OutputStream aux = socket_cli.getOutputStream();
            DataOutputStream out = new DataOutputStream(aux);

            //Creamos un hilo para el envio de datos y otro para la recepcion
            Thread env = new Thread(new EnviarMensaje(out));
            Thread rec = new Thread(new RecibirMensaje(in));

            //comenzamos los hilos
            env.start();
            rec.start();

            do{

            }while(rec.isAlive()&& env.isAlive());
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
