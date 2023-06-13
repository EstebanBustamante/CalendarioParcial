import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LocalDate diaDeHoy = LocalDate.now();
        System.out.print("Ingrese el numero de examenes pendientes: ");
        int numeroExamenes = scanner.nextInt();
        scanner.nextLine();

        LocalDate[] fechasParciales = new LocalDate[numeroExamenes];
        String[] nombreMateria = new String[numeroExamenes];
        int[] tiempoRestante = new int[numeroExamenes];

         for (int i = 0; i < numeroExamenes; i++) {
             System.out.print("Ingrese la fecha del examen numero " + (i + 1) + " (a\u00F1o-mes-dia): ");
             String diaDelExamen = scanner.nextLine();
             fechasParciales[i] = LocalDate.parse(diaDelExamen);
 
             System.out.print("Ingrese el nombre de la materia del examen numero " + (i + 1) + ": ");
             nombreMateria[i] = scanner.nextLine();
         }
 
         System.out.print("Ingrese la cantidad de horas promedio que estudia por dia: ");
         int horasDeEstudioDiarias = scanner.nextInt();
 
         for (int i = 0; i < numeroExamenes; i++) {
             long remainingDays = ChronoUnit.DAYS.between(diaDeHoy, fechasParciales[i]);
             tiempoRestante[i] = ((int) remainingDays * horasDeEstudioDiarias);
         }
 
         for (int i = 0; i < numeroExamenes; i++) {
             System.out.println("Para el examen de " + nombreMateria[i] + ":");
             System.out.println("Tenes " + tiempoRestante[i] + " horas restantes para estudiar.");
         }

         scanner.close();
    }
}