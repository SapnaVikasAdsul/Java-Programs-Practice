
public class Palindrome {
    public static void main(String[] args) {
        String s = "madam";
        boolean isPalindrome = true;

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}

// Time complexity: O(n)
// Space complexity: O(1)