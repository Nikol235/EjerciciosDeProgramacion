import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiferenciaFechas {
    public static int diasEntreFechas(String fecha1, String fecha2) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try {
            Date f1 = formato.parse(fecha1);
            Date f2 = formato.parse(fecha2);

            long diferenciaMillis = Math.abs(f1.getTime() - f2.getTime());
            return (int) (diferenciaMillis / (1000 * 60 * 60 * 24));

        } catch (ParseException e) {
            throw new Exception("Formato de fecha incorrecto. Usa dd/MM/yyyy");
        }
    }

    public static void main(String[] args) {
        try {
            int dias = diasEntreFechas("20/05/2025", "15/05/2025");
            System.out.println("Días de diferencia: " + dias);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
