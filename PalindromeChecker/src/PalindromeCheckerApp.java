import java.util.*;

public class PalindromeCheckerApp {

    // Stack based palindrome check
    public static boolean stackPalindrome(String input) {
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque based palindrome check
    public static boolean dequePalindrome(String input) {
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String text = "A man a plan a canal Panama";

        // Measure Stack strategy
        long start1 = System.nanoTime();
        boolean result1 = stackPalindrome(text);
        long end1 = System.nanoTime();
        long stackTime = end1 - start1;

        // Measure Deque strategy
        long start2 = System.nanoTime();
        boolean result2 = dequePalindrome(text);
        long end2 = System.nanoTime();
        long dequeTime = end2 - start2;

        System.out.println("Input: " + text);
        System.out.println("Stack Result: " + result1 + " | Time: " + stackTime + " ns");
        System.out.println("Deque Result: " + result2 + " | Time: " + dequeTime + " ns");
    }
}