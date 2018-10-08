/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// Use HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        RandomListNode node = head;
        
        while(node != null) {
            cur.next = new RandomListNode(node.label);
            map.put(node, cur.next);
            node = node.next;
            cur = cur.next;
        }
        
        cur = dummy.next;
        while(head != null) {
            cur.random = map.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}

// No HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitCopy(head);
    }
    
    private void copyNext(RandomListNode head) {
        while(head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while(head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode splitCopy(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        while(head != null) {
            node.next = head.next;
            head.next = head.next.next;
            head = head.next;
            node = node.next;
        }
        return dummy.next;
    }
}