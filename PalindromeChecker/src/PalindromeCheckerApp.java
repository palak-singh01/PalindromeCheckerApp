class ListNode {
    char val;
    ListNode next;
    ListNode(char val) { this.val = val; }
}

public class PalindromeCheckerApp {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        // 1. Convert string to linked list
        ListNode head = convertToLinkedList(s);

        // 2. Find the middle using Fast and Slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Reverse the second half in-place
        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        // 4. Compare both halves
        ListNode tempSecond = secondHalfHead;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalfHead.val != tempSecond.val) {
                result = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        // (Optional) Restore the list by reversing back
        reverseList(secondHalfHead);

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    private ListNode convertToLinkedList(String s) {
        ListNode dummy = new ListNode('0');
        ListNode current = dummy;
        for (char c : s.toCharArray()) {
            current.next = new ListNode(c);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String test = "racecar";
        System.out.println("Is '" + test + "' a palindrome? " + checker.isPalindrome(test));
    }
}