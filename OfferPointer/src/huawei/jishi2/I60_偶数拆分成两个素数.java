package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I60_ż����ֳ���������.java
 * 
 */
import java.util.Scanner;
public class I60_ż����ֳ���������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	//���������϶�������������2���У����������ԡ������м���������ɢ
        	int mid = num / 2;
        	int realMid = mid % 2 == 1 ? mid : mid - 1;//ȡ����
        	while(true) {
        		//System.out.println(realMid);
        		if(isPrime(realMid) && isPrime(num - realMid)) {
        			System.out.println(realMid);
        			System.out.println(num - realMid);
        			break;
        		} else {
        			realMid -= 2; //2��2���ĵݼ�
        		}
        	}
        	
        }
        scan.close();
    }
    
    public static boolean isPrime(int num) {
    	if(num <= 1)
    		return false;
    	if(num == 2)
    		return true;
    	int upper = (int)Math.sqrt(num);
    	for(int i = 2; i <= upper; ++i) {
    		if(num % i == 0)
    			return false;
    	}
    	return true;
    }
}
