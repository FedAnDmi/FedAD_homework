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
    /**
    *Добавляет новый элемент в список. При достижении размера внутреннего
    *массива происходит его увеличение на 1.
    */
    public void add(T item) {
        if(pointer == array.length)
            resize(array.length+1); // увеличивает на 1, если достигнуты границы
        array[pointer++] = item; // увеличение счётчика и присвоение элемента
    }

    /**
     *Добавляет новый элемент в список по индексу. При достижении размера внутреннего
     *массива происходит его увеличение.
     */
    public void add(T item, int index) {
        if (index > pointer)
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
        if(pointer == array.length)
            resize(array.length+1); // увеличивает на 1, если достигнуты границы
        System.arraycopy(array, index, array, index + 1, pointer - index);
        /*
         *сдвиг части массива для
         */
        array[index] = item;
        pointer++;
    }
    /**
    Возвращает элемент списка по индексу.
    */
    public T get(int index) {
        if (index < 0 || index >= pointer) // Проверка на корректность индекса
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
        return (T) array[index];
    }
    /**
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в cut_size раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        if (index < 0 || index >= pointer) // Проверка на корректность индекса
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
        for (int i = index; i<pointer-1; i++)
            array[i] = array[i+1];// Сдвиг элементов справа от удалённого
        array[index] = null; // обнуление последнего элемента
        pointer--;
        // если элементов в cut_size раз меньше чем, длина массива, то уменьшает размер в два раза
        if (array.length > init_size && pointer < array.length / cut_size)
            resize(array.length/2);
    }
    /**
     * Метод для очистки массива
     */
    public void clear() {
        Arrays.fill(array, 0, pointer, null); // Очищаем массив
        pointer = 0; // Сбрасываем указатель
    }
    /**
     * Возвращает количество элементов в списке
     */
    public int size_e() {
        return pointer;
    }
    /**
     * Возвращает размерность массива
     */
    public int size() {
        return array.length;
    }
    /**
     * Вспомогательный метод для масштабирования.
     */
    private void resize(int newSize) {
        Object[] newArray = new Object[newSize]; //создания массива с новой размерностью
        System.arraycopy(array, 0, newArray, 0, pointer);
        /*
         * копирование содержимого старого массива в новый
         */
        array = newArray; // замена старого массива новым.
    }

    /**
     * Метод для сортировки, использующий быстрый алгоритм сортировки Quicksort.
     * Метод принимает поле объекта по которому будет проводиться сортировка
     * а затем обращается к вспомогательному методу
     */
    public void sort(Comparator<? super T> comparator) {
        sort(0, pointer - 1, comparator);
    }
    /**
     * Вспомогательный метод для выполнения QuickSort
     */
    private void sort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator); //Обращается к методу для получения опорного
            sort(low, pivotIndex - 1, comparator); //рекурсия для сортировки "левой" части массива
            sort(pivotIndex + 1, high, comparator); //рекурсия для сортировки "правой"
        }
    }
    /**
    * Метод для разделения массива и выбора опорного элемента
    */
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = get(high); // Выбор последнего элемента как опорного
        int i = (low - 1);
        /* переменная для отслеживания позиции, куда следует переместить
         * элементы, меньшие или равные опорному.
         */
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);// вызов метода для обмена, если элемент не больше опорного
            }
        }
        swap(i + 1, high);
        /* обмен опорного элемента с элементом, следующим за последним
         * элементом, меньшим или равным опорному.
         */
        return i + 1; // выдаёт новую позицию опорного элемента
    }
    /**
     *Метод для обмена элементов в массиве
     */
    private void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
