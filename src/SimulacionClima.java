import java.util.*;

public class SimulacionClima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Temperatura inicial:");
        int temp = sc.nextInt();

        System.out.println("Probabilidad de lluvia inicial (0 a 100):");
        int lluvia = sc.nextInt();

        System.out.println("¿Cuántos días quieres simular?");
        int dias = sc.nextInt();

        int maxTemp = temp;
        int minTemp = temp;
        int diasLluvia = 0;

        for (int i = 1; i <= dias; i++) {
            System.out.println("Día " + i + ":");

            // 10% de subir o bajar 2°
            int prob = rand.nextInt(100);
            if (prob < 10) {
                temp += 2;
            } else if (prob < 20) {
                temp -= 2;
            }

            if (temp > 25) {
                lluvia = Math.min(lluvia + 20, 100);
            } else if (temp < 5) {
                lluvia = Math.max(lluvia - 20, 0);
            }

            if (lluvia == 100) {
                temp -= 1;
                diasLluvia++;
                System.out.println("Llueve. Temperatura: " + temp + "°");
            } else {
                System.out.println("No llueve. Temperatura: " + temp + "°");
            }

            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
        }

        System.out.println("\n--- Resumen ---");
        System.out.println("Temp. Máxima: " + maxTemp + "°");
        System.out.println("Temp. Mínima: " + minTemp + "°");
        System.out.println("Días de lluvia: " + diasLluvia);
    }
}
