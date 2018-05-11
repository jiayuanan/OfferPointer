package offerpointer1;

import java.util.Stack;
//item7：用两个栈实现队列  2018.03.19
//关联：item21,22,23       最优解——P5
public class I07_用两个栈实现队列 {

}
//pop一半再push？  ——对的，不影响
class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>(); //仅用作push
    Stack<Integer> stack2 = new Stack<Integer>(); //仅用作pop
    
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