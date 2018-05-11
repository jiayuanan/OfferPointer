package offerpointer2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2018年3月21日 @author jiayuanan
 * item22:栈的压入、弹出序列
 * 问题描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */

class Solution22 {
	//思路:使用一个helper栈模拟popA序列的入栈出栈过程；其中出栈数据按顺序放在result数组中，最终和popA比较
	Stack<Integer> helper = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA == null || popA == null || pushA.length != popA.length)
    		return false;
    	int [] result = new int[popA.length];
    	int cnt = 0;
    	int popAIndex = 0;
    	int pushAIndex = 0;
    	
    	helper.push(pushA[pushAIndex++]);  //pushA的第一个元素总归是第一个被压入；不写本句peek()会产生exception
    	//模拟入栈过程，直至pushA中的所有数据全部入过栈helper
    	//将helper栈顶元素与popA一一对比，不一样执行压栈操作；一样执行弹出操作
    	while(pushAIndex < pushA.length) {
    		if(Integer.valueOf(popA[popAIndex]) != helper.peek() ) {
    			helper.push(pushA[pushAIndex++]);
    		} else {
    			result[cnt++] = helper.pop();
    			++popAIndex;
    		}
    	}
    	//将栈中剩余的元素弹出至result中
    	while(!helper.isEmpty())
    		result[cnt++] = helper.pop();
    	
/*    	for(int i = 0; i < result.length; ++i) {
    		System.out.print(result[i] + " ");
    	}*/
    	return Arrays.equals(popA, result);
    }
}
public class I22_栈的压入弹出序列 {
	public static void main(String...args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		int[] popB = {4,3,5,1,2};
		System.out.println(new Solution22().IsPopOrder(pushA, popA));
	}
}
