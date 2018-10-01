/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pt = dummy;
        ListNode temp;
        ListNode tail;
        while(pt != null && pt.next != null && pt.next.next != null) {
            temp = pt.next;
            tail = pt.next.next.next;
            pt.next = pt.next.next;
            pt.next.next = temp;
            temp.next = tail;
            pt = temp;
        }
        return dummy.next;
    }
}