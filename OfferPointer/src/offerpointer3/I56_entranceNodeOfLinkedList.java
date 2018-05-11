package offerpointer3;

import java.util.HashSet;

/**
 * 2018年3月27日 @author jiayuanan
 * item56:链表中环的入口结点
 * 问题描述：一个链表中包含环，请找出该链表的环的入口结点。
 */
class Solution56 {
	//使用HashSet存储ListNode，依次放入，第一个重复放入的结点即为入口结点
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)
        	return null;
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode result = null;
        while(pHead != null) {
        	if(!nodeSet.contains(pHead)) {
        		nodeSet.add(pHead);
        	} else {
        		result = pHead;
        		break;
        	}
        	pHead = pHead.next;
        }
        
        return result;
    }
}
public class I56_entranceNodeOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l3;
		System.out.println(new Solution56().EntryNodeOfLoop(l3));
	}

}
