package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I60_偶数拆分成两个素数.java
 * 
 */
import java.util.Scanner;
public class I60_偶数拆分成两个素数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	//两个素数肯定是两个奇数，2不行，其他都可以。。都中间往两边扩散
        	int mid = num / 2;
        	int realMid = mid % 2 == 1 ? mid : mid - 1;//取奇数
        	while(true) {
        		//System.out.println(realMid);
        		if(isPrime(realMid) && isPrime(num - realMid)) {
        			System.out.println(realMid);
        			System.out.println(num - realMid);
        			break;
        		} else {
        			realMid -= 2; //2个2个的递减
        		}
        	}
        	
        }
        scan.close();
    }
    
    public static boolean isPrime(int num) {
    	if(num <= 1)
    		return false;
    	if(num == 2)
    		return true;
    	int upper = (int)Math.sqrt(num);
    	for(int i = 2; i <= upper; ++i) {
    		if(num % i == 0)
    			return false;
    	}
    	return true;
    }
}
