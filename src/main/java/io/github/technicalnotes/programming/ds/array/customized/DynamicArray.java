package io.github.technicalnotes.programming.ds.array.customized;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A dynamic array is an array where upon insertion if the array is found full
 * we initialize a new array of a larger size and copy all the elements of the old array into it
 * and then push the latest element into it
 * <p>
 * * Amortized complexity: O(n)
 */
public class DynamicArray<T> implements Iterable<T> {
    private Object[] arr;
    private double factor;
    private int currentIndex = -1;

    public DynamicArray() {
        arr = new Object[10];
        factor = 2.0;
    }

    public DynamicArray(int initialLength) {
        this.factor = factor;
    }

    public DynamicArray(int initialLength, double factor) {
        this.arr = new Object[initialLength];
        this.factor = factor;
    }

    public void insert(T in) {
        if (currentIndex + 1 >= arr.length) {
            // increase the size of array
            Object[] newArr = new Object[(int) (factor * arr.length)];
            for (int i = 0; i <= currentIndex; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[++currentIndex] = in;
    }

    public T removeAtIndex(int index) {
        if (index > currentIndex) {
            throw new RuntimeException("No value at index i");
        }
        T returnValue = (T) arr[index];
        for (int i = index; i < currentIndex; i++) {
            arr[i] = arr[i + 1];
        }
        arr[currentIndex--] = null;
        return returnValue;
    }

    public T removeFirst() {
        return removeAtIndex(0);
    }

    public T removeLast() {
        return removeAtIndex(currentIndex);
    }

    public T remove() {
        return removeLast();
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public int size() {
        return currentIndex + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public boolean equals(Object obj) {
        DynamicArray<T> to = (DynamicArray<T>) obj;
        if (to.size() == size()) {
            for (int i = 0; i < size(); i++) {
                arr[i].equals(to.get(i));
            }
            return true;
        }
        return false;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size();
            }

            @Override
            public T next() {
                return (T) arr[current++];
            }
        };
    }
}
