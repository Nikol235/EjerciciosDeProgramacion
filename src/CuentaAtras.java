import java.util.Scanner;

public class CuentaAtras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Número para comenzar la cuenta atrás:");
        int inicio = sc.nextInt();

        System.out.println("Segundos entre cada número:");
        int segundos = sc.nextInt();

        if (inicio <= 0 || segundos <= 0) {
            System.out.println("Solo se aceptan números enteros positivos.");
            return;
        }

        for (int i = inicio; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
