package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import lombok.Getter;

/**
 * Entidad para encargada de los datos relacionados con las Discapacidades.
 */
@Getter


public class Disability extends ValueSetCode implements Serializable {

    public enum DisabilityEnum {

        PHYSICAL("Discapacidad física"),
        VISUAL("Discapacidad visual"),
        AUDITORY("Discapacidad auditiva"),
        INTELLECTUAL("Discapacidad intelectual"),
        PSYCHOSOCIAL("Discapacidad psicosocial (mental)"),
        DEAFBLINDNESS("Sordoceguera"),
        MULTIPLE("Discapacidad múltiple"),
        NONE("Sin discapacidades");

        private final String description;

        DisabilityEnum(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public static DisabilityEnum selectOption() {
            try (Scanner sc = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Seleccione una de las siguientes opciones:");
                    System.out.println(PHYSICAL);
                    System.out.println(VISUAL);
                    System.out.println(AUDITORY);
                    System.out.println(INTELLECTUAL);
                    System.out.println(PSYCHOSOCIAL);
                    System.out.println(DEAFBLINDNESS);
                    System.out.println(MULTIPLE);
                    System.out.println(NONE);

                    var opt = sc.nextLine();
                    var select = Arrays.stream(DisabilityEnum.values())
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