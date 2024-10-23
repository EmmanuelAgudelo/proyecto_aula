package co.edu.tdea.edd;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.commons.Occupation;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.Department;
import co.edu.tdea.edd.model.user.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EddApplication {

    private static final String PASSSWORD_SYSTEM = "123456789";
    private static List locations = new List<>();

    public static void main(String[] args) {
        load();
        menu();
    }

    public static void load() {
// Crear un país

        Country colombia = new Country();
        colombia.setCode("00");
        colombia.setDescription("Colombia");

// Crear un departamento

        Department antioquia = new Department();
        antioquia.setCode("05");
        antioquia.setDescription("Antioquia");
        antioquia.setCountry(colombia);

// Crear y añadir ciudades

        City medellin = new City();
        medellin.setCode("05001");
        medellin.setDescription("Medellín");
        medellin.setDepartment(antioquia);
        locations.add(medellin);

        City bello = new City();
        bello.setCode("05088");
        bello.setDescription("Bello");
        bello.setDepartment(antioquia);
        locations.add(bello);

        City abejorral = new City();
        abejorral.setCode("05002");
        abejorral.setDescription("Abejorral");
        abejorral.setDepartment(antioquia);
        locations.add(abejorral);

        City abriaqui = new City();
        abriaqui.setCode("05004");
        abriaqui.setDescription("Abriaquí");
        abriaqui.setDepartment(antioquia);
        locations.add(abriaqui);

        City alejandria = new City();
        alejandria.setCode("05021");
        alejandria.setDescription("Alejandría");
        alejandria.setDepartment(antioquia);
        locations.add(alejandria);

        City amaga = new City();
        amaga.setCode("05030");
        amaga.setDescription("Amagá");
        amaga.setDepartment(antioquia);
        locations.add(amaga);

        City amalfi = new City();
        amalfi.setCode("05031");
        amalfi.setDescription("Amalfi");
        amalfi.setDepartment(antioquia);
        locations.add(amalfi);

        City andes = new City();
        andes.setCode("05034");
        andes.setDescription("Andes");
        andes.setDepartment(antioquia);
        locations.add(andes);

        City angelopolis = new City();
        angelopolis.setCode("05036");
        angelopolis.setDescription("Angelópolis");
        angelopolis.setDepartment(antioquia);
        locations.add(angelopolis);

        City angostura = new City();
        angostura.setCode("05038");
        angostura.setDescription("Angostura");
        angostura.setDepartment(antioquia);
        locations.add(angostura);

        City anori = new City();
        anori.setCode("05040");
        anori.setDescription("Anorí");
        anori.setDepartment(antioquia);
        locations.add(anori);


// Crear categoría de ocupación

//        List ocupaciones = new List<>();
//
//        Occupation fuerzasMilitares = new Occupation();
//        fuerzasMilitares.setCode("0");
//        fuerzasMilitares.setDescription("Fuerzas Militares");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(fuerzasMilitares);
//
//        Occupation directoresGerentes = new Occupation();
//        directoresGerentes.setCode("1");
//        directoresGerentes.setDescription("Directores y Gerentes");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(directoresGerentes);
//
//        Occupation profesionalesCientificos = new Occupation();
//        profesionalesCientificos.setCode("2");
//        profesionalesCientificos.setDescription("Profesionales, Científicos e Intelectuales");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(profesionalesCientificos);
//
//        Occupation tecnicosNivelMedio = new Occupation();
//        tecnicosNivelMedio.setCode("3");
//        tecnicosNivelMedio.setDescription("Técnicos y Profesionales de Nivel Medio");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(tecnicosNivelMedio);
//
//        Occupation apoyoAdministrativo = new Occupation();
//        apoyoAdministrativo.setCode("4");
//        apoyoAdministrativo.setDescription("Personal de Apoyo Administrativo");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(apoyoAdministrativo);
//
//        Occupation serviciosVendedores = new Occupation();
//        serviciosVendedores.setCode("5");
//        serviciosVendedores.setDescription("Trabajadores de los Servicios y Vendedores de Comercios y Mercados");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(serviciosVendedores);
//
//        Occupation agricultoresTrabajadores = new Occupation();
//        agricultoresTrabajadores.setCode("6");
//        agricultoresTrabajadores.setDescription("Agricultores y Trabajadores Calificados Agropecuarios, Forestales, Pesqueros y Cazadores");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(agricultoresTrabajadores);
//
//        Occupation oficialesOperarios = new Occupation();
//        oficialesOperarios.setCode("7");
//        oficialesOperarios.setDescription("Oficiales, Operarios, Artesanos y Oficios Relacionados");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(oficialesOperarios);
//
//        Occupation operadoresMaquinas = new Occupation();
//        operadoresMaquinas.setCode("8");
//        operadoresMaquinas.setDescription("Operadores de Instalaciones y Máquinas y Ensambladores");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(operadoresMaquinas);
//
//        Occupation ocupacionesElementales = new Occupation();
//        ocupacionesElementales.setCode("9");
//        ocupacionesElementales.setDescription("Ocupaciones Elementales");
//        fuerzasMilitares.setInactive(false);
//        ocupaciones.add(ocupacionesElementales);
    }

    public static void menu() {
        System.out.println("Bienvenido a GC v0.1.0");
        Scanner sc = new Scanner(System.in);

        int intentos = 3;

        List<User> users = new List<>(); // Lista de pacientes

        do {
            System.out.print("Ingrese la contraseña del sistema: ");

            String password = sc.nextLine();

            if (PASSSWORD_SYSTEM.equals(password)) {
                System.out.println("Ingresando al sistema!");
                int modulo;
                do {
                    System.out.println("------- Modulos -------");
                    System.out.println("0 -> Buscar paciente");
                    System.out.println("1 -> Crear paciente");
                    System.out.println("2 -> Crear contacto de salud"); // si el paciente ya existe
                    System.out.println("3 -> Proceso de atención");
                    System.out.println("4 -> Proceso de facturación");
                    System.out.println("5 -> Salir");
                    System.out.println();
                    System.out.print("Seleccione Modulo: ");

                    modulo = sc.nextInt();
                    sc.nextLine();
                    System.out.println();

                    switch (modulo) {
                        case 0: // Buscar paciente
                            System.out.println("Digite el documento del paciente: ");
                            String documento = sc.nextLine();

                            User userEncontrado = users.buscarPorDocumento(documento);

                            if (userEncontrado != null) {
                                System.out.println("Paciente encontrado: " + userEncontrado.getFirstName() + " " + userEncontrado.getLastName() + userEncontrado.getCity().toString());
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;

                        case 1: // Crear paciente
// Crear un nuevo paciente
                            System.out.println("Creando nuevo paciente...");
                            User nuevoPaciente = new User();

                            System.out.print("Digite el documento: ");
                            nuevoPaciente.setDocument(sc.nextLine());

                            System.out.print("Digite el primer nombre: ");
                            nuevoPaciente.setFirstName(sc.nextLine());

                            System.out.print("Digite el segundo nombre (opcional): ");
                            nuevoPaciente.setMiddleName(sc.nextLine());

                            System.out.print("Digite el apellido: ");
                            nuevoPaciente.setLastName(sc.nextLine());

                            System.out.print("Digite el segundo apellido (opcional): ");
                            nuevoPaciente.setSurname(sc.nextLine());

//                            System.out.print("Digite la fecha de nacimiento (yyyy-mm-dd): ");
//                            String fechaNacimientoInput = sc.nextLine();
//                            nuevoPaciente.setBirthDateTime(LocalDateTime.parse(fechaNacimientoInput + "T00:00:00")); // Asumiendo fecha sin hora

// Selección de nacionalidad
//                            locations.listCities();
//                            System.out.println("Seleccione la nacionalidad (Ingrese el índice): ");
//                            int codeCity = sc.nextInt();
//                            nuevoPaciente.();
//
//// Selección de ciudad de residencia
                            System.out.println("Seleccione la ciudad de residencia (Ingrese el índice): ");
                            locations.listCities();
                            String codeCity = sc.nextLine();
                            sc.nextLine(); // Limpiar buffer
                            nuevoPaciente.setCity(locations.buscarCiudadPorCodigo(codeCity)); // Asignar la ciudad seleccionada
//
//// Selección de sexo biológico
//                            System.out.println("Seleccione el sexo biológico (Ingrese el índice): ");
//                            BiologicalSexEnum[] sexosBiologicos = BiologicalSexEnum.values();
//                            for (int i = 0; i < sexosBiologicos.length; i++) {
//                                System.out.println(i + " -> " + sexosBiologicos[i]);
//                            }
//                            int indexSexoBiologico = sc.nextInt();
//                            sc.nextLine(); // Limpiar buffer
//                            nuevoPaciente.setBiologicalSex(sexosBiologicos[indexSexoBiologico]);
//
//// Selección de estado civil
//                            System.out.println("Seleccione el estado civil (Ingrese el índice): ");
//                            CivilStatusEnum[] estadosCiviles = CivilStatusEnum.values();
//                            for (int i = 0; i < estadosCiviles.length; i++) {
//                                System.out.println(i + " -> " + estadosCiviles[i]);
//                            }
//                            int indexEstadoCivil = sc.nextInt();
//                            sc.nextLine(); // Limpiar buffer
//                            nuevoPaciente.setCivilStatus(estadosCiviles[indexEstadoCivil]);
//
//// Selección de ocupación
//                            System.out.println("Seleccione la ocupación (Ingrese el índice): ");
//                            for (int i = 0; i < ocupaciones.size(); i++) {
//                                System.out.println(i + " -> " + ocupaciones.get(i).getDescription());
//                            }
//                            int indexOcupacion = sc.nextInt();
//                            sc.nextLine(); // Limpiar buffer
//                            nuevoPaciente.setOccupation(ocupaciones.get(indexOcupacion));

// Otras opciones si son necesarias
                            System.out.print("¿Es donante voluntario? (true/false): ");
                            nuevoPaciente.setVoluntaryDonation(sc.nextBoolean());
                            sc.nextLine(); // Limpiar buffer

                            System.out.print("¿Posee testamento anticipado? (true/false): ");
                            nuevoPaciente.setAdvanceWill(sc.nextBoolean());
                            sc.nextLine(); // Limpiar buffer

                            users.add(nuevoPaciente);
                            break;

                        case 2: // Crear contacto de salud (Si el paciente ya existe)
                            User pacienteBuscado = new User();
                            System.out.println("Digite el documento del paciente para añadir contacto de salud: ");
                            String docPaciente = sc.nextLine();

                            // Crear un objeto User temporal con el documento ingresado
                            pacienteBuscado.setDocument(docPaciente);

                            // Llamada al método buscar de la lista
                            User paciente = users.buscar(pacienteBuscado);

                            if (paciente != null) {
                                System.out.println("Paciente encontrado. Agregando contacto de salud...");
                                // Aquí puedes agregar la lógica para crear un contacto de salud
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;

                        case 3: // Proceso de atención
                            System.out.println("Iniciando proceso de atención...");
                            // Agregar lógica para el proceso de atención
                            break;

                        case 4: // Proceso de facturación
                            System.out.println("Iniciando proceso de facturación...");
                            // Agregar lógica para el proceso de facturación
                            break;

                        case 5: // Salir
                            System.out.println("Saliendo del sistema...");
                            break;

                        default:
                            System.out.println("Error: la opción no es correcta.");
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
