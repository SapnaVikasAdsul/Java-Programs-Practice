
import java.util.HashMap;
import java.util.Map;

public class Duplicates {

    public static void main(String[] args) {

        String s = "Programming";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }

        }
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() > 1) {
                System.out.println(en.getKey() + "=" + en.getValue());
            }

        }
    }
}
