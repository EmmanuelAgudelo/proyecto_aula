package co.edu.tdea.edd.model.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Entidad para almacenar la información de las Entidades Prestadoras de los Servicios en Salud EGSSS
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthBenefitsPlanEntity implements Serializable {
    private String code;

    private String description;

}