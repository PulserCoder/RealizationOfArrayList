package org.example;

public class ArrayListByPavel implements StringList{
    private String[] array;
    private final int size;

    public ArrayListByPavel() {
        this.array = new String[256];
        this.size = 0;
    }


    @Override
    public String add(String item) {
        return "";
    }

    @Override
    public String add(int index, String item) {
        return "";
    }

    @Override
    public String set(int index, String item) {
        return "";
    }

    @Override
    public String remove(String item) {
        return "";
    }

    @Override
    public String remove(int index) {
        return "";
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
