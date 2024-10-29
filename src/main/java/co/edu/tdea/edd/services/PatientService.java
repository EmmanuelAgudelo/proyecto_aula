package co.edu.tdea.edd.services;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.estructure.queue.Queue;
import co.edu.tdea.edd.estructure.stack.Stack;
import co.edu.tdea.edd.model.GenericInfo;
import co.edu.tdea.edd.model.user.HealthContact;
import co.edu.tdea.edd.model.user.User;

public class PatientService {
    private List<User> patients = new List<>();

    public void addUser(User patient) {
        patients.add(patient);
    }

    public User findUser(String document) {
        return patients.search(new User());
    }

    public void printListUser(){
        patients.printList();
    }

    public void updateUser(User patient) {
        User existingUser = findUser(patient.getDocument());
        if (existingUser != null) {
            patients.remove(existingUser);
            patients.add(patient);
        }
    }
}

