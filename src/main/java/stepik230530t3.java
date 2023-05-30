import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class stepik230530t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder("");

        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }

        String finalString = stream(stringBuilder.toString()
                .toLowerCase() // без учета регистра
                .chars() // Stream int-ов
                .map(c -> Character.isLetterOrDigit(c) || c == 32 ? c : 32) // оставляю символы из множества буквы, цифры и пробел
                .mapToObj(c -> String.valueOf((char) c)) // преобразовываю в Stream строк
                .collect(Collectors.joining()).split(" ")) // преобразовываю в строку и далее в строковый Stream
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream() // группирую по словам преобразовываю в Map (слово, частота) и далее в Stream Map-ов
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.<String, Long>comparingByKey())) // сортирую по значению по убыванию и потом по ключу
                .map(e -> e.getKey()) // преобразовываю в Stream строк (оставляя только ключ)
                .limit(11) // вывожу первых 10 слов
                .collect(Collectors.joining("\n")); // объединяю с разделителем "новая строка"
        System.out.println(finalString);

    }

}
