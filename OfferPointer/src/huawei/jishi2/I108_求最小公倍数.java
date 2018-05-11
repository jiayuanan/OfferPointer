package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
 * ��С������ = ����֮���������Լ��
 * 
 */
import java.util.Scanner;
public class I108_����С������{
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
    		big = small;  //�ҿ�ʼ��Ȼ�õ��� - ������ %
    		small = temp;
    	}
    	
    	return small;
    }
}
