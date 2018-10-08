/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Merge Sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode mid = getMid(node);
        ListNode left = node;
        ListNode right = mid.next;
        mid.next = null;
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(left != null && right != null) {
            if (left.val < right.val) {
                head.next = new ListNode(left.val);
                left = left.next;
            } else {
                head.next = new ListNode(right.val);
                right = right.next;
            }
            head = head.next;
        }
        while(left != null) {
            head.next = new ListNode(left.val);
            left = left.next;
            head = head.next;
        }
        while(right != null) {
            head.next = new ListNode(right.val);
            right = right.next;
            head = head.next;
        }
        return dummy.next;
    }
    
    private ListNode getMid(ListNode node) {
        ListNode slow = node, fast = node.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}