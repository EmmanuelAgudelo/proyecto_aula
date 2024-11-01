package co.edu.tdea.edd.model.commons;

import co.edu.tdea.edd.model.ValueSetCode;

import java.io.Serializable;

public class Disability extends ValueSetCode implements Serializable {
    @Override
    public String toString() {
        return getCode() + " - " + getDescription();
    }
}