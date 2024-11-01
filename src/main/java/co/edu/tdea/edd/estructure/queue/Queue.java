package co.edu.tdea.edd.estructure.queue;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.estructure.linkedList.singly.Nodo;

import java.util.Iterator;

// Cola
public class Queue<T> {
    private List<T> list = new List<>();

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        // Implementación simplificada, asumiendo que el primer elemento es la cabeza de la lista
        T item = list.search(list.getPrimero().getData());
        list.remove(item);
        return item;
    }

    public Nodo<T> getPrimero() {
        return list.getPrimero(); // Asegúrate de que tu clase List tenga este método
    }

    public boolean isEmpty() {
        return list.getPrimero() == null;
    }
}

