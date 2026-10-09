
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNum {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        List<Integer> evenList = numbers.stream()
                .filter(ele -> ele % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenList);
    }
}
