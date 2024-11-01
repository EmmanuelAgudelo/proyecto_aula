package co.edu.tdea.edd.services;

import co.edu.tdea.edd.DataLoader;
import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.user.User;

public class PatientService {
    private List<User> patients = new List<>();

    public void addUser(User patient) {
        patients.add(patient);
    }

    public User findUser(String document) {
        User user = new User();
        user.setDocument(document);
        return DataLoader.getUsers().search(user);
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

