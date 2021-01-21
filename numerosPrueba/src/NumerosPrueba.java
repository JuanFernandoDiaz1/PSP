import java.util.Set;

public class NumerosPrueba {

    public static void main(String[] args) {
        var test1 = Set.of(1,2,3,4);
        var test2 = Set.of(1,2,3,4);
        var test3 = Set.of(1,2,3,4);
        var test4 = Set.of(1,2,3,4);
        int [] numeros={1,2,3,4};


            System.out.println(masCercano(numeros, 0));

    }

    public static int masCercano(int[] numeros, int num) {
        int menorDistanciaActual = Math.abs(num - numeros[0]); // Aca guardas la resta
        int posicionNumeroMasCercano = 0; // Si viene un array con un elemento, es el [0]

        // Empezas en 1, porque ya sabes que el 0 es el mas cercano hasta ahora.
        for (int i = 1; i < numeros.length; i++) {
            int distanciaEntreNumeros = Math.abs(num - numeros[i]);

            if (distanciaEntreNumeros < menorDistanciaActual) {
                menorDistanciaActual = distanciaEntreNumeros;
                posicionNumeroMasCercano = i;
            }
        }

        return numeros[posicionNumeroMasCercano];
    }
}
