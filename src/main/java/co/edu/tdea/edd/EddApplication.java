package co.edu.tdea.edd;

import co.edu.tdea.edd.model.GenericInfo;
import co.edu.tdea.edd.model.commons.*;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.user.User;
import co.edu.tdea.edd.services.GenericInfoService;
import co.edu.tdea.edd.services.HealthContactService;
import co.edu.tdea.edd.services.PatientService;

import java.time.LocalDate;
import java.util.Scanner;

public class EddApplication {
    private static PatientService patientService = new PatientService();
    private static HealthContactService healthContactService = new HealthContactService();
    private static GenericInfoService genericInfoService = new GenericInfoService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        DataLoader.load();
        System.out.println("Datos cargados exitosamente.");
        loadGenericInfo();
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Buscar Paciente");
            System.out.println("2. Crear Paciente");
            System.out.println("3. Crear Contacto de Salud");
            System.out.println("4. Proceso de Atención");
            System.out.println("5. Proceso de Facturación");
            System.out.println("6. Gestionar Información Genérica");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1: searchPatient(); break;
                case 2: createPatient(); break;
                case 3: createHealthContact(); break;
                case 4: attendPatient(); break;
                case 5: billPatient(); break;
                case 6: manageGenericInfo(); break;
                case 7: System.exit(0);
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private static void searchPatient() {
        System.out.print("Ingrese el documento del paciente: ");
        String document = sc.nextLine();
        User patient = patientService.findUser(document);
        if (patient != null) {
            System.out.println("Paciente encontrado: " + patient.getFirstName() + " " + patient.getLastName());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    public static void createPatient() {
        Scanner sc = new Scanner(System.in);
        User newUser = new User();

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

//        City city1 = new City();
//
//        System.out.println("Seleccione ciudad de residencia:");
//        DataLoader.getCities().forEach(city -> {
//            System.out.println(city.getCode() + ". " + city.getDescription());
//        });
//        city1.setCode(sc.nextLine());
//        City selectedCity = DataLoader.getCities().search(city1);
//        if (selectedCity != null) {
//            newUser.setCity(selectedCity);
//        } else {
//            System.out.println("Ciudad no encontrada.");
//        }

        // Fecha de nacimiento
//        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
//        newUser.setBirthDate(LocalDate.parse(sc.next()));

        newUser.setBiologicalSex(BiologicalSexEnum.selectOption());
        newUser.setCivilStatus(CivilStatusEnum.selectOption());
        newUser.setDisability(Disability.DisabilityEnum.selectOption());
        newUser.setDocumentType(DocumentType.DocumentTypeEnum.selectOption());
        newUser.setEducationLevel(EducationLevelEnum.selectOption());
        newUser.setEthni(Ethni.EthniEmun.selectOption());

//        // Dirección
//        System.out.print("Dirección: ");
//        sc.nextLine(); // Limpiar buffer
//        newUser.setAddress(sc.nextLine());

//// Selección de discapacidad
//        System.out.println("Seleccione discapacidad (si aplica):");
//        DataLoader.getDisabilities().forEach(disability -> {
//            System.out.println(disability.getCode() + ". " + disability.getDescription());
//        });
//        String disabilityCode = sc.nextLine();
//        if (!disabilityCode.isEmpty()) {
//            Disability selectedDisability = DataLoader.getDisabilities().search(new Disability(disabilityCode, null));
//            if (selectedDisability != null) {
//                newUser.setDisability(selectedDisability);
//            } else {
//                System.out.println("Discapacidad no encontrada.");
//            }
//        }
//
//// Selección de etnia
//        System.out.println("Seleccione etnia:");
//        DataLoader.getEthnicities().forEach(ethni -> {
//            System.out.println(ethni.getCode() + ". " + ethni.getDescription());
//        });
//        String ethniCode = sc.nextLine();
//        Ethni selectedEthni = DataLoader.getEthnicities().search(new Ethni(ethniCode, null));
//        if (selectedEthni != null) {
//            newUser.setEthni(selectedEthni);
//        } else {
//            System.out.println("Etnia no encontrada.");
//        }
//
//// Selección de comunidad étnica
//        System.out.println("Seleccione comunidad étnica (si aplica):");
//        DataLoader.getEthnicCommunities().forEach(community -> {
//            System.out.println(community.getCode() + ". " + community.getDescription());
//        });
//        String communityCode = sc.nextLine();
//        if (!communityCode.isEmpty()) {
//            EthnicCommunity selectedCommunity = DataLoader.getEthnicCommunities().search(new EthnicCommunity(communityCode, null));
//            if (selectedCommunity != null) {
//                newUser.setEthniaCommunity(selectedCommunity);
//            } else {
//                System.out.println("Comunidad étnica no encontrada.");
//            }
//        }
//
//// Selección de identidad de género
//        System.out.println("Seleccione identidad de género:");
//        DataLoader.getGenderIdentities().forEach(gender -> {
//            System.out.println(gender.getCode() + ". " + gender.getDescription());
//        });
//        String genderCode = sc.nextLine();
//        GenderIdentity selectedGender = DataLoader.getGenderIdentities().search(new GenderIdentity(genderCode, null));
//        if (selectedGender != null) {
//            newUser.setGenderIdentity(selectedGender);
//        } else {
//            System.out.println("Identidad de género no encontrada.");
//        }
//
//// Selección de lugar de residencia
//        System.out.println("Seleccione tipo de lugar de residencia:");
//        DataLoader.getLivingPlaces().forEach(place -> {
//            System.out.println(place.getCode() + ". " + place.getDescription());
//        });
//        String livingPlaceCode = sc.nextLine();
//        LivingPlace selectedLivingPlace = DataLoader.getLivingPlaces().search(new LivingPlace(livingPlaceCode, null));
//        if (selectedLivingPlace != null) {
//            newUser.setLivingPlace(selectedLivingPlace);
//        } else {
//            System.out.println("Lugar de residencia no encontrado.");
//        }
//
//// Estado civil
//        System.out.println("Seleccione estado civil:");
//        for (CivilStatusEnum status : CivilStatusEnum.values()) {
//            System.out.println(status.name() + ". " + status.getDescription());
//        }
//        String civilStatusName = sc.nextLine();
//        try {
//            newUser.setCivilStatus(CivilStatusEnum.valueOf(civilStatusName.toUpperCase()));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Estado civil no válido.");
//        }

// Nivel educativo
//        System.out.println("Seleccione nivel educativo:");
//        for (EducationLevelEnum level : EducationLevelEnum.values()) {
//            System.out.println(level.name() + ". " + level.getDescription());
//        }
//        String educationLevelName = sc.nextLine();
//        try {
//            newUser.setEducationLevel(EducationLevelEnum.valueOf(educationLevelName.toUpperCase()));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Nivel educativo no válido.");
//        }
//
//// Ocupación
//        System.out.println("Seleccione ocupación:");
//        DataLoader.getOccupations().forEach(occupation -> {
//            System.out.println(occupation.getCode() + ". " + occupation.getDescription());
//        });
//        String occupationCode = sc.nextLine();
//        Occupation selectedOccupation = DataLoader.getOccupations().search(new Occupation());
//        if (selectedOccupation != null) {
//            newUser.setOccupation(selectedOccupation);
//        } else {
//            System.out.println("Ocupación no encontrada.");
//        }
//
//// Donación voluntaria
//        System.out.print("¿Es donante voluntario? (true/false): ");
//        newUser.setVoluntaryDonation(Boolean.parseBoolean(sc.nextLine()));
//        if (newUser.getVoluntaryDonation()) {
//            newUser.setVoluntaryDonationSubscriptionDate(LocalDate.now());
//        }
//
//// Testamento vital
//        System.out.print("¿Tiene testamento vital? (true/false): ");
//        newUser.setAdvanceWill(Boolean.parseBoolean(sc.nextLine()));
//        if (newUser.getAdvanceWill()) {
//            newUser.setAdvanceWillSubscriptionDate(LocalDate.now());
//
//            // Selección de proveedor de servicios de salud para testamento vital
//            System.out.println("Seleccione proveedor de servicios de salud para testamento vital:");
//            DataLoader.getHealthServiceProviders().forEach(provider -> {
//                System.out.println(provider.getCode() + ". " + provider.getDescription());
//            });
//            String hspCode = sc.nextLine();
//            HealthServiceProvider selectedHSP = DataLoader.getHealthServiceProviders().search(new HealthServiceProvider());
//            if (selectedHSP != null) {
//                newUser.setAdvanceWillHSP(selectedHSP);
//            } else {
//                System.out.println("Proveedor de servicios de salud no encontrado.");
//            }
//        }
//
//// Entidad del plan de beneficios de salud
//        System.out.println("Seleccione entidad del plan de beneficios de salud:");
//        DataLoader.getHealthBenefitsPlanEntities().forEach(entity -> {
//            System.out.println(entity.getCode() + ". " + entity.getDescription());
//        });
//        String healthBenefitsCode = sc.nextLine();
//
//        HealthServiceProvider selectedHealthServiceProvider = DataLoader.getHealthServiceProviders().search(new HealthServiceProvider());
//        if (selectedHealthServiceProvider != null) {
//            newUser.setHealthServiceProvider(selectedHealthServiceProvider);
//        } else {
//            System.out.println("Proveedor de servicios de salud no encontrado.");
//        }

// Retornar el usuario creado

    }

    private static void createHealthContact() {
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

    private static void attendPatient() {
        healthContactService.attendPatient();
    }

    private static void billPatient() {
        healthContactService.billPatient();
    }

    private static void manageGenericInfo() {
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

    private static void loadGenericInfo() {
        // Cargar información genérica inicial
        genericInfoService.addGenericInfo(new GenericInfo("001", "Tipo de Sangre A+"));
        genericInfoService.addGenericInfo(new GenericInfo("002", "Tipo de Sangre B+"));
        // Añadir más información genérica según sea necesario
    }
}
