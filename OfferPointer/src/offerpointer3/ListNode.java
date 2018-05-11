package offerpointer3;

/**
 * 2018年3月21日 @author jiayuanan
 * 使用者： item05， item15
 * 
 */
public class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
	public String toString() {
		String result = "";
		ListNode node = this;
		while(node != null) {
			Integer i = node.val;
			result = result + i.toString() + " ";
			node = node.next;
		}
		return result;
	}
}
