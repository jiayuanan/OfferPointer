package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����ڷ�Χ�ڵĲ���ͳ�ơ�

��������:
����N���ַ����ַ���ACSII�뷶Χ�ڡ�

�������:
�����Χ��(0~127)�ַ��ĸ�����
 */
import java.util.Scanner;
public class I10_�ַ�����ͳ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] charsets= new int[128];
		Scanner scan = new Scanner(System.in);
		
		//��ȡ�ַ���������
		while(scan.hasNext()) {
			String temp = scan.nextLine();
			for(int i = 0; i < temp.length(); ++i) {
				char c = temp.charAt(i);
				if(c >= 0 && c <= 127)
					++charsets[c];
			}
		}
		//����result
		int result = 0;
		for(int i = 0; i < 128; ++i) {
			if(charsets[i] > 0)
				++result;
		}

		System.out.println(result);
	}

}
