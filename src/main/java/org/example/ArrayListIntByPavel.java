package org.example;

import org.example.exceptions.IndexOutOfRangeExceprion;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListIntByPavel implements IntList {
    private Integer[] array;
    private int size;
    private final int factSize = 256;

    public ArrayListIntByPavel() {
        this.array = new Integer[factSize];
        this.size = 0;
    }


    @Override
    public void add(Integer item) {
        if (size == factSize) {
            grow();
        }
        array[size] = item;
        size++;
    }

    void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfRangeExceprion("Index should be between 0 and " + (size - 1));
        }
    }


    @Override
    public void add(int index, Integer item) {
        checkIndex(index);
        if (size == factSize) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, Integer item) {
        checkIndex(index);
        array[index] = item;
    }


    @Override
    public void remove(Integer index) {
        checkIndex(index);
        Integer el = array[index];
        for (int j = index; j < size; j++) {
            array[j] = array[j + 1];
        }
        size--;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        return binarySearch(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (this.array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i > -1; i--) {
            if (this.array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(Integer index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Integer[factSize];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public void sort() {
        quickSort(0, size - 1);
    }

    @Override
    public int binarySearch(Integer element) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (element.equals(array[mid])) {
                return mid;
            }
            if (array[mid] > element) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    public void quickSort(int begin, int end) {
        if (begin < end) {
            int pivot = sortByPivot(begin, end);
            quickSort(begin, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    public int sortByPivot(int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i += 1;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = temp;
        return i + 1;

    }

    private void grow() {
        Integer[] newarr = new Integer[(int) (factSize * 1.5)];
        System.arraycopy(array, 0, newarr, 0, size);
        this.array = newarr;
    }

}
