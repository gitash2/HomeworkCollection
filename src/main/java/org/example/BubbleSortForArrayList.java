package org.example;


public class BubbleSortForArrayList<T> {
    public void bubbleSortWithFlag(ArrayList<T> data) {
        int size = data.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (compare(data.get(i), data.get(i + 1)) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private int compare(Object element1, Object element2) {
        if (element1 instanceof Comparable && element2 instanceof Comparable) {
            return ((Comparable<T>) element1).compareTo((T) element2);
        } else {
            throw new IllegalArgumentException("Elements must implement Comparable");
        }
    }

    private void swap(ArrayList<T> data, int i, int j) {
        Object temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j, temp);
    }


}
