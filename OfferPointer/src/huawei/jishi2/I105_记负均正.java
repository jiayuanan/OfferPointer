package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
 * I105_记负均正.java
 * 
 */
import java.util.*;
public class I105_记负均正{
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
        	System.out.println(0f);   //注意是0f；
        else 
        	System.out.printf("%.1f\n", sum /oddCnt); //注意保留一位小数，愚蠢的题目
        
        scan.close();
    }
}