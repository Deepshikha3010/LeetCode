/**
 * Type: Linked List
 * Time: n
 * Space: 1
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int rest = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            
            int sum = n1 + n2 + rest;
            head.next = new ListNode(sum % 10);
            rest = sum / 10;
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (rest != 0) {
            head.next = new ListNode(rest);
        }
        
        return dummy.next;
    }
}