package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
����һ��int�͵����������������int���������ڴ��д洢ʱ1�ĸ�����

��������:
 ����һ��������int���ͣ�

�������:
 �����ת����2���ƺ����1�ĸ���
 */
import java.util.Scanner;
public class I15_int��������1�ĸ��� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		//��int��ת��Ϊ����������
		String str = Integer.toBinaryString(num);
		//System.out.println(str);
		int result = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == '1')
				++result;
		}
		
		System.out.println(result);

	}

}
