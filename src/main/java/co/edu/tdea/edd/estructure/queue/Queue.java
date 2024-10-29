package co.edu.tdea.edd.estructure.queue;

import co.edu.tdea.edd.estructure.linkedList.singly.List;

// Cola
public class Queue<T> {
    private List<T> list = new List<>();

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        // Implementación simplificada, asumiendo que el primer elemento es la cabeza de la lista
        T item = list.search(list.getHead().getData());
        list.remove(item);
        return item;
    }

    public boolean isEmpty() {
        return list.getHead() == null;
    }
}

