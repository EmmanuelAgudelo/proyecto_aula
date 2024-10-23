/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.tdea.edd.estructure.linkedList.singly;

import co.edu.tdea.edd.model.geography.City;
import co.edu.tdea.edd.model.user.User;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Consumer;

/**
 *
 * @author ESTUDIANTE
 */
public class List<T> {

    private Nodo primero;

    public List() {
        primero = null;
    }

    public void add(T value) {
        Nodo nuevo = new Nodo(null, value); // El siguiente nodo de "nuevo" será null, ya que será el último

        if (primero == null) {
            primero = nuevo; // Si la lista está vacía, el nuevo nodo será el primero
        } else {
            Nodo temp = primero;
            while (temp.getSiguiente() != null) { // Recorre la lista hasta llegar al último nodo
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo); // Añade el nuevo nodo al final
        }
    }


    public boolean eliminarNodo(int posicion) {

        if (primero == null || posicion < 0) {
            System.out.println("Lista vacía o posición inválida.");
            return false;
        }

        if (posicion == 0) {
            primero = primero.getSiguiente();
            return true;
        }

        Nodo temp = primero;

        for (int i = 0; temp != null && i < posicion - 1; i++) {
            temp = temp.getSiguiente();
        }

        if (temp == null || temp.getSiguiente() == null) {
            System.out.println("Posición fuera de rango.");
            return false;
        }

        temp.setSiguiente(temp.getSiguiente().getSiguiente());
        return true;
    }



    public T buscar(T value) {
        Nodo temp = primero;

        while (temp != null) {
            if (temp.getDato() != null && temp.getDato().equals(value)) {
                return (T) temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    public User buscarPorDocumento(String documento) {
        // Verifica si el valor a buscar es nulo
        if (primero == null) {
            System.out.println("La lista está vacía");
            return null;
        }
        if (documento == null) {
            System.out.println("El documento no puede ser nulo.");
            return null;
        }
        Nodo<T> temp = primero;

        while (temp != null) {
            T dato = temp.getDato();
            // Verifica si el dato es una instancia de User
            if (dato instanceof User user) {
                if (documento.equals(user.getDocument())) {
                    return user; // Retorna el usuario encontrado
                }
            }
            temp = temp.getSiguiente();
        }
        System.out.println("No se encontró un usuario con el documento proporcionado.");
        return null; // Retorna null si no se encuentra el usuario
    }

    public City buscarCiudadPorCodigo(String code) {
        // Verifica si el valor a buscar es nulo
        if (primero == null) {
            System.out.println("La lista está vacía");
            return null;
        }
        if (code == null) {
            System.out.println("El código no puede ser nulo.");
            return null;
        }
        Nodo<T> temp = primero;

        while (temp != null) {
            T dato = temp.getDato();
            // Verifica si el dato es una instancia de User
            if (dato instanceof City city) {
                if (code.equals(city.getCode())) {
                    return city; // Retorna el usuario encontrado
                }
            }
            temp = temp.getSiguiente();
        }
        System.out.println("No se encontró una ciudad con el código proporcionado.");
        return null; // Retorna null si no se encuentra el usuario
    }

    public void imprimirGenerico(Consumer<T> imprimir) {
        Nodo<T> temp = primero;
        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (temp != null) {
            imprimir.accept(temp.getDato()); // Utiliza la función pasada como parámetro para imprimir
            temp = temp.getSiguiente();
        }
    }

    public void listCities() {
        Nodo<T> temp = primero;
        if (temp == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        while (temp != null) {
            T dato = temp.getDato();
            if (dato instanceof City city) {
                System.out.println(city.getDescription() + " (" + city.getCode() + ")");
            } else {
                System.out.println(dato); // En caso de que el dato no sea del tipo City
            }
            temp = temp.getSiguiente();
        }
    }
}
