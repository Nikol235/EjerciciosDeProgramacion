import java.util.Scanner;

public class ValidarExpresion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la expresión matemática:");
        String expresion = sc.nextLine();

        String[] partes = expresion.split(" ");
        if (partes.length < 3 || partes.length % 2 == 0) {
            System.out.println("false");
            return;
        }

        for (int i = 0; i < partes.length; i++) {
            if (i % 2 == 0) {
                try {
                    Double.parseDouble(partes[i]);
                } catch (NumberFormatException e) {
                    System.out.println("false");
                    return;
                }
            } else {
                if (!partes[i].matches("[+\\-*/%]")) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}
