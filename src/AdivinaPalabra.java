import java.util.*;

public class AdivinaPalabra {
    public static void main(String[] args) {
        String[] palabras = {"murcielago", "java", "pokemon", "teclado", "aventura"};
        Random rand = new Random();
        String palabra = palabras[rand.nextInt(palabras.length)];
        int intentos = 6;

        char[] oculta = ocultarPalabra(palabra);
        Scanner sc = new Scanner(System.in);

        while (intentos > 0) {
            System.out.println("Palabra: " + new String(oculta));
            System.out.println("Intentos restantes: " + intentos);
            String entrada = sc.nextLine().toLowerCase();

            if (entrada.length() == 1) {
                boolean acierto = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == entrada.charAt(0) && oculta[i] == '_') {
                        oculta[i] = entrada.charAt(0);
                        acierto = true;
                    }
                }
                if (!acierto) {
                    intentos--;
                }
            } else if (entrada.length() == palabra.length()) {
                if (entrada.equals(palabra)) {
                    System.out.println("¡Correcto! La palabra era: " + palabra);
                    return;
                } else {
                    intentos--;
                }
            } else {
                System.out.println("Entrada inválida.");
            }

            if (new String(oculta).equals(palabra)) {
                System.out.println("¡Ganaste! La palabra era: " + palabra);
                return;
            }
        }

        System.out.println("Perdiste. La palabra era: " + palabra);
    }

    public static char[] ocultarPalabra(String palabra) {
        char[] resultado = palabra.toCharArray();
        int maxOcultas = (int) (palabra.length() * 0.6);
        Random rand = new Random();
        Set<Integer> ocultas = new HashSet<>();

        while (ocultas.size() < maxOcultas) {
            int pos = rand.nextInt(palabra.length());
            if (resultado[pos] != '_') {
                resultado[pos] = '_';
                ocultas.add(pos);
            }
        }

        return resultado;
    }
}
