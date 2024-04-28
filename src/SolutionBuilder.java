import java.util.Arrays;
import java.util.Comparator;

public class SolutionBuilder {

    //    Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//    найденные строки и их длину.
    public static void buildTask1() {
        String[] arr = LineMethod.getArrayLine(3);

        int minLengthIndex = 0;
        int maxLengthIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < arr[minLengthIndex].length()) {
                minLengthIndex = i;
            }

            if (arr[i].length() > arr[maxLengthIndex].length()) {
                maxLengthIndex = i;
            }
        }

        System.out.println("Строка MIN длины:");
        System.out.println(arr[minLengthIndex] + " -> " + arr[minLengthIndex].length() + " символа");
        System.out.println("Строка MAX длины:");
        System.out.println(arr[maxLengthIndex] + " -> " + arr[maxLengthIndex].length() + " символа");

        System.out.println("\n");
    }

    //    Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
//    значений их длины
    public static void buildTask2() {
        String[] arr = LineMethod.getArrayLine(3);

        Comparator<String> ageComparator = new Comparator<String>() {
            @Override
            public int compare(String line1, String line2) {
                return Integer.compare(line1.length(), line2.length());
            }
        };
        Arrays.sort(arr, ageComparator);

        System.out.println("\nСтроки в порядке возрастания длины:");
        for (String el : arr) {
            System.out.println(el);
        }

        System.out.println("\n");
    }

    //    Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//    средней, а также их длину
    public static void buildTask3() {
        String[] arr = LineMethod.getArrayLine(3);
        int limit = arr[arr.length / 2].length();

        System.out.println("Количестов символов в среденей строке -> " + limit);
        System.out.println("Строки длина которых меньше средней:");

        for (String line : arr) {
            if (line.length() < limit) {
                System.out.println(line + " -> " + line.length() + " символа");
            }
        }

        System.out.println("\n");
    }

    //    Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//    Если таких слов несколько, найти первое из них.
    public static void buildTask4() {
        String[] arr = LineMethod.getArrayLine(3);
        String[] wordsArray = LineMethod.splitStringIntoWords(arr);

        boolean flag = false;
        for (String word : wordsArray) {
            if (LineMethod.isUniqueCharactersVar2(word)) {
                flag = true;
                System.out.println("Первое слово где все ситмволы уникальны -> " + word);
                break;
            }
        }
        if (!flag) {
            System.out.println("Нет слов где все символы уникальны...");
        }

        System.out.println("\n");
    }

    //    Вывести на консоль новую строку, которой задублирована каждая буква из
//    начальной строки. Например, "Hello" -> "HHeelllloo"
    public static void buildTask5() {
        String[] arr = LineMethod.getArrayLine(1);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr[0].length(); i++) {
            builder.append(arr[0].charAt(i));
            builder.append(arr[0].charAt(i));
        }

        System.out.println("Первоночальная строка:");
        System.out.println(arr[0]);
        System.out.println("Новая строка:");
        System.out.println(builder.toString());
        System.out.println("\n");
    }

    //    Дана строка произвольной длины с произвольными словами. Написать программу для
//    проверки является ли любое выбранное слово в строке палиндромом.
//
//    Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е
//    слово в этой строке палиндромом.
//    Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например,
//    в строке 5 слов, а на вход программе передали число 500.
    public static void buildTaskStar() {
        String[] arr = LineMethod.getArrayLine(1);
        String[] wordsArray = LineMethod.splitStringIntoWords(arr);

        int index = LineMethod.getIndex(wordsArray.length);
        if (index != -1) {
            System.out.println((index + 1) + " слово: " + wordsArray[index] + " -> " +
                    ((LineMethod.isPalindrome(wordsArray[index])) ? "является полиндромом" : "не полиндром"));
        } else {
            System.out.println("Не возможно определить слово для проверки...");
        }

        System.out.println("\n");
    }
}
