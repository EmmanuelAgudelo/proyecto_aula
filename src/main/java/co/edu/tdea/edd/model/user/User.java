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
public class User implements Serializable {

    private DocumentTypeEnum documentType;

    private String document;

    private String firstName;

    private String middleName;

    private String lastName;

    private String surname;

    private Country nationality;

    private LocalDate birthDate;

    private BiologicalSexEnum biologicalSex;

    private Disability disability;

    private EthniEnum ethni;

    private EthniCommunityEnum ethniaCommunity;

    private GenderIdentityEnum genderIdentity;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getDocument(), user.getDocument());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocument());
    }

    @Override
    public String toString() {
        return "User   {" +
                "documentType=" + (documentType != null ? documentType.getDescription() : "null") +
                ", document='" + (document != null ? document : "null") + '\'' +
                ", firstName='" + (firstName != null ? firstName : "null") + '\'' +
                ", middleName='" + (middleName != null ? middleName : "null") + '\'' +
                ", lastName='" + (lastName != null ? lastName : "null") + '\'' +
                ", surname='" + (surname != null ? surname : "null") + '\'' +
                ", birthDate=" + (birthDate != null ? birthDate : "null") +
                ", nationality=" + (nationality != null ? nationality.getDescription() : "null") +
                ", city=" + (city != null ? city.getDescription() : "null") +
                ", address='" + (address != null ? address : "null") + '\'' +
                ", livingPlace=" + (livingPlace != null ? livingPlace.getDescription() : "null") +
                ", biologicalSex=" + (biologicalSex != null ? biologicalSex.getDescription() : "null") +
                ", disability=" + (disability != null ? disability.getDescription() : "null") +
                ", ethni=" + (ethni != null ? ethni.getDescription() : "null") +
                ", ethniaCommunity=" + (ethniaCommunity != null ? ethniaCommunity.getDescription() : "null") +
                ", genderIdentity=" + (genderIdentity != null ? genderIdentity.getDescription() : "null") +
                ", civilStatus=" + (civilStatus != null ? civilStatus.getDescription() : "null") +
                ", educationLevel=" + (educationLevel != null ? educationLevel.getDescription() : "null") +
                ", occupation=" + (occupation != null ? occupation.getDescription() : "null") +
                ", voluntaryDonation=" + (voluntaryDonation != null ? (voluntaryDonation ? "Sí" : "No") : "null") +
                ", voluntaryDonationSubscriptionDate=" + (voluntaryDonationSubscriptionDate != null ? voluntaryDonationSubscriptionDate : "null") +
                ", advanceWill=" + (advanceWill != null ? (advanceWill ? "Sí" : "No") : "null") +
                ", advanceWillHSPId=" + advanceWillHSPId + // Asumiendo que este es un Long y puede ser null
                ", advanceWillHSP=" + (advanceWillHSP != null ? advanceWillHSP : "null") +
                ", advanceWillSubscriptionDate=" + (advanceWillSubscriptionDate != null ? advanceWillSubscriptionDate : "null") +
                ", healthBenefitsPlanEntity=" + (healthBenefitsPlanEntity != null ? healthBenefitsPlanEntity.getDescription() : "null") +
                ", healthServiceProvider=" + (healthServiceProvider != null ? healthServiceProvider.getDescription() : "null") +
                ", familyCompensationBox=" + (familyCompensationBox != null ? familyCompensationBox.getDescription() : "null") +
                ", occupationalRiskInsuranceCompany=" + (occupationalRiskInsuranceCompany != null ? occupationalRiskInsuranceCompany.getDescription() : "null") +
                '}';
    }
}
