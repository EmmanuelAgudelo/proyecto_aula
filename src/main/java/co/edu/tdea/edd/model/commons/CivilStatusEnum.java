package co.edu.tdea.edd.model.commons;

import static co.edu.tdea.edd.model.commons.BiologicalSexEnum.INTERSEX;
import static co.edu.tdea.edd.model.commons.BiologicalSexEnum.MAN;
import static co.edu.tdea.edd.model.commons.BiologicalSexEnum.WOMEN;
import java.util.Arrays;
import java.util.Scanner;
import lombok.Getter;

/**
 * Enumeración que representa  los estados civiles
 *
 */
@Getter
public enum CivilStatusEnum {
    SINGLE("Soltero"),
    MARRIED("Casado/Unión libre"),
    WIDOW("Viudo"),
    DIVORCED("Divorciado");

    private final String description;

    CivilStatusEnum(String description) {
        this.description = description;
    }

    public static CivilStatusEnum getSINGLE() {
        return SINGLE;
    }

    public static CivilStatusEnum getMARRIED() {
        return MARRIED;
    }

    public static CivilStatusEnum getWIDOW() {
        return WIDOW;
    }

    public static CivilStatusEnum getDIVORCED() {
        return DIVORCED;
    }

    public static CivilStatusEnum selectOption(){
        try(Scanner sc = new Scanner(System.in)){
            while(true){
                System.out.println("Seleccione una de las siguientes opciones:");
                System.out.println(SINGLE);
                System.out.println(MARRIED);
                System.out.println(WIDOW);
                System.out.println(DIVORCED);
                var opt = sc.next();
                var select = Arrays.stream(CivilStatusEnum.values()).filter(e -> e.getDescription().equals(opt)).findFirst();
                if(select.isPresent())
                    return select.get();
                else
                    System.out.println("La opción ingresada no es valida. Intente nuevamente.");
            }
        }
    }

}