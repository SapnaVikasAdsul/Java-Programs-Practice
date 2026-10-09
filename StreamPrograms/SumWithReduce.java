
import java.util.Arrays;
import java.util.List;

public class SumWithReduce {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }
}
