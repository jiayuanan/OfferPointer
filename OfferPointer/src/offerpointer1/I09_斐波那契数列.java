package offerpointer1;

/**
 * 2018年3月20日 @author jiayuanan
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */

class Solution9 {
    public int Fibonacci(int n) {
    	//错误判断
    	if(n < 0)
    		throw new RuntimeException("n should be over 0");
    	if(n == 0)
    		return 0;
    	if(n == 1)
    		return 1;
    	
    	int first = 0; 
    	int second = 1;
    	while(n >= 1) {
    		second += first;
    		first = second - first;
    		--n;
    	}
    	return first;
    }
}



public class I09_斐波那契数列 {
	public static void main(String...args) {
		System.out.println(new Solution9().Fibonacci(3));
	}
}
