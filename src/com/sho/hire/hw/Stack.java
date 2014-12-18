package com.sho.hire.hw;

import java.util.EmptyStackException;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 12/18/14
 * Time: 12:29 AM
 * #TODO
 */
public class Stack {
    private Object[] elements;
    private int size = 0;

    public Stack(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object pop = elements[--size];
        elements[size] = null; //solution to memory leak issue
        return pop;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    public static void main(String[] args){
        Stack s = new Stack(0);
        int base = 100;
        for(int i = 0; i < base; i++){
            s.push(new byte[1000]);
        }
        for(int i = 0; i < base; i++){
            s.pop();
        }
    }
}
