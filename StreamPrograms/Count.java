
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Count {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        //count numbers greater than 20

        // findFirst() → Optional<T>
        // max()       → Optional<T>
        // min()       → Optional<T>
        // count()     → long
        // toList()    → List<T>

        long count = numbers.stream()
                .filter(n -> n > 20)
                .count();

        System.out.println(count);

        //find first number grater than 20
        Optional<Integer> num = numbers.stream()
                .filter(n -> n > 20)
                .findFirst();

        System.out.println(num);

    }
}
