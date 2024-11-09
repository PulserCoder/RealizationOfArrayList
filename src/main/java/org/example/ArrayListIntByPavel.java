package org.example;

import org.example.exceptions.IndexOutOfRangeExceprion;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListIntByPavel implements IntList{
    private Integer[] array;
    private int size;
    private final int factSize = 256;

    public ArrayListIntByPavel() {
        this.array = new Integer[factSize];
        this.size = 0;
    }


    @Override
    public void add(Integer item) {
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
        for (int i = size; i > index; i--){
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
        for (int i = 0; i < size; i++){
            if (this.array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i > -1; i--){
            if (this.array[i].equals(item)){
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
        for (int i = 0; i < size; i++){
            if (!this.array[i].equals(otherList.get(i))){
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
        Arrays.sort(array, 0, size);
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
}
