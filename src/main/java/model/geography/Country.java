package co.edu.tdea.edd.model.geography;


import co.edu.tdea.edd.model.ValueSetCode;

import java.io.Serializable;

/**
 * Entidad para los países
 */
public class Country extends ValueSetCode implements Serializable {

    public String toString() {
        return getCode() + " - " + getDescription();
    }
}
