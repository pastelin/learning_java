package ejercicios;

public class BucleDeDivisiblesBy3And2 {

    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++) {
            if(i % 2 == 0 && i % 3 == 0) {
                System.out.println(i + " es divisible por 2 y por 3.");
            }
        }
    }
}
