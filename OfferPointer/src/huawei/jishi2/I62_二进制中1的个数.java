package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I62_��������1�ĸ���.java
 * 
 */
import java.util.*;
public class I62_��������1�ĸ���{
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
    		num = num &(num - 1); //��ȥ���ұߵ�1
    	}
    	return sum;
    }
}
