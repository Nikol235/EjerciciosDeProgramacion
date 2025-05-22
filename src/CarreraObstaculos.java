public class CarreraObstaculos {
    public static boolean evaluarCarrera(String[] acciones, String pista) {
        if (acciones.length != pista.length()) {
            System.out.println("Longitudes no coinciden.");
            return false;
        }

        StringBuilder resultado = new StringBuilder();
        boolean exito = true;

        for (int i = 0; i < acciones.length; i++) {
            char tramo = pista.charAt(i);
            String accion = acciones[i];

            if ((accion.equals("run") && tramo == '_') || (accion.equals("jump") && tramo == '|')) {
                resultado.append(tramo);
            } else {
                exito = false;
                if (accion.equals("jump") && tramo == '_') {
                    resultado.append("x");
                } else if (accion.equals("run") && tramo == '|') {
                    resultado.append("/");
                }
            }
        }

        System.out.println("Resultado de la pista: " + resultado);
        return exito;
    }

    public static void main(String[] args) {
        String[] acciones = {"run", "jump", "run", "jump", "run"};
        String pista = "_|_|_";

        boolean superada = evaluarCarrera(acciones, pista);
        System.out.println("¿Carrera superada?: " + superada);
    }
}
