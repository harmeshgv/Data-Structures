public class arraylistUsingArray {
    public static void main(String args[]) {

    }
    
}

class ArrayList {

    private int[] elements;
    private int size;

    public void ArrayList() {
        elements = new int[10];
        size = 0;

    }

    public void add(int data) {
        ensureCapacity();
        elements[size++] = data;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < size; i++) {
            elements[i] = elements[i+1];
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        for(int i = 0 ; i < size ; i++) {
            System.out.println(elements[i] + " ");
        }
        System.out.println();
    }

    public void checkIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void ensureCapacity() {
        if(size == elements.length) {
            int[] newElements = new int[elements.length * 2];

            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}



