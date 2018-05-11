package offerpointer3;



/**
 * 2018��3��27�� @author jiayuanan
 * item57:ɾ���������ظ��Ľ��
 * ������������һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
class Solution57 {
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null)
    		return null;
    	
    	ListNode preNode = new ListNode(-1);  //preNode�ǽ���ؼ�
    	ListNode result = preNode;
    	preNode.next = pHead;
    	ListNode curNode = pHead;
    	while(curNode != null) {
    		//û���ظ��ľ�һֱ�ݹ�
    		if(!sameValue(curNode, curNode.next)) {//ע�⣬������ظ���ֵָ��ȣ�������==
    			preNode = curNode;
    			curNode = curNode.next;
    		} else {
    			ListNode nextNode = curNode.next;
    			//���ظ��ģ�һֱ���ظ������ұ�
    			while(sameValue(curNode, nextNode)) {
    				curNode = nextNode;
    				nextNode = nextNode.next;
    			}
    			
    			preNode.next = nextNode;
    			if(nextNode == null)
    				break;
    			else {
    				curNode = nextNode;
    			}
    		}
    		
    	}

    	
    	return result.next;
    }
    public boolean sameValue(ListNode l1, ListNode l2) {
    	if(l1 == null || l2 == null)
    		return false;
    	else 
    		return l1.val == l2.val;
    }
}
public class I57_deleteDuplicatedNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;l5.next = l6;
		System.out.println(new Solution57().deleteDuplication(l2));
	}

}
