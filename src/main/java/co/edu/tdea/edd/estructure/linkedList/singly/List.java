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
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0; // Inicializamos size en 0
    }

    public void add(T data) {
        Nodo<T> newNodo = new Nodo<>(data);
        if (head == null) {
            head = newNodo;
            tail = newNodo;
        } else {
            tail.setNext(newNodo);
            tail = newNodo;
        }
        size++; // Incrementamos size en cada adición
    }

    public boolean remove(T data) {
        if (head == null) return false;

        if (head.getData().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--; // Decrementamos size cuando se elimina un elemento
            return true;
        }

        Nodo<T> current = head;
        Nodo<T> prev = null;

        while (current != null && !current.getData().equals(data)) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) return false;

        prev.setNext(current.getNext());

        if (prev.getNext() == null) {
            tail = prev;
        }

        size--; // Decrementamos size al eliminar el nodo
        return true;
    }

    public T search(T data) {
        Nodo<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printList() {
        Nodo<T> current = head;
        if (current == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public Nodo<T> getHead() {
        return head;
    }

    public int getSize() {
        return size; // Retorna el tamaño de la lista
    }

    public boolean isEmpty() {
        return size == 0; // Verifica si la lista está vacía
    }

    public void forEach(Consumer<T> action) {
        Nodo<T> current = head;
        while (current != null) {
            action.accept(current.getData());
            current = current.getNext();
        }
    }
}