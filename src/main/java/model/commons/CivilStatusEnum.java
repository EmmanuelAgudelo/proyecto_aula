package co.edu.tdea.edd.model.commons;

import lombok.Getter;

/**
 * Enumeración que representa  los estados civiles
 *
 */
@Getter
public enum CivilStatusEnum {
    SINGLE("Soltero"),
    MARRIED("Casado/Unión libre"),
    WIDOW("Viudo"),
    DIVORCED("Divorciado");

    private final String description;

    CivilStatusEnum(String description) {
        this.description = description;
    }

}
