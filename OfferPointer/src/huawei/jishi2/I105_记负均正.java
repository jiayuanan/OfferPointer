package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
 * I105_�Ǹ�����.java
 * 
 */
import java.util.*;
public class I105_�Ǹ�����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
    	int evenCnt = 0; int oddCnt = 0;
    	float sum = 0f;
        while(scan.hasNext()) {  	
        	int num = scan.nextInt();
        	if(num < 0)
        		++evenCnt;
        	else {
        		sum += num;
        		++oddCnt;
        	}
        }
        System.out.println(evenCnt);
        if (oddCnt == 0)
        	System.out.println(0f);   //ע����0f��
        else 
        	System.out.printf("%.1f\n", sum /oddCnt); //ע�Ᵽ��һλС�����޴�����Ŀ
        
        scan.close();
    }
}