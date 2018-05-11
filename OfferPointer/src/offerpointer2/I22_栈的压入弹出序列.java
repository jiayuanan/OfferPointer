package offerpointer2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2018��3��21�� @author jiayuanan
 * item22:ջ��ѹ�롢��������
 * �������������������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 */

class Solution22 {
	//˼·:ʹ��һ��helperջģ��popA���е���ջ��ջ���̣����г�ջ���ݰ�˳�����result�����У����պ�popA�Ƚ�
	Stack<Integer> helper = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA == null || popA == null || pushA.length != popA.length)
    		return false;
    	int [] result = new int[popA.length];
    	int cnt = 0;
    	int popAIndex = 0;
    	int pushAIndex = 0;
    	
    	helper.push(pushA[pushAIndex++]);  //pushA�ĵ�һ��Ԫ���ܹ��ǵ�һ����ѹ�룻��д����peek()�����exception
    	//ģ����ջ���̣�ֱ��pushA�е���������ȫ�����ջhelper
    	//��helperջ��Ԫ����popAһһ�Աȣ���һ��ִ��ѹջ������һ��ִ�е�������
    	while(pushAIndex < pushA.length) {
    		if(Integer.valueOf(popA[popAIndex]) != helper.peek() ) {
    			helper.push(pushA[pushAIndex++]);
    		} else {
    			result[cnt++] = helper.pop();
    			++popAIndex;
    		}
    	}
    	//��ջ��ʣ���Ԫ�ص�����result��
    	while(!helper.isEmpty())
    		result[cnt++] = helper.pop();
    	
/*    	for(int i = 0; i < result.length; ++i) {
    		System.out.print(result[i] + " ");
    	}*/
    	return Arrays.equals(popA, result);
    }
}
public class I22_ջ��ѹ�뵯������ {
	public static void main(String...args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		int[] popB = {4,3,5,1,2};
		System.out.println(new Solution22().IsPopOrder(pushA, popA));
	}
}
