package co.edu.tdea.edd;

import java.util.Scanner;

public class EddApplication {

    private static final String PASSSWORD_SYSTEM = "contrasena!";
    private static Credencial credencialCreada;

    public static void main(String[] args) {
        load();
        menu();
    }

    public static void load() {
        System.out.println("Cargando");
    }

    public static void menu() {
        System.out.println("Bienvenido a GC v0.1.0");

        Scanner sc = new Scanner(System.in);

        int intentos = 3;

        GestorCredenciales gestorCredenciales = new GestorCredenciales();

        do {
            System.out.print("Ingrese la contraseña del sistema: ");

            String password = sc.nextLine();

            if (PASSSWORD_SYSTEM.equals(password)) {
                System.out.println("Ingresando al sistema!");
                int modulo;
                do {
                    System.out.println("------- Modulos -------");
                    System.out.println("0 -> Listar Credenciales");
                    System.out.println("1 -> Crear Credencial");
                    System.out.println("2 -> Agregar Credencial");
                    System.out.println("3 -> Buscar Credencial");
                    System.out.println("4 -> Salir");
                    System.out.println();
                    System.out.print("Seleccione Modulo: ");
                    modulo = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (modulo) {
                        case 0:
                            gestorCredenciales.listarCredenciales();
                            break;
                        case 1:
                            credencialCreada = gestorCredenciales.crearCredencial();
                            break;
                        case 2:
                            if (credencialCreada == null) {
                                System.out.println("No hay credencial en memoria!");
                            } else {
                                gestorCredenciales.agregarCredencial(credencialCreada);
                            }
                            break;
                        case 3:
                            //int id = gestorCredenciales.buscarCredencial("SPA");
                            //System.out.println("ID: "+id);
                            break;
                        case 4:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Error la opcion no es correcta");
                            break;
                    }
                    System.out.println();
                } while (modulo != 4);

            } else {
                intentos--;
                System.out.println("Error tiene " + intentos + " intentos");
            }

        } while (intentos != 0);

        sc.close();

    }
}
