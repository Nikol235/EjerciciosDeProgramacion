import java.time.Duration;
import java.time.LocalDateTime;

public class Adviento {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.of(2022, 12, 5, 13, 30);
        mostrarEstado(ahora);
    }

    public static void mostrarEstado(LocalDateTime fecha) {
        LocalDateTime inicio = LocalDateTime.of(2022, 12, 1, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2022, 12, 24, 23, 59, 59);

        if (fecha.isBefore(inicio)) {
            Duration d = Duration.between(fecha, inicio);
            System.out.println("Faltan " + d.toDays() + " días para que comience el calendario.");
        } else if (!fecha.isAfter(fin)) {
            int dia = fecha.getDayOfMonth();
            LocalDateTime finDia = fecha.withHour(23).withMinute(59).withSecond(59);
            Duration restante = Duration.between(fecha, finDia);
            System.out.println("Día " + dia + ": Regalo 🎁 = Curso sorpresa!");
            System.out.println("Tiempo restante de sorteo: " + restante.toHours() + "h " + (restante.toMinutes() % 60) + "m");
        } else {
            Duration despues = Duration.between(fin, fecha);
            System.out.println("El calendario finalizó hace " + despues.toDays() + " días.");
        }
    }
}
