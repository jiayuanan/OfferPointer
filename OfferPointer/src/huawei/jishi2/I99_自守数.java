package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
题目描述
自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数

 */
import java.util.Scanner;
public class I99_自守数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	System.out.println(CalcAutomorphicNumbers(n));
        }
        scan.close();
    }
    //转化成字符串，子串问题
    public static int CalcAutomorphicNumbers( int n) {
    	int sum = 0;
    	for(int i = 0; i <= n; ++i) {
    		Integer square = i * i;
    		String s = square.toString();
    		Integer ii = i;
    		String I = ii.toString();
    		if(s.substring(s.length() - I.length()).equals(I))
    			++sum;
    	}
    	
    	
    	return sum;
    	
    }
}
