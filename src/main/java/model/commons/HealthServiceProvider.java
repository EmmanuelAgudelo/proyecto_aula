package co.edu.tdea.edd.model.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Entidad encargada de los datos asociados con los Prestadores de servicios en salud o IPS
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthServiceProvider implements Serializable {

    private String code;

    private String description;

    private String providerCode;

    private Boolean status;
}