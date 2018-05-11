package offerpointer3;

/**
 * 2018��3��21�� @author jiayuanan
 * ʹ���ߣ� item05�� item15
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
