package huawei.jishi1;



/**
 * 2018��4��7�� @author jiayuanan
��Ŀ����
д��һ�����򣬽���һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��

��������:
����һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���

�������:
��������ַ����к��и��ַ��ĸ�����

˵����ţ�����Ĳ�����ɵ�ȣ�һ�����Ƿ����и��ģ��������ִ�Сд
 * 
 */
import java.util.Scanner;
public class I02_�����ַ����� {
	public static void main(String...args) {
		Scanner san = new Scanner(System.in);
		String s = san.next().toLowerCase();
		char c = san.next().toLowerCase().charAt(0);
		
		int result = 0;
		for(int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == c)
				++result;
		}
		
		System.out.println(result);
	}

}

