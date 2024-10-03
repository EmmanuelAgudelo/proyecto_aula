package co.edu.tdea.edd.model.geography;


import co.edu.tdea.edd.model.ValueSetCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * Entidad para las ciudades asociadas a un departamento
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City extends ValueSetCode implements Serializable {
    private Department department;

}
