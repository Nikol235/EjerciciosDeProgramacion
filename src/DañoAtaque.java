import java.util.Scanner;

public class DañoAtaque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tipos = {"agua", "fuego", "planta", "eléctrico"};

        System.out.print("Tipo atacante (Agua, Fuego, Planta, Eléctrico): ");
        String tipoAtacante = sc.nextLine().toLowerCase();
        System.out.print("Tipo defensor (Agua, Fuego, Planta, Eléctrico): ");
        String tipoDefensor = sc.nextLine().toLowerCase();

        if (!esTipoValido(tipoAtacante) || !esTipoValido(tipoDefensor)) {
            System.out.println("Tipo inválido. Usa Agua, Fuego, Planta o Eléctrico.");
            return;
        }

        System.out.print("Ataque (1-100): ");
        int ataque = sc.nextInt();
        System.out.print("Defensa (1-100): ");
        int defensa = sc.nextInt();

        if (ataque < 1 || ataque > 100 || defensa < 1 || defensa > 100) {
            System.out.println("Ataque y defensa deben estar entre 1 y 100.");
            return;
        }

        double efectividad = calcularEfectividad(tipoAtacante, tipoDefensor);
        double danio = 50 * ((double) ataque / defensa) * efectividad;

        System.out.println("Efectividad: x" + efectividad);
        System.out.printf("El daño causado es: %.2f%n", danio);
    }

    public static boolean esTipoValido(String tipo) {
        return tipo.equals("agua") || tipo.equals("fuego") || tipo.equals("planta") || tipo.equals("eléctrico");
    }

    public static double calcularEfectividad(String atacante, String defensor) {
        if (atacante.equals("agua")) {
            return defensor.equals("fuego") ? 2 : defensor.equals("planta") || defensor.equals("eléctrico") ? 0.5 : 1;
        } else if (atacante.equals("fuego")) {
            return defensor.equals("planta") ? 2 : defensor.equals("agua") ? 0.5 : 1;
        } else if (atacante.equals("planta")) {
            return defensor.equals("agua") ? 2 : defensor.equals("fuego") ? 0.5 : 1;
        } else if (atacante.equals("eléctrico")) {
            return defensor.equals("agua") ? 2 : defensor.equals("planta") ? 0.5 : 1;
        }
        return 1;
    }
}
