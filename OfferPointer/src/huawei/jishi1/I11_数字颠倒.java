package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
������
����һ��������������������ַ�������ʽ�������
���򲻿��Ǹ���������������ֺ���0����������ʽҲ����0��������Ϊ100�������Ϊ001
��������:
����һ��int����
�������:
������������ַ�������ʽ�������
 */
import java.util.Scanner;
public class I11_���ֵߵ� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		StringBuilder sb = new StringBuilder(new Integer(num).toString());
		System.out.println(sb.reverse().toString());

	}

}
