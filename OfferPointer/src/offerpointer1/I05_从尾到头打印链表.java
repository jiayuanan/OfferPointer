package offerpointer1;

import java.util.ArrayList;
import java.util.Stack;

//item5：输入一个链表的头结点，从尾到头反过来打印每个结点的值
public class I05_从尾到头打印链表 {
	
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


//使用stack实现逆向
class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> result = new ArrayList<>();
    	Stack<Integer> stack = new Stack<>();
    	
    	//将值顺序装入栈中
        while(listNode != null) {
        	stack.push(listNode.val);
        	listNode = listNode.next;
        }
        //将值逆序装入arraylist中
        while(!stack.isEmpty())
        	result.add(stack.pop());
        
        return result;
        	
    }
}
