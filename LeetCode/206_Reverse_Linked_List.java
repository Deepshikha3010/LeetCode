/**
 * Solution 1(Dummy Node): 时间复杂度n, 空间复杂度1
 * 1. 创建一个dummy node，dummy.next用来只想新的node的next。
 * 2. 用一个temp node暂存node原来的next。
 * 
 * Solution 2:  时间复杂度n, 空间复杂度1
 * dummy node其实是多余的。
 */

/**Solution 1 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }
}

/**Solution 2 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}