package co.edu.tdea.edd;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.commons.*;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.Department;
import co.edu.tdea.edd.model.geography.LivingPlace;
import co.edu.tdea.edd.model.user.User;
import lombok.Getter;
import lombok.Setter;

public class DataLoader {
    @Getter
    private static List<Country> countries = new List<>();
    @Getter
    private static List<Department> departments = new List<>();
    @Getter
    private static List<City> cities = new List<>();
    @Getter
    private static List<Disability> disabilities = new List<>();
    @Getter
    private static List<LivingPlace> livingPlaces = new List<>();
    @Getter
    private static List<Occupation> occupations = new List<>();
    @Getter
    private static List<HealthServiceProvider> healthServiceProviders = new List<>();
    @Getter
    private static List<HealthBenefitsPlanEntity> healthBenefitsPlanEntities = new List<>();
    @Getter
    @Setter
    private static List<User> users = new List<>();

    public static void load() {
        loadCountries();
        loadDepartments();
        loadCities();
        loadDisabilities();
        loadLivingPlaces();
        loadOccupations();
        loadHealthServiceProviders();
        loadHealthBenefitsPlanEntities();
    }

    private static void loadCountries() {
        // Agregar 10 países
        String[] countryNames = {"Colombia", "Argentina", "Brasil", "Chile", "Perú", "México", "Venezuela", "Ecuador", "Uruguay", "Paraguay"};
        for (int i = 0; i < countryNames.length; i++) {
            Country country = new Country();
            country.setCode(String.format("%02d", i + 1));
            country.setDescription(countryNames[i]);
            countries.add(country);
        }

        System.out.println("Países cargados");
    }

    private static void loadDepartments() {
        // Agregar 10 departamentos
        String[] departmentNames = {"Antioquia", "Cundinamarca", "Valle del Cauca", "Atlántico", "Santander", "Bolívar", "Risaralda", "Tolima", "Boyacá", "Cauca"};
        Country colombia = countries.getPrimero().getData();  // Asumiendo que el primer país es Colombia
        for (int i = 0; i < departmentNames.length; i++) {
            Department department = new Department();
            department.setCode(String.format("%02d", i + 1));
            department.setDescription(departmentNames[i]);
            department.setCountry(colombia);
            departments.add(department);
        }

        System.out.println("Departamentos cargados");
    }

    private static void loadCities() {
        // Agregar 10 ciudades
        String[] cityNames = {"Medellín", "Bogotá", "Cali", "Barranquilla", "Bucaramanga", "Cartagena", "Pereira", "Ibagué", "Tunja", "Popayán"};
        Department antioquia = departments.getPrimero().getData();  // Asumiendo que el primer departamento es Antioquia
        for (int i = 0; i < cityNames.length; i++) {
            City city = new City();
            city.setCode(String.format("%05d", i + 1));
            city.setDescription(cityNames[i]);
            city.setDepartment(antioquia);
            cities.add(city);
        }

        System.out.println("Ciudades cargadas");
    }

    private static void loadDisabilities() {
        // Agregar 10 tipos de discapacidades
        String[] disabilityNames = {"Visual", "Auditiva", "Motora", "Intelectual", "Psicosocial", "Neurológica", "Cognitiva", "Psíquica", "Cardiovascular", "Respiratoria"};
        for (int i = 0; i < disabilityNames.length; i++) {
            Disability disability = new Disability();
            disability.setCode(String.format("%02d", i + 1));
            disability.setDescription(disabilityNames[i]);
            disabilities.add(disability);
        }

        System.out.println("Discapacidades cargadas");
    }

    private static void loadLivingPlaces() {
        // Agregar 10 tipos de lugares de vivienda
        String[] livingPlaceNames = {"Urbano", "Rural", "Suburbano", "Barrio Cerrado", "Apartamento", "Casa", "Dúplex", "Cabaña", "Finca", "Rancho"};
        for (int i = 0; i < livingPlaceNames.length; i++) {
            LivingPlace livingPlace = new LivingPlace();
            livingPlace.setCode(String.format("%02d", i + 1));
            livingPlace.setDescription(livingPlaceNames[i]);
            livingPlaces.add(livingPlace);
        }

        System.out.println("Lugares de vivienda cargados");
    }

    private static void loadOccupations() {
        // Agregar 10 ocupaciones
        String[] occupationNames = {"Ingeniero", "Médico", "Profesor", "Abogado", "Arquitecto", "Psicólogo", "Contador", "Electricista", "Mecánico", "Carpintero"};
        for (int i = 0; i < occupationNames.length; i++) {
            Occupation occupation = new Occupation();
            occupation.setCode(String.format("%02d", i + 1));
            occupation.setDescription(occupationNames[i]);
            occupations.add(occupation);
        }

        System.out.println("Ocupaciones cargadas");
    }

    private static void loadHealthServiceProviders() {
        // Agregar 10 proveedores de servicios de salud
        String[] providerNames = {"EPS Sura", "Nueva EPS", "Sanitas", "Coomeva", "Medimas", "Compensar", "Famisanar", "Salud Total", "Mutual Ser", "Cafesalud"};
        for (int i = 0; i < providerNames.length; i++) {
            HealthServiceProvider provider = new HealthServiceProvider();
            provider.setCode(String.format("%02d", i + 1));
            provider.setDescription(providerNames[i]);
            healthServiceProviders.add(provider);
        }

        System.out.println("Proveedores de servicios de salud cargados");
    }

    private static void loadHealthBenefitsPlanEntities() {
        // Agregar 10 entidades de planes de beneficios de salud
        String[] planNames = {"Plan Básico", "Plan Complementario", "Plan Especial", "Plan Integral", "Plan Plus", "Plan Dorado", "Plan Platino", "Plan Premium", "Plan Elite", "Plan Familiar"};
        for (int i = 0; i < planNames.length; i++) {
            HealthBenefitsPlanEntity planEntity = new HealthBenefitsPlanEntity();
            planEntity.setCode(String.format("%02d", i + 1));
            planEntity.setDescription(planNames[i]);
            healthBenefitsPlanEntities.add(planEntity);
        }

        System.out.println("Entidades de planes de beneficios de salud cargadas");
    }
}
