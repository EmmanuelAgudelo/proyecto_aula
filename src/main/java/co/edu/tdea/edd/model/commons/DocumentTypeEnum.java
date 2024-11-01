package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.util.Arrays;
import java.util.Scanner;

public enum DocumentTypeEnum {

    ID(new ValueSetCode("1", "Cédula de ciudadanía")),
    PASSPORT(new ValueSetCode("2", "Pasaporte")),
    ID_FOREIGN(new ValueSetCode("3", "Cédula de extranjería"));

    private final ValueSetCode valueSetCode;

    DocumentTypeEnum(ValueSetCode valueSetCode) {
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

    public static DocumentTypeEnum selectOption(Scanner sc) {
        while (true) {
            System.out.println("Seleccione una de las siguientes opciones:");
            for (DocumentTypeEnum type : DocumentTypeEnum.values()) {
                System.out.println(type);
            }
            String opt = sc.next();
            var select = Arrays.stream(DocumentTypeEnum.values())
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