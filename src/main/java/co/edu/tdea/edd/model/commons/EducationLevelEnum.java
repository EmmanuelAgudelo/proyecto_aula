package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.util.Arrays;
import java.util.Scanner;

public enum EducationLevelEnum {

    PRIMARY(new ValueSetCode("1", "Primaria")),
    SECONDARY(new ValueSetCode("2", "Secundaria")),
    UNIVERSITY(new ValueSetCode("3", "Universidad"));

    private final ValueSetCode valueSetCode;

    EducationLevelEnum(ValueSetCode valueSetCode) {
        this.valueSetCode = valueSetCode;
    }

    public String getCode() {
        return valueSetCode.getCode();
    }

    public String getDescription() {
        return valueSetCode.getDescription();
    }

    @Override
    public String toString() {
        return getCode() + " - " + getDescription();
    }

    public static EducationLevelEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones:");
            for (EducationLevelEnum level : EducationLevelEnum.values()) {
                System.out.println(level);
            }
            String opt = sc.next();
            var select = Arrays.stream(EducationLevelEnum.values())
                    .filter(e -> e.getCode().equals(opt))
                    .findFirst();
            if (select.isPresent()) {
                return select.get();
            } else {
                System.out.println("La opción ingresada no es válida. Intente nuevamente.");
            }
        }
    }
}