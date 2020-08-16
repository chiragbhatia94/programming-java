package io.github.technicalnotes.programming.ds.array.customized;

import io.github.technicalnotes.BaseTest;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest extends BaseTest {

    @RepeatedTest(10)
    void insert() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        final int SIZE = new Random().nextInt(491) + 11;
        for(int i = 0; i < SIZE; i++) {
            dynamicArray.insert(i);
        }
        System.out.print(dynamicArray.size());
        assertEquals(String.valueOf(SIZE), outContent.toString());
        System.out.println();
    }

    @RepeatedTest(10)
    void removeAtIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        final int SIZE = new Random().nextInt(491) + 11;
        for(int i = 0; i < SIZE; i++) {
            dynamicArray.insert(i);
        }

        for (int i = 0; i < 5; i++) {
            dynamicArray.removeAtIndex(5);
        }

        assertEquals(SIZE - 5, dynamicArray.size());
    }

    @Test
    void removeFirst() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        final int SIZE = 5;
        for(int i = 0; i < SIZE; i++) {
            dynamicArray.insert(i);
        }

        for (int i = 0; i < 2; i++) {
            dynamicArray.removeFirst();
        }

        DynamicArray<Integer> expectedArray = new DynamicArray<>();
        for (int i = 0; i < 3; i++) {
            expectedArray.insert(i + 2);
        }

        assertEquals(dynamicArray, expectedArray);
    }

    @Test
    void removeLast() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        final int SIZE = 5;
        for(int i = 0; i < SIZE; i++) {
            dynamicArray.insert(i);
        }

        for (int i = 0; i < 2; i++) {
            dynamicArray.removeLast();
        }

        DynamicArray<Integer> expectedArray = new DynamicArray<>();
        for (int i = 0; i < 3; i++) {
            expectedArray.insert(i + 2);
        }

        assertEquals(dynamicArray, expectedArray);
    }
}