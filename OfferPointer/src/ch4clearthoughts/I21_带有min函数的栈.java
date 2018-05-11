package ch4clearthoughts;

/**
 * 2018年3月21日 @author jiayuanan
 * item21：带有min函数的栈
 * 问题描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 */

import java.util.Stack;
class Solution21 {
	Stack<Integer> dataStack = new Stack<>(); //存放正常数据
	Stack<Integer> minStack = new Stack<>();  //数据从下到上递增
	int min = Integer.MAX_VALUE;
    
	//push和pop对3个域都要进行对应的操作
    public void push(int node) {
    	if(dataStack.isEmpty())
    		min = node;
    	else
    		min = min > node ? node : min;
        dataStack.push(node);
        minStack.push(min);
        
    }
    
    public void pop() {
        dataStack.pop();
        int data = minStack.pop();
        if(minStack.peek() > data)
        	min = minStack.peek();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return min;
    }
}
public class I21_带有min函数的栈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
