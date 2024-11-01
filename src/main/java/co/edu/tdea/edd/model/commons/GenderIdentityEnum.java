package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Enumerador para Identidades de Género.
 */
public enum GenderIdentityEnum {

    CISGENDER_MAN(new ValueSetCode("1", "Hombre Cisgénero")),
    CISGENDER_WOMAN(new ValueSetCode("2", "Mujer Cisgénero")),
    TRANSGENDER_MAN(new ValueSetCode("3", "Hombre Transgénero")),
    TRANSGENDER_WOMAN(new ValueSetCode("4", "Mujer Transgénero")),
    NON_BINARY(new ValueSetCode("5", "No Binario")),
    GENDERQUEER(new ValueSetCode("6", "Genderqueer")),
    OTHER(new ValueSetCode("7", "Otra Identidad"));

    private final ValueSetCode valueSetCode;

    GenderIdentityEnum(ValueSetCode valueSetCode) {
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

    public static GenderIdentityEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes identidades de género:");
            for (GenderIdentityEnum identity : GenderIdentityEnum.values()) {
                System.out.println(identity);
            }
            String opt = sc.next();
            var select = Arrays.stream(GenderIdentityEnum.values())
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
