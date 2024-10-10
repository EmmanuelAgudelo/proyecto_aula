package co.edu.tdea.edd.model.commons;

import lombok.Getter;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Enumerador de los Sexos Biologicos
 * <br> Se puede realizar la búsqueda por el código o la descripción.
 *
 */
@Getter
public enum BiologicalSexEnum  {


    MAN("1", "Hombre"),
    WOMEN("2", "Mujer"),
    INTERSEX("3", "Indeterminado/Intersexual");

    private final String code;

    private final String description;

    BiologicalSexEnum( String code, String description ) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.code +" - " + description ;
    }

    public static BiologicalSexEnum selectOption(){
        try(Scanner sc = new Scanner(System.in)){
            while(true){
                System.out.println("Seleccione una de las siguientes opciones:");
                System.out.println(MAN);
                System.out.println(WOMEN);
                System.out.println(INTERSEX);
                var opt = sc.next();
                var select = Arrays.stream(BiologicalSexEnum.values()).filter(e -> e.getCode().equals(opt)).findFirst();
                if(select.isPresent())
                    return select.get();
                else
                    System.out.println("La opción ingresada no es valida. Intente nuevamente.");
            }
        }
    }
}