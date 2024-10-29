package co.edu.tdea.edd.model.user;


import co.edu.tdea.edd.model.commons.*;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.LivingPlace;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad para los datos asociados a los usuarios
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {

    private DocumentType.DocumentTypeEnum documentType;

    private String document;

    private String firstName;

    private String middleName;

    private String lastName;

    private String surname;

    private Country nationality;

    private LocalDate birthDate;

    private BiologicalSexEnum biologicalSex;

    private Disability.DisabilityEnum disability;

    private Ethni.EthniEmun ethni;

    private EthnicCommunity ethniaCommunity;

    private GenderIdentity genderIdentity;

    private Country countryOfResidence;

    private City city;

    private String address;

    private LivingPlace livingPlace;

    private CivilStatusEnum civilStatus;

    private EducationLevelEnum educationLevel;

    private Occupation occupation;

    private Boolean voluntaryDonation;

    private LocalDate voluntaryDonationSubscriptionDate;

    private Boolean advanceWill;

    private Long advanceWillHSPId;

    private HealthServiceProvider advanceWillHSP;

    private LocalDate advanceWillSubscriptionDate;

    private HealthBenefitsPlanEntity healthBenefitsPlanEntity;

    private HealthServiceProvider healthServiceProvider;

    private HealthBenefitsPlanEntity familyCompensationBox;

    private HealthBenefitsPlanEntity occupationalRiskInsuranceCompany;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User ) obj;
        return document.equals(user.document); // Suponiendo que 'document' es el identificador único
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}
