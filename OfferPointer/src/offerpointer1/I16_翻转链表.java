package offerpointer1;

import java.util.Stack;

/**
 * 2018��3��21�� @author jiayuanan
 * item16:
 * ����������һ��������ת�����������������Ԫ�ء�
 */
class Solution16 {
    public ListNode ReverseList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode pre = null;
    	ListNode next = null;
    	
    	while(head != null) {
    		next = head.next;  //�ȱ�����һ�������Ϣ
    		//��ת
    		head.next = pre;
    		//����
    		pre = head;
    		head = next;   		
    	}
    	return pre; //head���Ϊnull��headǰһ����Ϊͷ��
    }
}

public class I16_��ת���� {
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
