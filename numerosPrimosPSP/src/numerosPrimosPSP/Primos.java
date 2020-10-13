package numerosPrimosPSP;

import java.math.BigInteger;
import java.util.Arrays;

public class Primos extends Thread {

	private int rangoInicial=0;
	private int rangoFinal=0;
	
	public Primos(int rangoInicial, int rangoFinal) {
		this.rangoFinal=rangoFinal;
		this.rangoInicial=rangoInicial;
	}
	
	public void primos() {
		BigInteger bi;
		for (int i = rangoInicial; i < rangoFinal; i++) {
			bi = new BigInteger(String.valueOf(i));
			if(bi.isProbablePrime(1)==true) {
				System.out.println(i + " es primo " + Thread.currentThread().getName());
				
			}
		}
	}
	
	public void run(){
		primos();
	}
}
