package xiaozhan17;

/**
 * 2018��4��21�� @author jiayuanan
 * I14_������С��.java
 * 
 */
import java.util.*;
public class I14_������С��_______��ʽ�ֽ��ҹ���{
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
