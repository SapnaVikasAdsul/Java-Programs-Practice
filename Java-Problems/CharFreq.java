
import java.util.HashMap;

public class CharFreq {
    public static void main(String[] args) {
        String s = "programming";
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!count.containsKey(ch)) {
                count.put(ch, 1);
            } else {
                count.put(ch, count.get(ch) + 1);
            }
        }

        

        System.out.println(count);
    }
}
