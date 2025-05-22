public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        long primero = 0;
        long segundo = 1;

        System.out.println("Sucesión de Fibonacci (50 primeros números):");

        for (int i = 0; i < n; i++) {
            System.out.print(primero + " ");
            long siguiente = primero + segundo;
            primero = segundo;
            segundo = siguiente;
        }
    }
}
