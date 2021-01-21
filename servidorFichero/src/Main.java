import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            int in;
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Esperando conexion con el cliente...");
            Socket cliente = servidor.accept();

            byte[] datosRecividos = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(cliente.getInputStream());
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            //Recibimos el nombre del fichero
            String file = dis.readUTF();
            file = file.substring(file.indexOf('\\') + 1, file.length());
            File fichero=new File(file);
            //Guardamos fichero recibido
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fichero));
            while ((in = bis.read(datosRecividos)) != -1) {
                bos.write(datosRecividos, 0, in);
            }
            System.out.println("Fichero recibido " + fichero.getName());
            bos.close();
            dis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
