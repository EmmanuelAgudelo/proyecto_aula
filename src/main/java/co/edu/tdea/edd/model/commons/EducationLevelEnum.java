package co.edu.tdea.edd.model.commons;

import static co.edu.tdea.edd.model.commons.CivilStatusEnum.DIVORCED;
import static co.edu.tdea.edd.model.commons.CivilStatusEnum.MARRIED;
import static co.edu.tdea.edd.model.commons.CivilStatusEnum.SINGLE;
import static co.edu.tdea.edd.model.commons.CivilStatusEnum.WIDOW;
import java.util.Arrays;
import java.util.Scanner;
import lombok.Getter;

/**
 * Enumeración que representa los niveles educativos
 *
 */
@Getter
public enum EducationLevelEnum  {
    ELEMENTARY_SCHOOL("Primaria"),
    HIGH_SCHOOL("Bachillerato"),
    PROFESSIONAL("Profesional"),
    SPECIALIZATION("Especialización"),
    MASTERS("Maestría"),
    WITHOUT_STUDIES("Sin estudios");

    private final String description;

    EducationLevelEnum(String description) {
        this.description = description;
    }

    public static EducationLevelEnum getELEMENTARY_SCHOOL() {
        return ELEMENTARY_SCHOOL;
    }

    public static EducationLevelEnum getHIGH_SCHOOL() {
        return HIGH_SCHOOL;
    }

    public static EducationLevelEnum getPROFESSIONAL() {
        return PROFESSIONAL;
    }

    public static EducationLevelEnum getSPECIALIZATION() {
        return SPECIALIZATION;
    }

    public static EducationLevelEnum getMASTERS() {
        return MASTERS;
    }

    public static EducationLevelEnum getWITHOUT_STUDIES() {
        return WITHOUT_STUDIES;
    }

    public static EducationLevelEnum selectOption(){
        try(Scanner sc = new Scanner(System.in)){
            while(true){
                System.out.println("Seleccione una de las siguientes opciones:");
                System.out.println(ELEMENTARY_SCHOOL);
                System.out.println(HIGH_SCHOOL);
                System.out.println(PROFESSIONAL);
                System.out.println(SPECIALIZATION);
                System.out.println(MASTERS);
                System.out.println(WITHOUT_STUDIES);
                var opt = sc.next();
                var select = Arrays.stream(EducationLevelEnum.values()).filter(e -> e.getDescription().equals(opt)).findFirst();
                if(select.isPresent())
                    return select.get();
                else
                    System.out.println("La opción ingresada no es valida. Intente nuevamente.");
            }
        }
    }
}