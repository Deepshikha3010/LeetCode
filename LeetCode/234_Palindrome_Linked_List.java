/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = slow.next;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
        }
        
        node = dummy.next;
        
        while (node != null) {
            if (head.val != node.val) {
                return false;
            }
            node = node.next;
            head = head.next;
        }
        
        return true;
    }
}