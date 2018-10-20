/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        
        while (head != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            tail.next = head;
            head = head.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}