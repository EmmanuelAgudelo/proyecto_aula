package co.edu.tdea.edd.estructure.stack;


import co.edu.tdea.edd.estructure.linkedList.singly.List;

import java.util.EmptyStackException;

public class Stack<T> {
    private List<T> list = new List<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.getHead() == null) {
            throw new EmptyStackException(); // O manejar el caso de lista vacía
        }
        T item = list.getTail().getData(); // Obtener el último elemento
        list.remove(item); // Eliminar el último elemento de la lista
        return item; // Retornar el elemento eliminado
    }

    public boolean isEmpty() {
        return list.getHead() == null;
    }
}
