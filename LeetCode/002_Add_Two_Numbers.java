/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Dummy Node (n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy  = new ListNode(0);
        ListNode pt = dummy;
        ListNode head1 = l1, head2 = l2;
        int remainder = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remainder;
            pt.next = new ListNode(sum % 10);
            pt = pt.next;
            remainder = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int sum = l1.val + remainder;
            pt.next = new ListNode(sum % 10);
            pt = pt.next;
            remainder = sum / 10;
            l1 = l1.next;
        }
        while(l2 != null) {
            int sum = l2.val + remainder;
            pt.next = new ListNode(sum % 10);
            pt = pt.next;
            remainder = sum / 10;
            l2 = l2.next;
        }
        if (remainder != 0) {
            pt.next = new ListNode(remainder);
        }
        return dummy.next;
    }
}