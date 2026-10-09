
import java.util.Arrays;
import java.util.List;

public class UniqueList {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> numbers
                = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5);
        
        //remove duplicates
        List<Integer> unique = numbers.stream()
                .distinct()
                .toList();

        System.out.println(unique);
    }
}
