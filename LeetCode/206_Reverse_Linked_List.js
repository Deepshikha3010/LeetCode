/**
 * 使用dummy node。
 * 时间复杂度n，空间复杂度1
 */

var reverseList = function(head) {
  if(!head){
      return head;
  }
  const dummy = new ListNode(0);
  while(head){
      const tmp = head.next;
      head.next = dummy.next;
      dummy.next = head;
      head = tmp;
  }
  return dummy.next;
};