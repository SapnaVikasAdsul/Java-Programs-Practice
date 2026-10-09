
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class NonRepeatingChar {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<String> names = Arrays.asList(
                "A", "R", "A", "P", "A", "A", "R", "R"
        );

        //List items starts with "A" to uppercase
        Map<String, Long> frequency = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        Optional<String> firstUnique = frequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst();

        System.out.println(firstUnique);

    }
}
