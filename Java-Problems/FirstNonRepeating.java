
import java.util.HashMap;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String s = "swiss";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean found = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.get(ch) == 1) {
                System.out.println(ch);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeating character");
        }
    }
}
