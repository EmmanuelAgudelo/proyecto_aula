package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.util.Arrays;
import java.util.Scanner;

public enum BiologicalSexEnum {

    MAN(new ValueSetCode("1", "Hombre")),
    WOMAN(new ValueSetCode("2", "Mujer")),
    INTERSEX(new ValueSetCode("3", "Indeterminado/Intersexual"));

    private final ValueSetCode valueSetCode;

    BiologicalSexEnum(ValueSetCode valueSetCode) {
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

    public static BiologicalSexEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones:");
            for (BiologicalSexEnum sex : BiologicalSexEnum.values()) {
                System.out.println(sex);
            }
            String opt = sc.next();
            var select = Arrays.stream(BiologicalSexEnum.values())
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