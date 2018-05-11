package ch4clearthoughts;

/**
 * 2018��3��21�� @author jiayuanan
 * item21������min������ջ
 * ��������������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min����
 */

import java.util.Stack;
class Solution21 {
	Stack<Integer> dataStack = new Stack<>(); //�����������
	Stack<Integer> minStack = new Stack<>();  //���ݴ��µ��ϵ���
	int min = Integer.MAX_VALUE;
    
	//push��pop��3����Ҫ���ж�Ӧ�Ĳ���
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
public class I21_����min������ջ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
