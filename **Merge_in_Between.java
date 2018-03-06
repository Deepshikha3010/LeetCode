/**
 * Godaddy
 * consider two linkedlists, list1 and list2, and two integers, a and b. 
 * We want to merge the two lists by removing the ath through bth nodes in list1 and inserting list2 in their place. 
 * 就是去掉list1的第a个到第b个并从中插入list2。
 * 
 * Solution 1: 时间复杂度n，空间复杂度1
 * 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**Solution 1 */
class Solution {
    public void mergeInBetween(ListNode root1, ListNode root2, int a, int b){
        if(root1 == null || root2 == null){
            return;
        }
        ListNode curA = root1;
        ListNode curB = root2;
        while(a > 1){
            curA = curA.next;
            curB = curB.next;
            a--;
        }
        ListNode node = curA.next;
        int len = b - a;
        while(len > 0){
            node = node.next;
            len--;
        }
        ListNode temp = curA.next;
        curA.next = node.next;
        node.next = curB.next;
        curB.next = curA.next;
    }
}