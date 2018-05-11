package ch2basicknowledge;

/**
 * 2018��3��21�� @author jiayuanan
 * item15: �����е�����K�����
 * ����������һ����������������е�����k����㡣
 */


class Solution15 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head == null || k <= 0)
    		return null;
    	
    	ListNode kthToTail = null;   //Ĭ��ֵ��Kȡֵ���õ�ʱ��Ϊnull
    	ListNode pHead = head;
    	int cnt = 0;// head�ߵľ���
    	while (head != null) {
    		if(cnt == k-1) { //��head��k-1��ʱ��kthToTail��ʼ����
    			kthToTail = pHead;
    			pHead = pHead.next; //�տ�ʼ��һ�����Ǽ���
    			head = head.next;
    		} else {   			
    			head = head.next;
    			++cnt;
    		}
    	}
    	return kthToTail;
    }
    
}



public class I15_�����е�����K����� {
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
