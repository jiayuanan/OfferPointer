package huawei.jishi1;

import java.util.Scanner;

/**
 * 2018��4��7�� @author jiayuanan
 *��Ŀ������
�����ַ������һ�����ʵĳ��ȣ������Կո������ 
��������:
һ���ַ������ǿգ�����С��5000��
�������:
����N�����һ�����ʵĳ��ȡ�
 * 
 */
public class I01_�ַ������һ�����ʵĳ��� {
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		String str = san.nextLine();
		String[] strList = str.split(" ");
		System.out.println(strList[strList.length - 1].length());
	}
}


