/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode head = headA;
        int count1 = 0;
        int count2 = 0;
        while (head != null) {
            count1++;
            head = head.next;
        }
        head = headB;
        while (head != null) {
            count2++;
            head = head.next;
        }
        
        return count1 > count2 ? check(headA, count1, headB, count2) : check(headB, count2, headA, count1);
    }
    
    ListNode check(ListNode h1, int count1, ListNode h2, int count2) {
        while (count1 > count2) {
            h1 = h1.next;
            count1--;
        }
        
        while (h1 != null && h2 != null && h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        
        if (h1 == h2) {
            return h1;
        }
        return null;
    }
}