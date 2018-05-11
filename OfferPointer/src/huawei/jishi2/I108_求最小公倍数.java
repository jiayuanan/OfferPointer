package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
 * 最小公倍数 = 两数之积除以最大公约数
 * 
 */
import java.util.Scanner;
public class I108_求最小公倍数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int first = scan.nextInt();
        	int second = scan.nextInt();
        	
        	int publicFactor = maxPublicFactor(first, second);
        	System.out.println(first * second / publicFactor);
        }
        scan.close();
    }
    
    public static int maxPublicFactor(int m, int n) {
    	if(m == n)
    		return m;
    	int big = m > n ? m : n;
    	int small = m < n ? m : n;
    	while(big % small != 0) {
    		int temp = big % small;
    		big = small;  //我开始竟然用的是 - 而不是 %
    		small = temp;
    	}
    	
    	return small;
    }
}
