import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class stepik230530t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder("");

        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }

        Arrays.stream(stringBuilder
                        .toString()
                        .toLowerCase()
                        .replaceAll("[^\\p{L}\\p{Space}]","")
                        .split("\\s"))
                .collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.<String,Long>comparingByKey()))
                .map(e->e.getKey())
                .filter(e->e.trim().length()>0)
                .limit(10)
                .forEach(System.out::println);

        //Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
    }

}
