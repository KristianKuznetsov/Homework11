
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LineMethod {
    public static String[] getArrayLine(int size) {
        System.out.println("Введите " + size + " строк:");
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLine();
        }

        return array;
    }

    public static String[] splitStringIntoWords(String[] lineArray) {
        ArrayList<String> list = new ArrayList<>();

        for (String s : lineArray) {
            // Разбиваем строку на слова по пробелам
            String[] splitWords = s.split(" ");

            for (String word : splitWords) {
                // Удаляем знаки препинания с помощью регулярного выражения
                String cleanedWord = word.replaceAll("[^а-яА-Яa-zA-Z0-9-]", "");
                if (!cleanedWord.isEmpty()) {
                    list.add(cleanedWord);
                }
            }
        }

        return list.toArray(new String[0]);
    }

    //у пользователя принемает в формате 1 - 1 слово, 2 - 2 члово, ...
    //возращает в формате начиная с нуля т.е. 0 - 1 слово, 1 - 2 слово, ...
    public static int getIndex(int maxLength) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        try {
            int index = Integer.parseInt(line);
            if (index < 1 || index > maxLength) {
                return -1;
            } else {
                return index - 1;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //функция полиндрома не чувствительна к регистру
    public static boolean isPalindrome(String word) {
        //приводим строку к нижнему регистру
        word = word.toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isUniqueCharactersVar1(String word) {
        //учитывая char что 16-битное беззнаковое целое число
        boolean[] visited = new boolean[65535];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (visited[ch]) {
                return false;
            }
            visited[ch] = true;
        }

        return true;
    }

    public static boolean isUniqueCharactersVar2(String word) {
        HashSet<Character> charactersSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (charactersSet.contains(ch)) {
                return false;
            }

            charactersSet.add(ch);
        }

        return true;
    }
}
