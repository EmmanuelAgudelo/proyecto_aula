package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Enumerador para las Comunidades Étnicas.
 */
public enum EthniCommunityEnum {

    INDIGENOUS_COMMUNITY(new ValueSetCode("1", "Comunidad Indígena")),
    AFRO_DESCENDANT_COMMUNITY(new ValueSetCode("2", "Comunidad Afrodescendiente")),
    ROM_COMMUNITY(new ValueSetCode("3", "Comunidad Rom")),
    RAIZAL_COMMUNITY(new ValueSetCode("4", "Comunidad Raizal")),
    PALENQUERA_COMMUNITY(new ValueSetCode("5", "Comunidad Palenquera")),
    OTHER_COMMUNITY(new ValueSetCode("6", "Otra Comunidad"));

    private final ValueSetCode valueSetCode;

    EthniCommunityEnum(ValueSetCode valueSetCode) {
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

    public static EthniCommunityEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes comunidades étnicas:");
            for (EthniCommunityEnum community : EthniCommunityEnum.values()) {
                System.out.println(community);
            }
            String opt = sc.next();
            var select = Arrays.stream(EthniCommunityEnum.values())
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
