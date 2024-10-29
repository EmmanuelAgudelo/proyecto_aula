package co.edu.tdea.edd;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.commons.*;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.Department;
import co.edu.tdea.edd.model.geography.LivingPlace;
import lombok.Getter;

public class DataLoader {
    @Getter
    private static List<Country> countries = new List<>();
    @Getter
    private static List<Department> departments = new List<>();
    @Getter
    private static List<City> cities = new List<>();
//    @Getter
//    private static List<Disability> disabilities = new List<>();
//    @Getter
//    private static List<Ethni> ethnicities = new List<>();
//    @Getter
//    private static List<EthnicCommunity> ethnicCommunities = new List<>();
//    @Getter
//    private static List<GenderIdentity> genderIdentities = new List<>();
//    @Getter
//    private static List<LivingPlace> livingPlaces = new List<>();
//    @Getter
//    private static List<Occupation> occupations = new List<>();
//    @Getter
//    private static List<HealthServiceProvider> healthServiceProviders = new List<>();
//    @Getter
//    private static List<HealthBenefitsPlanEntity> healthBenefitsPlanEntities = new List<>();

    public static void load() {
        loadCountries();
        loadDepartments();
        loadCities();
//        loadDisabilities();
//        loadEthnicities();
//        loadEthnicCommunities();
//        loadGenderIdentities();
//        loadLivingPlaces();
//        loadOccupations();
//        loadHealthServiceProviders();
//        loadHealthBenefitsPlanEntities();
    }

    private static void loadCountries() {
        Country colombia = new Country();
        colombia.setCode("00");
        colombia.setDescription("Colombia");
        countries.add(colombia);

        System.out.println("Países cargados:");
        countries.printList();
    }

    private static void loadDepartments() {
        Country colombia = countries.getHead().getData();

        Department antioquia = new Department();
        antioquia.setCode("05");
        antioquia.setDescription("Antioquia");
        antioquia.setCountry(colombia);
        departments.add(antioquia);

        System.out.println("Departamentos cargados:");
        departments.printList();
    }

    private static void loadCities() {
        Department antioquia = departments.getHead().getData();
        City medellin = new City();
        medellin.setCode("05001");
        medellin.setDescription("Medellín");
        medellin.setDepartment(antioquia);
        cities.add(medellin);

        System.out.println("Ciudades cargadas:");
        cities.printList();
    }

//    private static void loadDisabilities() {
//        Disability visual = new Disability();
//        visual.setCode("01");
//        visual.setDescription("Visual");
//        disabilities.add(visual);
//
//        Disability auditiva = new Disability();
//        auditiva.setCode("02");
//        auditiva.setDescription("Auditiva");
//        disabilities.add(auditiva);
//
//        System.out.println("Discapacidades cargadas:");
//        disabilities.printList();
//    }
//
//    private static void loadEthnicities() {
//        Ethni indigena = new Ethni();
//        indigena.setCode("01");
//        indigena.setDescription("Indígena");
//        ethnicities.add(indigena);
//
//        Ethni afrodescendiente = new Ethni();
//        afrodescendiente.setCode("02");
//        afrodescendiente.setDescription("Afrodescendiente");
//        ethnicities.add(afrodescendiente);
//
//        System.out.println("Etnias cargadas:");
//        ethnicities.printList();
//    }
//
//    private static void loadEthnicCommunities() {
//        EthnicCommunity wayuu = new EthnicCommunity();
//        wayuu.setCode("01");
//        wayuu.setDescription("Wayuu");
//        ethnicCommunities.add(wayuu);
//
//        EthnicCommunity embera = new EthnicCommunity();
//        embera.setCode("02");
//        embera.setDescription("Emberá");
//        ethnicCommunities.add(embera);
//
//        System.out.println("Comunidades étnicas cargadas:");
//        ethnicCommunities.printList();
//    }
//
//    private static void loadGenderIdentities() {
//        GenderIdentity masculino = new GenderIdentity();
//        masculino.setCode("01");
//        masculino.setDescription("Masculino");
//        genderIdentities.add(masculino);
//
//        GenderIdentity femenino = new GenderIdentity();
//        femenino.setCode("02");
//        femenino.setDescription("Femenino");
//        genderIdentities.add(femenino);
//
//        System.out.println("Identidades de género cargadas:");
//        genderIdentities.printList();
//    }
//
//    private static void loadLivingPlaces() {
//        LivingPlace urbano = new LivingPlace();
//        urbano.setCode("01");
//        urbano.setDescription("Urbano");
//        livingPlaces.add(urbano);
//
//        LivingPlace rural = new LivingPlace();
//        rural.setCode("02");
//        rural.setDescription("Rural");
//        livingPlaces.add(rural);
//
//        System.out.println("Lugares de vivienda cargados:");
//        livingPlaces.printList();
//    }
//
//    private static void loadOccupations() {
//        Occupation ingeniero = new Occupation();
//        ingeniero.setCode("01");
//        ingeniero.setDescription("Ingeniero");
//        occupations.add(ingeniero);
//
//        Occupation medico = new Occupation();
//        medico.setCode("02");
//        medico.setDescription("Médico");
//        occupations.add(medico);
//
//        System.out.println("Ocupaciones cargadas:");
//        occupations.printList();
//    }
//
//    private static void loadHealthServiceProviders() {
//        HealthServiceProvider epsSura = new HealthServiceProvider();
//        epsSura.setCode("01");
//        epsSura.setDescription("EPS Sura");
//        healthServiceProviders.add(epsSura);
//
//        HealthServiceProvider nuevaEps = new HealthServiceProvider();
//        nuevaEps.setCode("02");
//        nuevaEps.setDescription("Nueva EPS");
//        healthServiceProviders.add(nuevaEps);
//
//        System.out.println("Proveedores de servicios de salud cargados:");
//        healthServiceProviders.printList();
//    }
//
//    private static void loadHealthBenefitsPlanEntities() {
//        HealthBenefitsPlanEntity planBasico = new HealthBenefitsPlanEntity();
//        planBasico.setCode("01");
//        planBasico.setDescription("Plan Básico");
//        healthBenefitsPlanEntities.add(planBasico);
//
//        HealthBenefitsPlanEntity planComplementario = new HealthBenefitsPlanEntity();
//        planComplementario.setCode("02");
//        planComplementario.setDescription("Plan Complementario");
//        healthBenefitsPlanEntities.add(planComplementario);
//
//        System.out.println("Entidades de planes de beneficios de salud cargadas:");
//        healthBenefitsPlanEntities.printList();
//    }
}