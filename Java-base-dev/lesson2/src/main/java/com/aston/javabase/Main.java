package com.aston.javabase;
import com.aston.javabase.class_structure.*;
import com.aston.javabase.MyArrayList;
import javax.naming.Name;
import java.util.*;
/**
 * Проверка основных методов MyArrayList
 * @author FedAnDmi
 *
 */
public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         MyArrayList array_test = new MyArrayList(); //создание массива MyArrayList
         System.out.print("Введите количество образцов собаки: ");
         int numberOfInstances = scanner.nextInt(); // Ввод количества образцов собак
         Dog[] instances = new Dog[numberOfInstances]; // создание отдельного массива собак для заполнения MyArrayList
         for (int i = 0; i < numberOfInstances; i++) {
              //Заполнения массива собак образцами с нумерованными именами и возрастами
              instances[i] = new Dog();
              instances[i].setName("Образец "+i); // задание собаке имени, соответсвующего её номеру в массиве
              instances[i].setAge(i); // задание возраста собаки, который выбирается номером элемента в массиве
         }
         for (int i = 0; i < numberOfInstances; i++) {
              /*
               * Заполнение MyArrayList собаками из массива собак
               * Для дальнейшей проверки сортировки, MyArrayList будет заполнен собаками в
               * "неправильном"(в данном случае обратном) порядке.
               */
              array_test.add(instances[numberOfInstances-1-i]);
              /*
               * добавление в список с самых старых собак(ибо возраст определяется номером собаки, а сортировка
               * будет проводиться по возрасту, т.к. по ней легче проверить работу)
               */
              System.out.println("Элемент "+i);
              System.out.println(array_test.get(i)); //Вывести номер элемента
              instances[numberOfInstances-1-i].printDogName(); //Вывести имя собаки
              System.out.println("Возраст:"+instances[numberOfInstances-1-i].getAge()+"\n"); //Вывести возраст собаки
         }
         System.out.println("Сортировка:\n");
         array_test.sort(Comparator.comparing(Dog::getAge)); //Сортировка по возрасту
         printMyArrayList(numberOfInstances, array_test); //Вызов метода вывода массива

         System.out.println("Тестирование добавления по индексу:\n");
         Dog dog1=new Dog();
         System.out.print("Введите индекс вставки : ");
         int arrayNumber = scanner.nextInt();  //Ввод индекса собаки для вставки
         array_test.add(dog1,arrayNumber); //Добавление собаки в список
         printMyArrayList(numberOfInstances+1, array_test);
         array_test.remove(arrayNumber); //удаление элемента из массива
         System.out.println("\nТестирование удаления по индексу:\n");
         printMyArrayList(numberOfInstances, array_test);
         System.out.println("\nТестирование очистки:\n");
         array_test.clear();// очистка массива
         /*
          * Проверка очистки массива. Если среди элементов найдётся непустой, выведет
          * сообщение, что массив не очищен. Если не найдётся, после проверки последнего элемента
          * выдаст сообщение, что массив был очищен
          */
         for (int i = 0; i < array_test.size_e(); i++) {
              if(array_test.get(i)!=null){
                   System.out.println("Массив не очищен");
                   break; //выход из цикла
              } else if (i==array_test.size_e()-2) {
                   System.out.println("Массив очищен");
              }
         }
         System.out.println("\nЗавершено"); //Вывод записи о конце алгоритма
    }
     /**
      * Метод для вывода на экран элементов класса MyArrayList
      */
     private static void printMyArrayList(int number, MyArrayList array_test){
          for (int i = 0; i < number; i++) {
               System.out.println("Элемент "+i); //Вывод номера элемента
               System.out.println(array_test.get(i)); // вывод элемента массива MyArrayList
          }
     }
}
