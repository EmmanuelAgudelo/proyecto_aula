package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import lombok.Getter;

/**
 * Entidad encargada de los datos asociados a la Etnia
 */
@Getter
public class DocumentType extends ValueSetCode implements Serializable {

    public enum DocumentTypeEnum {

        CC("Cédula de Ciudadanía"),
        CE("Cédula de Extranjería"),
        CD("Carnet Diplomático"),
        PA("Pasaporte"),
        SC("Salvoconducto de Permanencia"),
        PT("Permiso Temporal"),
        PE("Permiso Especial de Permanencia"),
        RC("Registro Civil"),
        TI("Tarjeta de Identidad"),
        CN("Certificado de Nacimiento"),
        AS("Asilo"),
        MS("Migración Special"),
        DE("Documento de Extranjería"),
        SI("Salvoconducto Individual");

        private final String description;

        DocumentTypeEnum(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public static DocumentTypeEnum selectOption() {
            try (Scanner sc = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Seleccione una de las siguientes opciones:");
                    System.out.println(CC);
                    System.out.println(CE);
                    System.out.println(CD);
                    System.out.println(PA);
                    System.out.println(SC);
                    System.out.println(PT);
                    System.out.println(PE);
                    System.out.println(RC);
                    System.out.println(TI);
                    System.out.println(CN);
                    System.out.println(AS);
                    System.out.println(MS);
                    System.out.println(DE);
                    System.out.println(SI);

                    var opt = sc.nextLine();
                    var select = Arrays.stream(DocumentTypeEnum.values())
                            .filter(e -> e.name().equalsIgnoreCase(opt))
                            .findFirst();

                    if (select.isPresent())
                        return select.get();
                    else
                        System.out.println("La opción ingresada no es válida. Intente nuevamente.");
                }
            }
        }


    }

}