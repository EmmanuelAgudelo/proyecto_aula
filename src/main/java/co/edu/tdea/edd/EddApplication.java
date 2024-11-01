package co.edu.tdea.edd;

import static co.edu.tdea.edd.Controller.*;

public class EddApplication {
    public static void main(String[] args) {
        DataLoader.load();
        menu();
    }

    public static void menu(){
        System.out.println("Datos cargados exitosamente.");
        loadGenericInfo();
        while (true) {

            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Buscar Paciente");
            System.out.println("2. Crear Paciente");
            System.out.println("3. Crear Contacto de Salud");
            System.out.println("4. Ver cola de pacientes");
            System.out.println("5. Proceso de Atención");
            System.out.println("6. Proceso de Facturación");
            System.out.println("7. Gestionar Información Genérica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1: searchPatient(); break;
                case 2: createPatient(); break;
                case 3: createHealthContact(); break;
                case 4: printQueue(); break;
                case 5: attendPatient(); break;
                case 6: billPatient(); break;
                case 7: manageGenericInfo(); break;
                case 8: System.exit(0);
                default: System.out.println("Opción no válida.");
            }
        }
    }
}
