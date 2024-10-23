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
public class Ethni extends ValueSetCode implements Serializable {

    public enum EthniEmun {

        INDIGENOUS("Indígena"),
        ROM("Gitanos"),
        RAIZAL("San Andrés y Providencia"),
        PALENQUERO("Palenquero de San Basilio de Palenque"),
        BLACK("Negro"),
        AFROCOLOMBIAN("Afrocolombiano"),
        NONE("Ninguna de las anteriores");

        private final String description;

        EthniEmun(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public static EthniEmun selectOption() {
            try (Scanner sc = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Seleccione una de las siguientes opciones:");
                    System.out.println(INDIGENOUS);
                    System.out.println(ROM);
                    System.out.println(RAIZAL);
                    System.out.println(PALENQUERO);
                    System.out.println(BLACK);
                    System.out.println(AFROCOLOMBIAN);
                    System.out.println(NONE);

                    var opt = sc.nextLine();
                    var select = Arrays.stream(EthniEmun.values())
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