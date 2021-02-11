import java.io.*;
import java.net.Socket;

public class ServidorHilo extends Thread {
    private Socket socket;
    private BufferedReader canalentrada;
    private PrintWriter salida;
    private String nombre;
    private String mensaje;


    public ServidorHilo(Socket socket, String nombre) {
        this.socket = socket;
        this.nombre = nombre;
        try {
            canalentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String cadena = "";
        try {

            while ((cadena = canalentrada.readLine()) != null) {
                System.out.println("El cliente "+nombre+" dice: " + cadena);
                setMensaje(cadena);
                salida.println(cadena);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void getMensaje(){
        salida.println(mensaje);
    }

    public void setMensaje(String mensaje){
        this.mensaje=mensaje;
    }

}
