/**
 * #Godaddy
 * 
 * Use ListNode to implement a stack.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 时间复杂度n, 空间复杂度n
 * 用一个head记录stack的top。
 * 
 */

class MyStack {
    ListNode head;

    public MyStack(){
        head = null;
    }

    public void push(int x){
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    public int pop(){
        int result = head.val;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public int peek(){
        return head.val;
    }

    public boolean isEmpty(){
        return head == null;
    }
}