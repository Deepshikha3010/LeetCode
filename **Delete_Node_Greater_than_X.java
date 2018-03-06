/**
 * Godaddy
 * Delete Node Greater than X
 * 创建一个新的node，添加所有值小于等于x的node去往新的链表。
 */

class Solution {
    public void deleteNodeGreaterThanX(ListNode node, int x){
        if(node == null){
            return;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(node != null){
            if(node.val <= x){
                tail.next = node;
                tail = tail.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}