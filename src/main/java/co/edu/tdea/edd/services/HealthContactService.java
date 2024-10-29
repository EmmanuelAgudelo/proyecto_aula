package co.edu.tdea.edd.services;

import co.edu.tdea.edd.estructure.queue.Queue;
import co.edu.tdea.edd.estructure.stack.Stack;
import co.edu.tdea.edd.model.user.HealthContact;
import co.edu.tdea.edd.model.user.User;

public class HealthContactService {
    private Queue<HealthContact> triageI = new Queue<>();
    private Queue<HealthContact> triageII = new Queue<>();
    private Queue<HealthContact> triageIII = new Queue<>();
    private Stack<HealthContact> billingStack = new Stack<>();

    public void createContact(User patient, String triageCategory) {
        HealthContact contact = new HealthContact(patient, triageCategory);
        switch (triageCategory) {
            case "I":
                triageI.enqueue(contact);
                break;
            case "II":
                triageII.enqueue(contact);
                break;
            case "III":
                triageIII.enqueue(contact);
                break;
            default:
                System.out.println("Categoría de triaje no válida.");
                break;
        }
    }

    public void attendPatient() {
        HealthContact contact;
        if (!triageI.isEmpty()) {
            contact = triageI.dequeue();
        } else if (!triageII.isEmpty()) {
            contact = triageII.dequeue();
        } else if (!triageIII.isEmpty()) {
            contact = triageIII.dequeue();
        } else {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        billingStack.push(contact);
        System.out.println("Paciente atendido y movido a facturación: " + contact.getPatient().getFirstName());
    }

    public void billPatient() {
        if (!billingStack.isEmpty()) {
            HealthContact contact = billingStack.pop();
            System.out.println("Facturación completada para el paciente: " + contact.getPatient().getClass());
        } else {
            System.out.println("No hay pacientes para facturar.");
        }
    }
}
