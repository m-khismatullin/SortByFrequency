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

        String dataString = stringBuilder.toString()
                .toLowerCase()
                .chars()
                .map(c -> Character.isLetterOrDigit(c) || c == 32 ? c : 32)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(dataString);


        Map<String, Long> frequencyMap = stream(dataString.split(" "))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(frequencyMap);

        String finalString = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.<String, Long>comparingByKey()))
                .limit(11)
                .map(e -> e.getKey())
                .collect(Collectors.joining("\n"));
        System.out.println(finalString);

    }

}
