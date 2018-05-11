package xiaozhan17;

/**
 * 2018年4月21日 @author jiayuanan
 * I14_饥饿的小易.java
 * 
 */
import java.util.*;
public class I14_饥饿的小易_______因式分解找规律{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 1; i < 10000; ++i) {
        	divide(i * 1000000007l + 1);
        }
        
        while(scan.hasNext()) {

        }
        scan.close();
    }
    
    public static void divide(long num) {
    	long up = (int) Math.sqrt(num);
    	for(long i = 4; i <= up; i <<= 1) {
    		if(num % i == 0)
    			System.out.println(num / i);
    	}
    }
}
