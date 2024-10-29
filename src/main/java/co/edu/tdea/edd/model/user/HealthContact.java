package co.edu.tdea.edd.model.user;

import co.edu.tdea.edd.services.PatientService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HealthContact {

    public HealthContact(User patient, String triageCategory) {
        this.patient = patient;
        this.contactDate = LocalDateTime.now();
        this.triageCategory = triageCategory;
        // Inicializar otros campos si es necesario
    }
    private User patient;
    private LocalDateTime contactDate;
    private String triageCategory;
    private String reason;
    private String diagnosis;
    private String treatment;
    // todo:Otros campos según la Resolución 866 de 2021
}