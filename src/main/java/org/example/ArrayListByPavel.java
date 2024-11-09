package org.example;

import org.example.exceptions.IndexOutOfRangeExceprion;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayListByPavel implements StringList{
    private String[] array;
    private int size;
    private final int factSize = 256;

    public ArrayListByPavel() {
        this.array = new String[factSize];
        this.size = 0;
    }


    @Override
    public String add(String item) {
        array[size] = item;
        size++;
        return item;
    }

    void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfRangeExceprion("Index should be between 0 and " + (size - 1));
        }
    }


    @Override
    public String add(int index, String item) {
        checkIndex(index);
        for (int i = size; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return item;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String el = array[index];
        for (int j = index; j < size; j++) {
            array[j] = array[j + 1];
        }
        size--;
        return el;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++){
            if (this.array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i > -1; i--){
            if (this.array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        array = new String[factSize];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
