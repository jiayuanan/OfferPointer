package huawei.jishi1;



/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�������

��������:
����һ��int������

�������:
���մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�����
 * 
 */
import java.util.Scanner;
import java.util.TreeSet;
public class I09_��ȡ���ظ������� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//ʹ��set����Ѿ����ֹ�������������ת����String���в�����������
		String number = new Integer(num).toString();		
		TreeSet<Integer> set = new TreeSet<>();
		
		int result = 0;
		for(int i = number.length() - 1; i >= 0; --i) {
			
			if(!set.contains(number.charAt(i)-'0')) {
				result = result * 10 + number.charAt(i)-'0';
				set.add(number.charAt(i)-'0');
			}
		}
		System.out.println(result);
	}

}
