import java.util.*;

public class MaquinaExpendedora {
    public static Object[] comprarProducto(int[] monedas, int producto) {
        String[] productos = {"Agua", "Refresco", "Jugo"};
        int[] precios = {100, 150, 200};
        int[] monedasValidas = {5, 10, 50, 100, 200};

        int total = 0;
        for (int m : monedas) {
            boolean valida = false;
            for (int v : monedasValidas) {
                if (m == v) valida = true;
            }
            if (!valida) {
                System.out.println("Moneda no válida: " + m);
                return new Object[]{"Error", monedas};
            }
            total += m;
        }

        if (producto < 0 || producto >= productos.length) {
            System.out.println("Producto no existe.");
            return new Object[]{"Error", monedas};
        }

        int precio = precios[producto];
        if (total < precio) {
            System.out.println("Dinero insuficiente.");
            return new Object[]{"Error", monedas};
        }

        int cambio = total - precio;
        List<Integer> vuelto = new ArrayList<>();
        int[] valores = {200, 100, 50, 10, 5};
        for (int v : valores) {
            while (cambio >= v) {
                cambio -= v;
                vuelto.add(v);
            }
        }

        return new Object[]{productos[producto], vuelto.toArray(new Integer[0])};
    }

    public static void main(String[] args) {
        int[] monedas = {100, 50, 10};
        int producto = 1; // Refresco
        Object[] resultado = comprarProducto(monedas, producto);
        System.out.println("Producto: " + resultado[0]);
        System.out.println("Vuelto: " + Arrays.toString((Object[])resultado[1]));
    }
}
