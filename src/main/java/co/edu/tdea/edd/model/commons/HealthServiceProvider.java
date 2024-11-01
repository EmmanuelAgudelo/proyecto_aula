package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Entidad encargada de los datos asociados con los Prestadores de servicios en salud o IPS
 */

public class HealthServiceProvider extends ValueSetCode implements Serializable {
    @Override
    public String toString() {
        return getCode() + " - " + getDescription();
    }
}