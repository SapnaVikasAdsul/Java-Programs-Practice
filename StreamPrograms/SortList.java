
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        //Ascending
        List<Integer> sortedAsc = numbers.stream()
                .sorted()
                .toList();

        System.out.println(sortedAsc);

        //Descending
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(sortedDesc);
    }
}
