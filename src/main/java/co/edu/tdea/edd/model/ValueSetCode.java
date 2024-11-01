package co.edu.tdea.edd.model;

import co.edu.tdea.edd.model.geography.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ValueSetCode {
    private String code;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueSetCode code = (ValueSetCode) o;
        return Objects.equals(getCode(), code.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}