package co.edu.tdea.edd.estructure.stack;


import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.estructure.linkedList.singly.Nodo;

import java.util.EmptyStackException;

public class Stack<T> {
    private List<T> list = new List<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.getPrimero() == null) {
            throw new EmptyStackException();
        }

        if (list.getPrimero().getNext() == null) {
            T item = list.getPrimero().getData();
            list.setPrimero(null);
            return item;
        }

        Nodo<T> current = list.getPrimero();
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        T item = current.getNext().getData();
        current.setNext(null);
        return item;
    }

    public boolean isEmpty() {
        return list.getPrimero() == null;
    }
}
