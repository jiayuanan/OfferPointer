package offerpointer1;

/**
 * 2018年3月21日 @author jiayuanan
 * item17:合并链表
 * 问题描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
class Solution17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	//递归做法
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

public class I17_合并链表 {
    //非递归做法
	public static ListNode Merge(ListNode list1, ListNode list2) {
		if(list1 == null && list2 == null)
				return null;
        if(list1 == null)
        	return list2;
        if(list2 == null)
        	return list1;
        //head用于标记头部，必不可少,只用result最后必指向null
        ListNode head = new ListNode(-1);
        ListNode result = head;
        while(list1 != null || list2 != null) {
        	if(list1 == null) {
        		result.next = list2;   //开始没写next，导致重新指向，所有的操作无效
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
