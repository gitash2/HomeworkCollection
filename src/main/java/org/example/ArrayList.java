package org.example;

import java.util.*;

public class ArrayList<T> implements Cloneable  {
    private static final int INITIAL_SIZE = 10;

    private static final Object[] EMPTY_ARRAY = {};

    private int size;

    private Object[] data;


    public ArrayList() {
        this.data = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int size) {
        if (size > 0) {
            this.data = new Object[size];
            this.size = size;
        } else if (size == 0) {
            this.data = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Size < 0: " + size);
        }


    }

    public ArrayList(List<?> anotherCollection) {
        this.data = anotherCollection.toArray();
        size = anotherCollection.size();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new InternalError(exception);
        }
    }

    public void add(T element) {
        ensureCapacity();
        data[size++] = element;
    }

    public void ensureCapacity() {
        if (data.length == 0) {
            data = new Object[INITIAL_SIZE];
        } else if (size == data.length) {
            data = increaseSize();
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length * 2 );
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Illegal index: " + index);
        } else {
            return (T)data[index];
        }
    }

    public void set(int index, Object element) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Illegal index: " + index);
        } else {
            data[index] = element;
        }
    }

    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (index < size && index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            data[--size]  = null;
            return true;
        } else {
            return false;
        }
    }

    public void addAll(Collection<T> collection) {
        ensureCapacity(size + collection.size());
        for (T element : collection) {
            data[size++] = element;
        }
    }

    private Object[] increaseSize() {
        return Arrays.copyOf(data, data.length * 2);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder endString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            endString.append(i).append(": ").append(data[i]).append('\n');
        }
        endString.append(System.lineSeparator());
        return endString.toString();
    }


    public boolean equals(List<T> list) {
        Boolean res = true;
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] != list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
