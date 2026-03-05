public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Step 1: Normalize the string
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Convert to char array
        char[] arr = normalized.toCharArray();

        // Step 3: Check palindrome
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String str = "Race Car";

        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome ");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }
}