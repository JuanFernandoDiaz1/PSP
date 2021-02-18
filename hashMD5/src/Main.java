import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String[] algoritmos={"MD5", "SHA-1","SHA3-256", "SHA-224", "SHA-256", "SHA-384", "SHA-512"};

        for(String algoritmo: algoritmos){
            hash(algoritmo);
        }

    }

    public static void hash(String algoritmo){
        String password ="contraseña1234";
        System.out.println(algoritmo+": ");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algoritmo);

            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();

            System.out.println(Base64.getEncoder().encodeToString(digest));
            System.out.println();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }


}