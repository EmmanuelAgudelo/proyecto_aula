package co.edu.tdea.edd.estructure.linkedList.singly;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

/**
 *
 * @param <T> El tipo de datos que almacenará la lista
 */
@Getter
@Setter
public class List<T> {
    private Nodo<T> primero;

    public List() {
        this.primero = null;
    }

    public void add(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
    }

    public boolean remove(T data) {
        if (primero == null) {
            return false; // La lista está vacía, no se puede eliminar nada
        }

        // Caso especial: eliminar el nodo cabeza
        if (primero.getData().equals(data)) {
            primero = primero.getNext(); // Mover la cabeza al siguiente nodo
            return true; // Se eliminó el nodo
        }

        // Buscar el nodo anterior al que queremos eliminar
        Nodo<T> current = primero;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext()); // Saltar el nodo que queremos eliminar
                return true; // Se eliminó el nodo
            }
            current = current.getNext();
        }

        return false; // No se encontró el dato
    }

    public T search(T data) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getData().equals(data)) {
                return actual.getData();
            }
            actual = actual.getNext();
        }
        return null;
    }

    public void printList() {
        Nodo<T> actual = primero;
        if (actual == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (actual != null) {
            System.out.println(actual.getData().toString());
            actual = actual.getNext();
        }
    }


    public Nodo<T> getPrimero() {
        return primero;
    }

    public void forEach(Consumer<T> action) {
        Nodo<T> actual = primero;
        while (actual != null) {
            action.accept(actual.getData());
            actual = actual.getNext();
        }
    }
}