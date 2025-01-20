package javabase.class_loaders;

import static javabase.Homework.*;

public class MainClass {

    public static void main(String[] args) {
        Class<ClassLoaders> aClass = ClassLoaders.class;
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9}; // массив для удаления дубликатов
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47}; // массив для поиск второго максимума
        printClassLoaders();

        System.out.println("\n");
        turnString("I love Java"); //переворачивание строки
        getDistinctNumbers(ints); //удаление дубликатов
        System.out.println(findSecondMaxElement(arr)); //Поиск
        /*
         * Вычисление длинны последнего слова
         */
        System.out.println(lengthOfLastWord("Hello world"));
        System.out.println(lengthOfLastWord("    fly me    to the moon    "));
        /*
         * Определение Палиндрома
         */
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("112233"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("112211"));
    }

    private static void printClassLoaders() {

        ClassLoaders classLoaders = new ClassLoaders();

        classLoaders.printBootstrapClassLoaders();

        classLoaders.printPlatformClassLoaders();

        classLoaders.printApplicationClassLoaders();

        classLoaders.printReflectionExample();
    }
}
