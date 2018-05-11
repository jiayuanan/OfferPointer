package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I62_二进制中1的个数.java
 * 
 */
import java.util.*;
public class I62_二进制中1的个数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	System.out.println(findNumberOf1(num));
        }
        scan.close();
    }
    
    public   static   int  findNumberOf1( int num) { 
    	int sum = 0;
    	while(num != 0) {
    		++sum;
    		num = num &(num - 1); //消去最右边的1
    	}
    	return sum;
    }
}
