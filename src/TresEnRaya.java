public class TresEnRaya {
    public static String evaluarMatriz(String[][] matriz) {
        int xCount = 0, oCount = 0;


        for (String[] fila : matriz) {
            for (String celda : fila) {
                if (celda.equals("X")) xCount++;
                else if (celda.equals("O")) oCount++;
                else if (!celda.equals("")) return "Nulo";
            }
        }

        if (Math.abs(xCount - oCount) > 1) return "Nulo";

        boolean ganaX = gana(matriz, "X");
        boolean ganaO = gana(matriz, "O");

        if (ganaX && ganaO) return "Nulo";
        else if (ganaX) return "X";
        else if (ganaO) return "O";
        else if (xCount + oCount == 9) return "Empate";
        else return "Nulo";
    }

    private static boolean gana(String[][] m, String s) {
        for (int i = 0; i < 3; i++) {
            if (m[i][0].equals(s) && m[i][1].equals(s) && m[i][2].equals(s)) return true; // fila
            if (m[0][i].equals(s) && m[1][i].equals(s) && m[2][i].equals(s)) return true; // columna
        }
        if (m[0][0].equals(s) && m[1][1].equals(s) && m[2][2].equals(s)) return true; // diagonal
        if (m[0][2].equals(s) && m[1][1].equals(s) && m[2][0].equals(s)) return true; // diagonal inversa
        return false;
    }

    public static void main(String[] args) {
        String[][] matriz = {
                {"X", "O", "X"},
                {"O", "X", "O"},
                {"O", "X", "X"}
        };
        System.out.println("Resultado: " + evaluarMatriz(matriz));
    }
}
