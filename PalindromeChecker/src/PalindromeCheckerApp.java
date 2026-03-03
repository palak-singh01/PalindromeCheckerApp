public class PalindromeCheckerApp {

    public boolean isPalindrome(String s) {
        // Pre-processing: remove non-alphanumeric and convert to lowercase
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursive(clean, 0, clean.length() - 1);
    }

    private boolean checkRecursive(String s, int start, int end) {
        // 1. Base Condition: If pointers cross or meet, it's a palindrome
        if (start >= end) {
            return true;
        }

        // 2. Recursive Step: Compare characters at current bounds
        if (s.charAt(start) != s.charAt(end)) {
            return false; // Character mismatch found
        }

        // 3. Move inward: Call the function for the smaller subproblem
        return checkRecursive(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String word = "level";
        System.out.println("Is '" + word + "' a palindrome? " + checker.isPalindrome(word));
    }
}