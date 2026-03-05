class PalindromeCheckerApp {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize string (ignore case and spaces)
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        char[] arr = normalized.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        // Compare characters from both ends
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        PalindromeCheckerApp checker = new PalindromeCheckerApp();

        String text = "Race Car";

        if (checker.checkPalindrome(text)) {
            System.out.println(text + " is a palindrome (ignoring case and spaces)");
        } else {
            System.out.println(text + " is not a palindrome");
        }
    }
}