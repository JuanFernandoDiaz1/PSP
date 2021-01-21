import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try{
            int in;
            String nombreFichero = "c:\\servidor.txt";
            File localFile = new File( nombreFichero );
            Socket client = new Socket("localhost", 1234);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(localFile));
            BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
            //Enviamos el nombre del fichero
            DataOutputStream dos=new DataOutputStream(client.getOutputStream());
            dos.writeUTF(localFile.getName());
            //Enviamos el fichero
            byte[] byteArray = new byte[8192];
            while ((in = bis.read(byteArray)) != -1){
                bos.write(byteArray,0,in);
            }

            bis.close();
            bos.close();

        }catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
