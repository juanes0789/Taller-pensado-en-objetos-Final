/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelFollowersFinal;
import empleados.Empleado;
import empleados.Chef;
import empleados.Housekeeping;
import empleados.Manager;
import empleados.Receptionist;
/**
 *
 * @author Juaan
 */
import java.util.Scanner;

public class ScheduleApp {
    private static final String[] DAYS = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    private static final String[] SHIFTS = {"Manana", "Tarde", "Noche"};
    private static String[][] chefSchedule = new String[DAYS.length][SHIFTS.length];
    private static String[][] housekeepingSchedule = new String[DAYS.length][SHIFTS.length];
    private static String[][] managerSchedule = new String[DAYS.length][SHIFTS.length];
    private static String[][] receptionistSchedule = new String[DAYS.length][SHIFTS.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option != 3) {
            System.out.println("---------- Sistema de gestion de turnos de trabajo (SGTT) ----------");
            System.out.println("\nMenu:");
            System.out.println("1. Asignar turno");
            System.out.println("2. Visualizar horarios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    assignSchedule(scanner);
                    break;
                case 2:
                    printAllSchedules();
                    break;
                case 3:
                    System.out.println("Saliendo. Hasta luego!");
                    break;
                
                default:
                    System.out.println("Opcion no válida. Por favor, seleccione una opción valida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void assignSchedule(Scanner scanner) {
        System.out.print("Ingrese el tipo de empleado (Chef, Housekeeping, Manager, Receptionist): ");
        String employeeType = scanner.next().toLowerCase();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.next();
        System.out.print("Ingrese el dia (Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo): ");
        String day = scanner.next();
        System.out.print("Ingrese el turno (Manana, Tarde, Noche): ");
        String shift = scanner.next();

        String[][] schedule;
        Empleado empleado = null;
        switch (employeeType) {
        case "chef":
            empleado = new Chef(nombre, apellido);
            schedule = chefSchedule;
            break;
        case "housekeeping":
            empleado = new Housekeeping(nombre, apellido);
            schedule = housekeepingSchedule;
            break;
        case "manager":
            empleado = new Manager(nombre, apellido);
            schedule = managerSchedule;
            break;
        case "receptionist":
            empleado = new Receptionist(nombre, apellido);
            schedule = receptionistSchedule;
            break;
        default:
            System.out.println("Tipo de empleado no valido.");
            return;
    }

    for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equalsIgnoreCase(day)) {
                for (int j = 0; j < SHIFTS.length; j++) {
                    if (SHIFTS[j].equalsIgnoreCase(shift)) {
                        if (schedule[i][j] == null) {
                            schedule[i][j] = empleado.getNombre() + " " + empleado.getApellido();
                            System.out.println("Turno asignado con exito: " + empleado.getNombre() + " " + empleado.getApellido() + " el " + day + " en la " + shift);
                        } else {
                            System.out.println("El turno seleccionado ya esta ocupado. Intente con otro horario.");
                        }
                        return;
                    }
                }
            }
        }

        System.out.println("Dia o turno ingresado no valido.");
    }


    private static void printAllSchedules() {
    System.out.println("Turnos asignados:");
    printSchedule("Chefs", DAYS, SHIFTS, chefSchedule);
    printSchedule("Housekeepings", DAYS, SHIFTS, housekeepingSchedule);
    printSchedule("Managers", DAYS, SHIFTS, managerSchedule);
    printSchedule("Receptionists", DAYS, SHIFTS, receptionistSchedule);
}
    
      private static void printSchedule(String employeeType, String[] days, String[] shifts, String[][] schedule) {
        System.out.println(employeeType + " Schedule:");
        for (int i = 0; i < schedule.length; i++) {
            System.out.println(days[i] + ":");
            for (int j = 0; j < schedule[i].length; j++) {
                System.out.println("\t" + shifts[j] + ": " + (schedule[i][j] != null ? schedule[i][j] : "No asignado"));
            }
        }
    }
}


