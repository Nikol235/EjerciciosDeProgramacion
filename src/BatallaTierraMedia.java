import java.util.Scanner;

public class BatallaTierraMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce cantidad de Pelosos:");
        int pelosos = sc.nextInt(); // valor 1
        System.out.println("Introduce cantidad de Elfos:");
        int elfos = sc.nextInt(); // valor 5

        System.out.println("Introduce cantidad de Orcos:");
        int orcos = sc.nextInt(); // valor 2
        System.out.println("Introduce cantidad de Trolls:");
        int trolls = sc.nextInt(); // valor 5

        int poderBien = pelosos * 1 + elfos * 5;
        int poderMal = orcos * 2 + trolls * 5;

        System.out.println("Poder del bien: " + poderBien);
        System.out.println("Poder del mal: " + poderMal);

        if (poderBien > poderMal) {
            System.out.println("Gana el bien");
        } else if (poderMal > poderBien) {
            System.out.println("Gana el mal");
        } else {
            System.out.println("Empate");
        }
    }
}
