package javabase;

import java.util.HashSet;
import java.util.Set;

public class Homework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        StringBuilder reversString = new StringBuilder(string); // переменная для перевёрнутой строки
        reversString.reverse(); // внутренний метод StringBuiler'а, который возвращает перевернутую строку
        System.out.println(reversString.toString());
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        Set<Integer> distinctNumbers = new HashSet<>();// Сет для хранения уникальных значений массива
        for (int num : ints) {
            distinctNumbers.add(num);// Вводим значения из массива, дубликаты не попадают
        }
        System.out.println(distinctNumbers);
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int max=0;
        int secondMax=0;
        for (int num : arr) {
            if (max == 0 || num > max) {
                secondMax = max; // Обновляем второй максимум
                max = num;       // Обновляем максимум
            } else if (num != max && (secondMax == 0 || num > secondMax)) {
                secondMax = num; // Обновляем второй максимум, если текущий элемент меньше максимума
            }
        }
        return secondMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        string = string.trim(); // Удаляем пробелы в начале и конце строки
        int lengthLastWord = 0;
        for (int i = string.length() - 1; i >= 0; i--) { // Перебираем строку с конца
            if (string.charAt(i) == ' ' && lengthLastWord > 0) { // Если мы встретили пробел и длина последнего слова больше 0, значит, мы дошли до конца последнего слова

                break;
            }
            // Увеличиваем счетчик длины последнего слова
            lengthLastWord++;
        }
        return lengthLastWord;
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false; // символы не совпадают
            }
            left++;
            right--;
        }
        return true; // строка является палиндромом
    }
}