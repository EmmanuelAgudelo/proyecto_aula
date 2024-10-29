package co.edu.tdea.edd.model.geography;


import co.edu.tdea.edd.model.ValueSetCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(department, city.department);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(department);
    }
    public String toString() {
        return getCode() + " - " + getDescription();
    }
}
