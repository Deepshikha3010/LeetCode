/**
 * Two Pointers + Dummy Node: 
 * 1. tail从head出发，控制距离。
 * 2. tail最终停到null，相当于越过最后一个node一位。
 * 3. head从dummy node出发（相当于提前一位，解决tail越过问题），最终停到target node前面一位。
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = head;
        while(n > 0){
            tail = tail.next;
            n--;
        }
        while(tail != null){
            tail = tail.next;
            pre = pre.next;
        }
        ListNode temp = pre.next.next;
        pre.next.next = null;
        pre.next = temp;
        return dummy.next;
    }
}