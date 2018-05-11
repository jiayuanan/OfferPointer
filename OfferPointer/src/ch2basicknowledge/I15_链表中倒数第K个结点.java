package ch2basicknowledge;

/**
 * 2018年3月21日 @author jiayuanan
 * item15: 链表中倒数第K个结点
 * 描述：输入一个链表，输出该链表中倒数第k个结点。
 */


class Solution15 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head == null || k <= 0)
    		return null;
    	
    	ListNode kthToTail = null;   //默认值，K取值不好的时候为null
    	ListNode pHead = head;
    	int cnt = 0;// head走的距离
    	while (head != null) {
    		if(cnt == k-1) { //当head走k-1步时，kthToTail开始出发
    			kthToTail = pHead;
    			pHead = pHead.next; //刚开始这一行忘记加了
    			head = head.next;
    		} else {   			
    			head = head.next;
    			++cnt;
    		}
    	}
    	return kthToTail;
    }
    
}



public class I15_链表中倒数第K个结点 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;l2.next=l3;l3.next=l4;l4.next=l5;
		
		System.out.println(new Solution15().FindKthToTail(l1, 3));
	}

}
