
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(1, 2, 3, 2, 4, 3, 4, 5);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicateEle = numbers.stream()
                .filter(ele -> !seen.add(ele))
                .collect(Collectors.toSet());

        System.out.println(duplicateEle);

        //Frequency of Each Element
        Map<Integer, Long> frequency = numbers.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()));

        System.out.println(frequency);

        //Count grater than 1
        List<Integer> freqGreater = frequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .toList();

        System.out.println(freqGreater);
    }
}
