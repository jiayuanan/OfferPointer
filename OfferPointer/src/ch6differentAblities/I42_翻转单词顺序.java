package ch6differentAblities;

/**
 * 2018年3月26日 @author jiayuanan
 * item42:翻转单词顺序
 * 问题描述：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *         例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
class Solution42_1 {
    public String LeftRotateString(String str,int n) {
        if(str == null)
        	return null;
        if(str.length() == 0)
        	return str;
        
        
        int length = str.length();
        n = n % length;
        
        if(n == 0)
        	return str;
        
        return str.substring(n) + str.substring(0, n);
        
    }
}
public class I42_翻转单词顺序 {

	public static void main(String[] args) {
		String s = "12345";
		System.out.println(s.substring(3) + s.substring(0, 3));
		// TODO Auto-generated method stub

	}

}
