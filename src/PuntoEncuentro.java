import java.util.Scanner;

public class PuntoEncuentro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Objeto 1
        System.out.println("Posición x1 y1:");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.println("Velocidad vx1 vy1:");
        double vx1 = sc.nextDouble();
        double vy1 = sc.nextDouble();

        // Objeto 2
        System.out.println("Posición x2 y2:");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        System.out.println("Velocidad vx2 vy2:");
        double vx2 = sc.nextDouble();
        double vy2 = sc.nextDouble();

        double dx = x1 - x2;
        double dy = y1 - y2;
        double dvx = vx2 - vx1;
        double dvy = vy2 - vy1;

        if (dvx == 0 && dvy == 0) {
            if (dx == 0 && dy == 0) {
                System.out.println("Ya están en el mismo punto.");
            } else {
                System.out.println("Nunca se encontrarán.");
            }
        } else {
            double tX = dvx != 0 ? dx / dvx : -1;
            double tY = dvy != 0 ? dy / dvy : -1;

            if ((tX == tY) && tX >= 0) {
                double xEncuentro = x1 + vx1 * tX;
                double yEncuentro = y1 + vy1 * tX;
                System.out.println("Se encuentran en (" + xEncuentro + ", " + yEncuentro + ") en t = " + tX);
            } else {
                System.out.println("No se encontrarán.");
            }
        }
    }
}
