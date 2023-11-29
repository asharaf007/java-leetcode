package Java.OOPS.customDataStructures.arrrayList;

import java.util.Arrays;

//for comparisons use interface comparable
public class CustomGenericArrayList<T> implements Comparable<CustomGenericArrayList<T>> {
    //IMPLEMENTATION BELOW

    private Object[] data;
    private static int DEFAULT_SIZE = 10;


    private int size = 0;

    CustomGenericArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (size == DEFAULT_SIZE) {
            //create a new array of double size
            Object[] temp = new Object[size * 2];
            //copy all the items from prev array into new array
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            //reassign data to temp
            data = temp;
        }
        data[size++] = value;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public void erase() {
        Object[] temp = new Object[DEFAULT_SIZE];
        size = 0;
        data = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return Arrays.toString(data);
    }


    @Override
    public int compareTo(CustomGenericArrayList<T> o) {
        return (int) (this.size() - o.size());
    }
}