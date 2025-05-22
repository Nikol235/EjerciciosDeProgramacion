import java.util.Scanner;

public class CodigoKonami {
    public static void main(String[] args) {
        String[] konami = {"UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"};
        Scanner sc = new Scanner(System.in);
        String[] entrada = new String[10];

        System.out.println("Introduce la secuencia Konami:");

        for (int i = 0; i < 10; i++) {
            entrada[i] = sc.nextLine().toUpperCase();
        }

        boolean correcto = true;
        for (int i = 0; i < 10; i++) {
            if (!entrada[i].equals(konami[i])) {
                correcto = false;
                break;
            }
        }

        if (correcto) {
            System.out.println("¡Código Konami activado!");
        } else {
            System.out.println("Secuencia incorrecta.");
        }
    }
}
