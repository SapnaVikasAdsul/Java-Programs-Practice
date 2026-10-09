
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxOfList {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);

        System.out.println(max);
    }
}
