
import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
        String str1 = "silent";
        String str2 = "listen";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length()) {
            System.out.println("Not anagrams");
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if (Arrays.equals(charArray1, charArray2)) {
            System.out.println("Anagrams");
        }

    }
}
