package co.edu.tdea.edd.model.geography;


import co.edu.tdea.edd.model.ValueSetCode;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


/**
 * Entidad para las ciudades asociadas a un departamento
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City extends ValueSetCode implements Serializable {
    private Department department;

    @Override
    public String toString() {
        return getCode() + " - " + getDescription();
    }
}
