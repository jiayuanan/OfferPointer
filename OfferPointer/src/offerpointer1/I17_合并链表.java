package offerpointer1;

/**
 * 2018��3��21�� @author jiayuanan
 * item17:�ϲ�����
 * �������������������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
class Solution17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	//�ݹ�����
        if(list1 == null)
        	return list2;
        if(list2 == null)
        	return list1;
        
        ListNode result = null;
        if(list1.val <= list2.val) {
        	result = list1;
        	result.next = Merge(list1.next, list2);
        } else  {
        	result = list2;
        	result.next = Merge(list1, list2.next);
        }
        return result;
    }
}

public class I17_�ϲ����� {
    //�ǵݹ�����
	public static ListNode Merge(ListNode list1, ListNode list2) {
		if(list1 == null && list2 == null)
				return null;
        if(list1 == null)
        	return list2;
        if(list2 == null)
        	return list1;
        //head���ڱ��ͷ�����ز�����,ֻ��result����ָ��null
        ListNode head = new ListNode(-1);
        ListNode result = head;
        while(list1 != null || list2 != null) {
        	if(list1 == null) {
        		result.next = list2;   //��ʼûдnext����������ָ�����еĲ�����Ч
        		break;
        	}
        	if(list2 == null) {
        		result.next = list1;
        		break;
        	}
    	    if(list1.val <= list2.val ) {
    		    result.next = list1;
    		    list1 = list1.next;
    	    } else {
    		    result.next = list2;
    	 	    list2 = list2.next;
    	    }
    	    result = result.next;
        }
    
        return head.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l3; l3.next = l5;
		l2.next = l4; l4.next = l6;
		System.out.println(Merge(l1, l2));
		//System.out.println(new Solution17().Merge(l1, l2));

	}

}
