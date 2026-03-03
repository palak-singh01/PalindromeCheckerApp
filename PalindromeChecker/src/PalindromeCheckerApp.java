import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Is Palindrome? " + isPalindrome(input));
    }
}



