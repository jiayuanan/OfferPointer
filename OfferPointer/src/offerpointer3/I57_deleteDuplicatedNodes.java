package offerpointer3;



/**
 * 2018年3月27日 @author jiayuanan
 * item57:删除链表中重复的结点
 * 问题描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class Solution57 {
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null)
    		return null;
    	
    	ListNode preNode = new ListNode(-1);  //preNode是解题关键
    	ListNode result = preNode;
    	preNode.next = pHead;
    	ListNode curNode = pHead;
    	while(curNode != null) {
    		//没有重复的就一直递归
    		if(!sameValue(curNode, curNode.next)) {//注意，这里的重复是指值相等，不可用==
    			preNode = curNode;
    			curNode = curNode.next;
    		} else {
    			ListNode nextNode = curNode.next;
    			//有重复的，一直到重复的最右边
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
