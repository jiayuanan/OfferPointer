package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
��Ŀ����
��������ָһ������ƽ����β�����ڸ����������Ȼ�������磺25^2 = 625��76^2 = 5776��9376^2 = 87909376�������n���ڵ��������ĸ���

 */
import java.util.Scanner;
public class I99_������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	System.out.println(CalcAutomorphicNumbers(n));
        }
        scan.close();
    }
    //ת�����ַ������Ӵ�����
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
