package co.edu.tdea.edd.model.geography;


import co.edu.tdea.edd.model.ValueSetCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * Entidad para los departamentos asociados a un país
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department extends ValueSetCode implements Serializable {


    private Country country;

}
