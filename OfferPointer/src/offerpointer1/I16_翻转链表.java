package offerpointer1;

import java.util.Stack;

/**
 * 2018年3月21日 @author jiayuanan
 * item16:
 * 描述：输入一个链表，反转链表后，输出链表的所有元素。
 */
class Solution16 {
    public ListNode ReverseList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode pre = null;
    	ListNode next = null;
    	
    	while(head != null) {
    		next = head.next;  //先保存下一个结点信息
    		//翻转
    		head.next = pre;
    		//迭代
    		pre = head;
    		head = next;   		
    	}
    	return pre; //head最后为null，head前一个即为头部
    }
}

public class I16_翻转链表 {
	public static void main(String...args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;l2.next=l3;l3.next=l4;l4.next=l5;
		System.out.println(new Solution16().ReverseList(l2).next.val);
	}
}
