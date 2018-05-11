package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * I17_��Fibonacci��������ľ���.java
 * 
 */
//�������뷶Χ��С��ֱ��ʹ��һ��������Fֵ����
import java.util.*;
public class I17_��Fibonacci��������ľ���{
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
