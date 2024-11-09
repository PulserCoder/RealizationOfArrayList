package org.example;

import org.example.exceptions.IndexOutOfRangeExceprion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    ArrayListByPavel arrayListByPavel = new ArrayListByPavel();

    @BeforeEach
    public void data() {
        arrayListByPavel.add("A");
        arrayListByPavel.add("B");
        arrayListByPavel.add("C");
    }

    @Test
    public void add() {
        assertEquals("D", arrayListByPavel.add("D"));
        assertEquals(4, arrayListByPavel.size());
        assertEquals("D", arrayListByPavel.get(3));
    }

    @Test
    public void size() {
        assertEquals(3, arrayListByPavel.size());
    }

    @Test
    public void get() {
        assertEquals("A", arrayListByPavel.get(0));
        assertEquals("B", arrayListByPavel.get(1));
        assertEquals("C", arrayListByPavel.get(2));
    }

    @Test
    public void remove() {
        assertEquals("C", arrayListByPavel.remove("C"));
        assertEquals(2, arrayListByPavel.size());
        assertEquals("B", arrayListByPavel.get(1));
        assertThrows(IndexOutOfRangeExceprion.class, () -> arrayListByPavel.remove(-1));
        assertThrows(IndexOutOfRangeExceprion.class, () -> arrayListByPavel.remove(2));
    }

    @Test
    public void checkIndex() {
        assertThrows(IndexOutOfRangeExceprion.class, () -> arrayListByPavel.checkIndex(-1));
        assertThrows(IndexOutOfRangeExceprion.class, () -> arrayListByPavel.checkIndex(10));
    }

    @Test
    public void addWithIndex() {
        assertEquals("X", arrayListByPavel.add(2, "X"));
        assertEquals(4, arrayListByPavel.size());
        assertEquals("X", arrayListByPavel.get(2));
        assertEquals("C", arrayListByPavel.get(3));
    }

    @Test
    public void set() {
        assertEquals("X", arrayListByPavel.set(0, "X"));
        assertEquals(3, arrayListByPavel.size());
        assertEquals("X", arrayListByPavel.get(0));
    }

    @Test
    public void removeWithIndex() {
        assertEquals("B", arrayListByPavel.remove(1));
        assertEquals(2, arrayListByPavel.size());
        assertThrows(IndexOutOfRangeExceprion.class, () -> arrayListByPavel.remove(2));
        assertEquals("C", arrayListByPavel.get(1));
    }

    @Test
    public void contains() {
        assertTrue(arrayListByPavel.contains("A"));
        assertFalse(arrayListByPavel.contains("D"));
    }

    @Test
    public void indexOf() {
        arrayListByPavel.add("A");
        assertEquals(0, arrayListByPavel.indexOf("A"));
    }

    @Test
    public void lastIndexOf() {
        arrayListByPavel.add("A");
        assertEquals(3, arrayListByPavel.lastIndexOf("A"));
    }

    @Test
    public void isEmpty() {
        assertFalse(arrayListByPavel.isEmpty());
        arrayListByPavel.clear();
        assertTrue(arrayListByPavel.isEmpty());
    }

    @Test
    public void clear() {
        arrayListByPavel.clear();
        assertTrue(arrayListByPavel.isEmpty());
        assertEquals(0, arrayListByPavel.size());
    }
}