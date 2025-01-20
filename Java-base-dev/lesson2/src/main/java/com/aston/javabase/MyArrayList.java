package com.aston.javabase;
import java.util.*;
/**
 * Класс массива MyArrayList
 * @author FedAnDmi
 */
public class MyArrayList <T> {
    private final int init_size = 16;//начальный размер массива
    private final int cut_size = 4;//размер обрезки массива для экономии места
    private Object[] array = new Object[init_size];
    private int pointer = 0;//счётчик элементов
    /*
    *Добавляет новый элемент в список. При достижении размера внутреннего
    *массива происходит его увеличение на 1.
    */
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length+1); // увеличивает на 1, если достигнуты границы
        array[pointer++] = item;
    }

    /*
     *Добавляет новый элемент в список по индексу. При достижении размера внутреннего
     *массива происходит его увеличение в два раза кратно .
     */
    public void add(T item, int index) {
        if(index > array.length-1)
            resize(index+1); // увеличивает размер до индекса, если индекс больше границ
        pointer+=pointer;
        array[index] = item;
    }
    /*
    Возвращает элемент списка по индексу.
    */
    public T get(int index) {
        return (T) array[index];
    }
    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в cut_size раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[index] = null;
        pointer--;
        // если элементов в cut_size раз меньше чем, длина массива, то уменьшает размер в два раза
        if (array.length > init_size && pointer < array.length / cut_size)
            resize(array.length/2);
    }
    public void clear() {
        Arrays.fill(array, 0, pointer, null); // Очищаем массив
        pointer = 0; // Сбрасываем указатель
    }
    /*Возвращает количество элементов в списке*/
    public int size_e() {
        return pointer;
    }

    /*Возвращает размер массива*/
    public int size() {
        return array.length;
    }

    //Вспомогательный метод для масштабирования.
    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }


    public void sort(Comparator<? super T> comparator) {
        sort(0, pointer - 1, comparator);
    }
    // Вспомогательный метод для выполнения QuickSort
    private void sort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            sort(low, pivotIndex - 1, comparator);
            sort(pivotIndex + 1, high, comparator);
        }
    }


    // Метод для разделения массива и выбора опорного элемента
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // Метод для обмена элементов в массиве
    private void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
