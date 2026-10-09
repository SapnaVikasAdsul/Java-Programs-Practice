
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringOps {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<String> names = Arrays.asList(
                "Amit", "Rahul", "Ankit", "Priya", "Ajay", "Amit", "Rahul", "Rahul"
        );

        //List items starts with "A" to uppercase
        List<String> namesStartsWithA = names.stream()
                .filter(ele -> ele.startsWith("A"))
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println(namesStartsWithA);

        //Frequency of Each Element
        Map<String, Long> frequency = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        System.out.println(frequency);

        //longest string
        Optional<String> longest = names.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println(longest);

        //join strings
        String result = names.stream()
                .collect(Collectors.joining(", "));

    }
}
