/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode plusOne(ListNode head) {
      if (head == null) {
          return head;
      }
      
      ListNode dummy = new ListNode(0);
      while (head != null) {
          ListNode temp = head.next;
          head.next = dummy.next;
          dummy.next = head;
          head = temp;
      }
      
      head = dummy.next;
      int rest = 1;
      while (head != null && head.next != null) {
          int sum = head.val + rest;
          head.val = sum % 10;
          rest = sum / 10;
          head = head.next;
      }
      
      int sum = head.val + rest;
      head.val = sum % 10;
      rest = sum / 10;
      if (rest != 0) {
          head.next = new ListNode(rest);
      }
      
      ListNode dummy2 = new ListNode(0);
      ListNode n = dummy.next;
      while (n != null) {
          ListNode temp = n.next;
          n.next = dummy2.next;
          dummy2.next = n;
          n = temp;
      }
      
      return dummy2.next;
  }
}