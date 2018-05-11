package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
题目描述
完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
返回n以内完全数的个数。 异常情况返回-1
 */
import java.util.*;
public class I56_完全数计算{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	System.out.println(count(num));
        }
        scan.close();
    }
    
    public static int count(int n) {
    	if(n <= 1)
    		return 0;
    	int sum = 0;
    	//从2开始数
    	for(int i = 2; i <= n; ++i) {
    		if(isPerfect(i))
    			++sum;
    	}
    	
    	return sum;
    }
    
    public static boolean isPerfect(int m) {
    	int upper = (int) Math.sqrt(m);
    	int sum = 1;   //先加个1
    	for(int i = 2; i <= upper; ++i) {//若用小于会有疏漏
    		if(m % i == 0) {
    			sum += i + m/i;
    		}
    	}
    	if(upper * upper == m)
    		sum -= upper;  //这个不能加2次
    	
    	return sum == m;
    }
}
