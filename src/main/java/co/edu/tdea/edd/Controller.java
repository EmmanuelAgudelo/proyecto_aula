package co.edu.tdea.edd;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.commons.*;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.LivingPlace;
import co.edu.tdea.edd.model.health_contact.GenericInfo;
import co.edu.tdea.edd.model.user.User;
import co.edu.tdea.edd.services.GenericInfoService;
import co.edu.tdea.edd.services.HealthContactService;
import co.edu.tdea.edd.services.PatientService;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Controller {
    private static final PatientService patientService = new PatientService();
    private static final HealthContactService healthContactService = new HealthContactService();
    private static final GenericInfoService genericInfoService = new GenericInfoService();
    static final Scanner sc = new Scanner(System.in);

    static void searchPatient() {
        System.out.print("Ingrese el documento del paciente: ");
        String document = sc.nextLine();
        User patient = patientService.findUser(document);
        if (patient != null) {
            System.out.println("Paciente encontrado: " + patient.getFirstName() + " " + patient.getLastName());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    static void printQueue(){
        HealthContactService.printQueues();
    }

    public static void createPatient() {
        User newUser = new User();
        City city1 = new City();
        LivingPlace place1 = new LivingPlace();
        Occupation occupation1 = new Occupation();
        HealthBenefitsPlanEntity healthBenefitsCode = new HealthBenefitsPlanEntity();

        newUser.setDocumentType(DocumentTypeEnum.selectOption(sc));
        sc.nextLine(); // Limpiar buffer

        System.out.print("Documento: ");
        newUser.setDocument(sc.nextLine());

        System.out.print("Primer nombre: ");
        newUser.setFirstName(sc.nextLine());

        System.out.print("Segundo nombre: ");
        newUser.setMiddleName(sc.nextLine());

        System.out.print("Primer apellido: ");
        newUser.setLastName(sc.nextLine());

        System.out.print("Segundo apellido: ");
        newUser.setSurname(sc.nextLine());
        while (true) {
            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            String input = sc.next();
            try {
                LocalDate birthDate = LocalDate.parse(input);
                newUser.setBirthDate(birthDate);
                break; // Salir del bucle si la fecha es válida
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, usa el formato YYYY-MM-DD.");
            }
        }
        sc.nextLine(); // Limpiar buffer


        System.out.println("Seleccione ciudad de residencia:");
        DataLoader.getCities().forEach(city -> {
            System.out.println(city.getCode() + ". " + city.getDescription());
        });
        city1.setCode(sc.nextLine());
        City selectedCity = DataLoader.getCities().search(city1);
        if (selectedCity != null) {
            newUser.setCity(selectedCity);
        } else {
            System.out.println("Ciudad no encontrada.");
        }

// Selección de lugar de residencia

        System.out.println("Seleccione tipo de lugar de residencia:");
        DataLoader.getLivingPlaces().forEach(place -> {
            System.out.println(place.getCode() + ". " + place.getDescription());
        });
        place1.setCode(sc.nextLine());
        LivingPlace selectedLivingPlace = DataLoader.getLivingPlaces().search(place1);
        if (selectedLivingPlace != null) {
            newUser.setLivingPlace(selectedLivingPlace);
        } else {
            System.out.println("Lugar de residencia no encontrado.");
        }

        // Dirección

        System.out.print("Dirección: ");
        newUser.setAddress(sc.nextLine());

// Ocupación
        System.out.println("Seleccione ocupación:");
        DataLoader.getOccupations().forEach(occupation -> {
            System.out.println(occupation.getCode() + ". " + occupation.getDescription());
        });
        occupation1.setCode(sc.nextLine());
        Occupation selectedOccupation = DataLoader.getOccupations().search(occupation1);
        if (selectedOccupation != null) {
            newUser.setOccupation(selectedOccupation);
        } else {
            System.out.println("Ocupación no encontrada.");
        }

        newUser.setBiologicalSex(BiologicalSexEnum.selectOption(sc));

        newUser.setCivilStatus(CivilStatusEnum.selectOption(sc));


        newUser.setEducationLevel(EducationLevelEnum.selectOption(sc));

        newUser.setEthni(EthniEnum.selectOption(sc));

// Donación voluntaria
        System.out.print("¿Es donante voluntario? (true/false): ");
        newUser.setVoluntaryDonation(Boolean.parseBoolean(sc.nextLine()));
        if (newUser.getVoluntaryDonation()) {
            newUser.setVoluntaryDonationSubscriptionDate(LocalDate.now());
        }

// Testamento vital
        System.out.print("¿Tiene testamento vital? (true/false): ");
        newUser.setAdvanceWill(Boolean.parseBoolean(sc.nextLine()));
        HealthServiceProvider healthServiceProvider = new HealthServiceProvider();
        if (newUser.getAdvanceWill()) {
            newUser.setAdvanceWillSubscriptionDate(LocalDate.now());

            // Selección de proveedor de servicios de salud para testamento vital
            System.out.println("Seleccione proveedor de servicios de salud para testamento vital:");
            DataLoader.getHealthServiceProviders().forEach(provider -> {
                System.out.println(provider.getCode() + ". " + provider.getDescription());
            });
            healthServiceProvider.setCode(sc.nextLine());
            HealthServiceProvider selectedHSP = DataLoader.getHealthServiceProviders().search(healthServiceProvider);
            if (selectedHSP != null) {
                newUser.setAdvanceWillHSP(selectedHSP);
            } else {
                System.out.println("Proveedor de servicios de salud no encontrado.");
            }
        }

// Entidad del plan de beneficios de salud
        System.out.println("Seleccione entidad del plan de beneficios de salud:");
        DataLoader.getHealthBenefitsPlanEntities().forEach(entity -> {
            System.out.println(entity.getCode() + ". " + entity.getDescription());
        });
        healthBenefitsCode.setCode(sc.nextLine());

        HealthBenefitsPlanEntity selectedHealthBenefitsPlanEntity = DataLoader.getHealthBenefitsPlanEntities().search(healthBenefitsCode);
        if (selectedHealthBenefitsPlanEntity != null) {
            newUser.setHealthBenefitsPlanEntity(selectedHealthBenefitsPlanEntity);
        } else {
            System.out.println("Proveedor de servicios de salud no encontrado.");
        }
        DataLoader.getUsers().add(newUser);
    }

    static void createHealthContact() {
        System.out.print("Documento del paciente: ");
        String document = sc.nextLine();
        User patient = patientService.findUser(document);
        if (patient == null) {
            System.out.println("Paciente no encontrado. Cree el paciente primero.");
            return;
        }
        System.out.print("Categoría de triaje (I, II, III): ");
        String triageCategory = sc.nextLine();
        healthContactService.createContact(patient, triageCategory);
        System.out.println("Contacto de salud creado y añadido a la cola de triaje.");
    }

    static void attendPatient() {
        healthContactService.attendPatient();
    }

    static void billPatient() {
        healthContactService.billPatient();
    }

    static void manageGenericInfo() {
        System.out.println("\n--- Gestión de Información Genérica ---");
        System.out.println("1. Añadir información");
        System.out.println("2. Buscar información");
        System.out.println("3. Eliminar información");
        System.out.print("Seleccione una opción: ");
        int option = sc.nextInt();
        sc.nextLine();  // Consume newline

        switch (option) {
            case 1:
                addGenericInfo();
                break;
            case 2:
                searchGenericInfo();
                break;
            case 3:
                removeGenericInfo();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void addGenericInfo() {
        System.out.print("Código: ");
        String code = sc.nextLine();
        System.out.print("Descripción: ");
        String description = sc.nextLine();
        genericInfoService.addGenericInfo(new GenericInfo(code, description));
        System.out.println("Información genérica añadida.");
    }

    private static void searchGenericInfo() {
        System.out.print("Código a buscar: ");
        String code = sc.nextLine();
        GenericInfo info = genericInfoService.findGenericInfo(code);
        if (info != null) {
            System.out.println("Información encontrada: " + info.getDescription());
        } else {
            System.out.println("Información no encontrada.");
        }
    }

    private static void removeGenericInfo() {
        System.out.print("Código a eliminar: ");
        String code = sc.nextLine();
        if (genericInfoService.removeGenericInfo(code)) {
            System.out.println("Información eliminada con éxito.");
        } else {
            System.out.println("No se pudo eliminar la información.");
        }
    }

    static void loadGenericInfo() {
        // Cargar información genérica inicial
        genericInfoService.addGenericInfo(new GenericInfo("001", "Tipo de Sangre A+"));
        genericInfoService.addGenericInfo(new GenericInfo("002", "Tipo de Sangre B+"));
        // Añadir más información genérica según sea necesario
    }
}
