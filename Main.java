class ListNode<T> {
    T value;
    ListNode<T> next;

    ListNode(T x) {
        value = x;
    }
}

public class Main {
    public static ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        // Reverse the input lists to facilitate addition
        a = reverseList(a);
        b = reverseList(b);

        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = dummy;
        int carry = 0;

        // Traverse both lists and add corresponding values
        while (a != null || b != null || carry != 0) {
            int sum = carry;
            if (a != null) {
                sum += a.value;
                a = a.next;
            }
            if (b != null) {
                sum += b.value;
                b = b.next;
            }

            carry = sum / 10000; // Extract carry (number overflow beyond 4 digits)
            int digit = sum % 10000; // Extract 4-digit result
            current.next = new ListNode<>(digit);
            current = current.next;
        }

        // Reverse the result list to restore original order
        return reverseList(dummy.next);
    }

    // Helper function to reverse a linked list
    private static ListNode<Integer> reverseList(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        while (head != null) {
            ListNode<Integer> nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: a = [9876, 5432, 1999], b = [1, 8001]
        ListNode<Integer> a = new ListNode<>(9876);
        a.next = new ListNode<>(5432);
        a.next.next = new ListNode<>(1999);

        ListNode<Integer> b = new ListNode<>(1);
        b.next = new ListNode<>(8001);

        ListNode<Integer> result = solution(a, b);
        printList(result); // Output: [9876, 5434, 0]

        // Example 2: a = [123, 4, 5], b = [100, 100, 1001]
        a = new ListNode<>(123);
        a.next = new ListNode<>(4);
        a.next.next = new ListNode<>(5);

        b = new ListNode<>(100);
        b.next = new ListNode<>(100);
        b.next.next = new ListNode<>(1001);

        result = solution(a, b);
        printList(result); // Output: [223, 104, 105]
    }

    // Helper function to print a linked list
    private static void printList(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.value + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}