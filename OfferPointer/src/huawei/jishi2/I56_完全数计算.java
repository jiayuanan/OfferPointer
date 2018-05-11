package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
��Ŀ����
��ȫ����Perfect number�����ֳ����������걸������һЩ�������Ȼ����
�����е������ӣ����������������Լ�����ĺͣ������Ӻ�������ǡ�õ���������
���磺28������Լ��1��2��4��7��14��28����ȥ������28�⣬����5������ӣ�1+2+4+7+14=28��
��������count(int n),���ڼ���n����(��n)��ȫ���ĸ��������㷶Χ, 0 < n <= 500000
����n������ȫ���ĸ����� �쳣�������-1
 */
import java.util.*;
public class I56_��ȫ������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	System.out.println(count(num));
        }
        scan.close();
    }
    
    public static int count(int n) {
    	if(n <= 1)
    		return 0;
    	int sum = 0;
    	//��2��ʼ��
    	for(int i = 2; i <= n; ++i) {
    		if(isPerfect(i))
    			++sum;
    	}
    	
    	return sum;
    }
    
    public static boolean isPerfect(int m) {
    	int upper = (int) Math.sqrt(m);
    	int sum = 1;   //�ȼӸ�1
    	for(int i = 2; i <= upper; ++i) {//����С�ڻ�����©
    		if(m % i == 0) {
    			sum += i + m/i;
    		}
    	}
    	if(upper * upper == m)
    		sum -= upper;  //������ܼ�2��
    	
    	return sum == m;
    }
}
