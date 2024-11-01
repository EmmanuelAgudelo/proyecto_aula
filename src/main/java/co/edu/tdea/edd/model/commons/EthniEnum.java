package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.util.Arrays;
import java.util.Scanner;

public enum EthniEnum {

    INDIGENOUS(new ValueSetCode("1", "Indígena")),
    AFRO_DESCENDANT(new ValueSetCode("2", "Afrodescendiente")),
    ROM(new ValueSetCode("3", "Rom")),
    WHITE(new ValueSetCode("4", "Blanco")),
    OTHER(new ValueSetCode("5", "Otro"));

    private final ValueSetCode valueSetCode;

    EthniEnum(ValueSetCode valueSetCode) {
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

    public static EthniEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones:");
            for (EthniEnum ethni : EthniEnum.values()) {
                System.out.println(ethni);
            }
            String opt = sc.next();
            var select = Arrays.stream(EthniEnum.values())
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