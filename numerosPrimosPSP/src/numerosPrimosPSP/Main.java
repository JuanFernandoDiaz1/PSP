package numerosPrimosPSP;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Hilos: ");
		int numero = teclado.nextInt();
		
		int resultado = 1000/numero;
		int inicial = 1;
		for(int i=1; i<=numero;i++) {
			Thread h = new Primos(inicial,resultado*i);
			inicial+=resultado;
			h.start();
		}
	}
}
