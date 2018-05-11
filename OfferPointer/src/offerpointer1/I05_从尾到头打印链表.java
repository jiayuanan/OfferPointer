package offerpointer1;

import java.util.ArrayList;
import java.util.Stack;

//item5������һ�������ͷ��㣬��β��ͷ��������ӡÿ������ֵ
public class I05_��β��ͷ��ӡ���� {
	
	public static void main(String...args) {
		ListNode listNode1 = new ListNode(67);
		ListNode listNode2 = new ListNode(0);
		ListNode listNode3 = new ListNode(24);
		ListNode listNode4 = new ListNode(58);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
	
		System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode1));
	}

}


//ʹ��stackʵ������
class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> result = new ArrayList<>();
    	Stack<Integer> stack = new Stack<>();
    	
    	//��ֵ˳��װ��ջ��
        while(listNode != null) {
        	stack.push(listNode.val);
        	listNode = listNode.next;
        }
        //��ֵ����װ��arraylist��
        while(!stack.isEmpty())
        	result.add(stack.pop());
        
        return result;
        	
    }
}
