/*1. Implement own ArrayList using arrays
Coding
Accepted
You need to implement your own ArrayList but not using the class ArrayList. You need to implement the add, get, remove, size methods which have the functionalities mentioned above.

Input: The input should be in the following format:
The first line should be the value of the index from where you need to get the value and remove that element in the sequence mentioned in the problem statement.
The second line should be elements of ArrayList space separated.
Output: The output should be in the following format:
The first line should be initial elements of the ArrayList in the given order.
The second line should be the value at the given index.
The third line should be the size of ArrayList.
The fourth line should be the elements of ArrayList in the given order after removing the element at the given index.

Example:
Input:
7
1 3 2 4 4 5 6 7 8 9 10 11 13 12
Output:
1 3 2 4 4 5 6 7 8 9 10 11 13 12 
7
14
1 3 2 4 4 5 6 8 9 10 11 13 12


Execution time limit
15 seconds ` */





import java.util.*;

public class cp {
    private int[] elements;
    private int size;

    // Constructor to initialize the array with default capacity
    public cp() {
        elements = new int[10]; // Initial capacity
        size = 0;
    }

    // Add an element to the list
    public void add(int value) {
        ensureCapacity();
        elements[size++] = value;
    }

    // Get the element at a specific index
    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    // Remove the element at a specific index
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    // Get the current size of the list
    public int size() {
        return size;
    }

    // Print the elements of the list
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    // Ensure the array has enough capacity to add more elements
    private void ensureCapacity() {
        if (size == elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    // Check if the given index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int givenIndex = s.nextInt();
        Source ownArrayList = new Source();

        // Read elements from input
        while (s.hasNextInt()) {
            ownArrayList.add(s.nextInt());
        }
        s.close();

        // Print initial elements
        ownArrayList.print();

        // Print element at given index
        System.out.println(ownArrayList.get(givenIndex));

        // Print size of the list
        System.out.println(ownArrayList.size());

        // Remove the element at the given index
        ownArrayList.remove(givenIndex);

        // Print elements after removal
        ownArrayList.print();
    }
}
