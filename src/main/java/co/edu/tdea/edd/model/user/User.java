package co.edu.tdea.edd.model.user;


import co.edu.tdea.edd.model.commons.BiologicalSexEnum;
import co.edu.tdea.edd.model.commons.CivilStatusEnum;
import co.edu.tdea.edd.model.commons.Disability;
import co.edu.tdea.edd.model.commons.EducationLevelEnum;
import co.edu.tdea.edd.model.commons.Ethni;
import co.edu.tdea.edd.model.commons.EthnicCommunity;
import co.edu.tdea.edd.model.commons.GenderIdentity;
import co.edu.tdea.edd.model.commons.HealthBenefitsPlanEntity;
import co.edu.tdea.edd.model.commons.HealthServiceProvider;
import co.edu.tdea.edd.model.commons.Occupation;
import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.geography.Country;
import co.edu.tdea.edd.model.geography.LivingPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad para los datos asociados a los usuarios
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    private String firstName;

    private String middleName;

    private String lastName;

    private String surname;

    private Country nationality;

    private LocalDateTime birthDateTime;

    private BiologicalSexEnum biologicalSex;

    private Disability disability;

    private Ethni ethni;

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

}
