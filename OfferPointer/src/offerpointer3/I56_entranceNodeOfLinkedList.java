package offerpointer3;

import java.util.HashSet;

/**
 * 2018��3��27�� @author jiayuanan
 * item56:�����л�����ڽ��
 * ����������һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */
class Solution56 {
	//ʹ��HashSet�洢ListNode�����η��룬��һ���ظ�����Ľ�㼴Ϊ��ڽ��
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
