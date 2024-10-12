package co.edu.tdea.edd.estructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T dato) {
        stack.add(dato);
    }

    public T pop() {
        int i = stack.size() - 1;
        T v = stack.get(i);
        stack.remove(i);
        return v;
    }

}
