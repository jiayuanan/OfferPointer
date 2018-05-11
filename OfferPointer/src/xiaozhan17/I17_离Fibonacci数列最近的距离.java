package xiaozhan17;

/**
 * 2018年4月20日 @author jiayuanan
 * I17_离Fibonacci数列最近的距离.java
 * 
 */
//由于输入范围较小，直接使用一个数组存放F值即可
import java.util.*;
public class I17_离Fibonacci数列最近的距离{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
    	int[] F = new int[50];
    	F[0] = 0; F[1] = 1;
    	for(int i = 2; i < 50; ++i)
    		F[i] = F[i-1] + F[i-2];
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	int left = 0;
        	int right = 0;
        	for(int i = 0; i < 50; ++i) {
        		if(F[i] > num) {
        			right = F[i];
        			left = F[i-1];
        			break;
        		}
        	}
        	System.out.println(Math.min(Math.abs(right - num), Math.abs(left - num)));
        }
        scan.close();
    }
}
