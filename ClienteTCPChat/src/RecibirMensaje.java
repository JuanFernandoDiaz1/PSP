import java.io.DataInputStream;

public class RecibirMensaje implements Runnable{
    private DataInputStream in;
    public RecibirMensaje(DataInputStream in){
        this.in=in;
    }

    @Override
    public void run() {
        try{
            String msg_ser="";
            do{
                msg_ser=in.readUTF();
                System.out.println("Servidor: " + msg_ser);
            }while(!msg_ser.equals("fin"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
