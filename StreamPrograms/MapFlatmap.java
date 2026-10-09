
import java.util.Arrays;
import java.util.List;

public class MapFlatmap {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> flattened = numbers.stream()
                .flatMap(list -> list.stream())
                .toList();

        System.out.println(flattened);
    }
}
