package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.util.Arrays;
import java.util.Scanner;

public enum CivilStatusEnum {

    SINGLE(new ValueSetCode("1", "Soltero")),
    MARRIED(new ValueSetCode("2", "Casado")),
    WIDOW(new ValueSetCode("3", "Viudo")),
    DIVORCED(new ValueSetCode("4", "Divorciado"));

    private final ValueSetCode valueSetCode;

    CivilStatusEnum(ValueSetCode valueSetCode) {
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

    public static CivilStatusEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones:");
            for (CivilStatusEnum status : CivilStatusEnum.values()) {
                System.out.println(status);
            }
            String opt = sc.next();
            var select = Arrays.stream(CivilStatusEnum.values())
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