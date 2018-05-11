package offerpointer1;

import java.util.Stack;
//item7��������ջʵ�ֶ���  2018.03.19
//������item21,22,23       ���Ž⡪��P5
public class I07_������ջʵ�ֶ��� {

}
//popһ����push��  �����Եģ���Ӱ��
class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>(); //������push
    Stack<Integer> stack2 = new Stack<Integer>(); //������pop
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack1.isEmpty() && stack2.isEmpty()) {
    		throw new RuntimeException("the queue is empty!");
    	} else if (stack2.isEmpty()) {
    		while(!stack1.isEmpty())
    			stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}