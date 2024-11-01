package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Entidad para almacenar la información de las Entidades Prestadoras de los Servicios en Salud EGSSS
 */

public class HealthBenefitsPlanEntity extends ValueSetCode implements Serializable{
    @Override
    public String toString() {
        return getCode() + " - " + getDescription();
    }
}