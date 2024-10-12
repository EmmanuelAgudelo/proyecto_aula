/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.tdea.edd.estructure.linkedList.singly;

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
        Nodo nuevo = new Nodo(primero, value);
        if (primero == null) {
            primero = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
    }

    public void eliminarNodo(int posicion) {
        if (primero == null || posicion < 0) {
            System.out.println("Lista vacía o posición inválida.");
            return;
        }

        Nodo temp = primero;

        // Buscar el nodo en la posición especificada
        for (int i = 0; temp != null && i < posicion; i++) {
            temp = temp.getSiguiente();
        }

        /* if (temp == null) {
            System.out.println("Posición fuera de rango.");
            return;
        }

        if (temp.getSiguiente() != null) {
            ;
        }

        // Si no es el primer nodo, enlazar el anterior nodo con el siguiente
        if (temp != null) {
            temp.prev.next = temp.next;
        }
         */
    }

    public T buscar(T value) {
        Nodo actual = primero;

        while (actual != null) {
            if (actual.getDato().equals(value)) {
                return (T) actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

}
