package org.example;

import org.example.exceptions.IndexOutOfRangeExceprion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListIntByPavelTest {
    private ArrayListIntByPavel list;

    @BeforeEach
    public void setUp() {
        list = new ArrayListIntByPavel();
        list.add(10);
        list.add(20);
        list.add(30);
    }

    @Test
    public void testAdd() {
        list.add(40);
        assertEquals(4, list.size());
        assertEquals(40, list.get(3));
    }

    @Test
    public void testAddWithIndex() {
        list.add(1, 15);
        assertEquals(4, list.size());
        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    public void testSet() {
        list.set(1, 25);
        assertEquals(25, list.get(1));
    }

    @Test
    public void testRemove() {
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
        assertThrows(IndexOutOfRangeExceprion.class, () -> list.get(2));
    }

    @Test
    public void testContains() {
        assertTrue(list.contains(20));
        assertFalse(list.contains(50));
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, list.indexOf(20));
        assertEquals(-1, list.indexOf(50));
    }

    @Test
    public void testLastIndexOf() {
        list.add(20);
        assertEquals(3, list.lastIndexOf(20));
    }

    @Test
    public void testGet() {
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
        assertThrows(IndexOutOfRangeExceprion.class, () -> list.get(3));
    }

    @Test
    public void testEquals() {
        ArrayListIntByPavel otherList = new ArrayListIntByPavel();
        otherList.add(10);
        otherList.add(20);
        otherList.add(30);
        assertTrue(list.equals(otherList));

        otherList.add(40);
        assertFalse(list.equals(otherList));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        Integer[] expected = {10, 20, 30};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testSort() {
        list.add(5);
        list.add(25);
        list.sort();
        Integer[] expected = {5, 10, 20, 25, 30};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testBinarySearch() {
        list.sort();
        assertEquals(0, list.binarySearch(10));
        assertEquals(2, list.binarySearch(30));
        assertEquals(-1, list.binarySearch(50));
    }

    @Test
    public void testCheckIndex() {
        assertThrows(IndexOutOfRangeExceprion.class, () -> list.get(-1));
        assertThrows(IndexOutOfRangeExceprion.class, () -> list.get(10));
    }
}
