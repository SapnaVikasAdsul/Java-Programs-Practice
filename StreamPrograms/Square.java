
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Square {

    public static void main(String[] args) {
        System.out.println("Square of all elements using map");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        List<Integer> squareList = numbers.stream()
                .map(ele -> ele * ele)
                .collect(Collectors.toList());

        System.out.println(squareList);

        List<Integer> evenSqrList = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * e)
                .toList();
        System.out.println(evenSqrList);
    }
}
