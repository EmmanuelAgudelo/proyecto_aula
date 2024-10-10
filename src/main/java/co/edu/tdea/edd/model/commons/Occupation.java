package co.edu.tdea.edd.model.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Modelo de datos para las ocupaciones.
 *
 * @author julian.martinez@alternova.com
 * @version 1.0
 * @since 14/12/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Occupation implements Serializable {

    private String code;

    private String description;

    private Boolean inactive;

}
