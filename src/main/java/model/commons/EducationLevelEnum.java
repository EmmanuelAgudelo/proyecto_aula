package co.edu.tdea.edd.model.commons;

import lombok.Getter;

/**
 * Enumeración que representa los niveles educativos
 *
 */
@Getter
public enum EducationLevelEnum  {
    ELEMENTARY_SCHOOL("Primaria"),
    HIGH_SCHOOL("Bachillerato"),
    PROFESSIONAL("Profesional"),
    SPECIALIZATION("Especialización"),
    MASTERS("Maestría"),
    WITHOUT_STUDIES("Sin estudios");

    private final String description;

    EducationLevelEnum(String description) {
        this.description = description;
    }

}
