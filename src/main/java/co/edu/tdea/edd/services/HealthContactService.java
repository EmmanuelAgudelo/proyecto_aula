package co.edu.tdea.edd.services;

import co.edu.tdea.edd.estructure.linkedList.singly.Nodo;
import co.edu.tdea.edd.estructure.queue.Queue;
import co.edu.tdea.edd.estructure.stack.Stack;
import co.edu.tdea.edd.model.health_contact.HealthContact;
import co.edu.tdea.edd.model.user.User;

public class HealthContactService {
    private static Queue<HealthContact> triageI = new Queue<>();
    private static Queue<HealthContact> triageII = new Queue<>();
    private static Queue<HealthContact> triageIII = new Queue<>();
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

    public static void printQueues() {
        System.out.println("Contenido de la cola de triaje I:");
        printQueue(triageI);

        System.out.println("Contenido de la cola de triaje II:");
        printQueue(triageII);

        System.out.println("Contenido de la cola de triaje III:");
        printQueue(triageIII);
    }

    private static void printQueue(Queue<HealthContact> queue) {
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo<HealthContact> current = queue.getPrimero();

        while (current != null) {
            HealthContact contact = current.getData();
            System.out.println("Paciente: " + contact.getPatient().getFirstName());
            current = current.getNext();
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
            System.out.println("Facturación completada para el paciente: " + contact.getPatient());
        } else {
            System.out.println("No hay pacientes para facturar.");
        }
    }
}
