import java.io.*;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        try{
            //Direccion a la que nos conectamos
            Socket socket = new Socket("localhost",1234);

            //Flujos de entrada y salida del cliente con el servidor
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            //Hilos para el envio de datos y otro para la recepcion
            Thread env = new Thread(new EnviarMensaje(out));
            Thread rec = new Thread(new RecibirMensaje(in));

            //Comienzan los hilos
            env.start();
            rec.start();

            //mientras los dos hilos esten en marcha se mantiene el bucle para que el programa no finalice
            do{

            }while (env.isAlive() && rec.isAlive());
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
