package Java.OOPS.customDataStructures.arrrayList;

public class CustomArrayList {
    //IMPLEMENTATION BELOW

    private int[] data;
    private final int DEFAULT_SIZE = 10;
    private static int size = 0;

    CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int value) {
        if (size == DEFAULT_SIZE) {
            //create a new array of double size
            int[] temp = new int[size * 2];
            //copy all the items from prev array into new array
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            //reassign data to temp
            data = temp;
        }
        data[size++] = value;
    }

    public int get(int index) {
        return data[index];
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public void erase() {
        int[] temp = new int[DEFAULT_SIZE];
        size = 0;
        data = temp;
    }

    @Override
    public String toString() {
        //if data is empty return empty string
        if (isEmpty()) {
            return "";
        }
        String s = "[";
        for (int i = 0; i < size; i++) {
            int num = data[i];
            if (num < 10) {
                s += num;
            } else {
                String s1 = "";
                while (num != 0) {
                    s1 = (num % 10) + s1;
                    num /= 10;
                }
                s += s1;
            }
            if (i == size - 1) {
                s += "]";
            } else {
                s += ",";
            }
        }
        return s;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
