package arraylist;

import java.util.Arrays;


public class MyArrayList<E> {
    private E[] data;
    private int curSize;

    MyArrayList() {
        this(10);
    }

    MyArrayList(int amount){
        this.data = (E[]) new Object[amount];
        this.curSize = 0;
    }

    public int size() {
        return  curSize;
    }

    public int add(E element) {
        if (curSize == this.data.length) {
            this.data = Arrays.copyOf(this.data, size() + (size() / 2) + 1);
        }
        this.data[curSize] = element;
        curSize++;
        return curSize - 1;
    }

    public void add(E elem, int index) {
        if (index > data.length) {
            resize(data.length * 2 + 1);
        }
        System.arraycopy(data, index, data, index + 1, curSize - 1 - index);

        data[index] = elem;
        curSize++;
    }

    public E get(int index) {
        return data[index];
    }

    public E remove(int index) {
        E removedElem = get(index);

        System.arraycopy(data, index + 1, data, index, curSize - 1 - index);
        curSize--;

        return removedElem;
    }

    private void resize(int newSize) {
        E[] old = data;
        data = (E[]) new Object[newSize];
        System.arraycopy(old, 0, data, 0, curSize);
    }
}