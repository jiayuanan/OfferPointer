package huawei.jishi1;


/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
Lily�Ͽ�ʱʹ����ĸ����ͼƬ��С������ѧϰӢ�ﵥ�ʣ�ÿ�ζ���Ҫ����ЩͼƬ���մ�С��ASCII��ֵ��С���������պá����Ҹ�Lily��æ��ͨ��C���Խ����
��������:
Lilyʹ�õ�ͼƬ����"A"��"Z"��"a"��"z"��"0"��"9"��������ĸ�����ָ���������1024��
�������:
Lily������ͼƬ���մ�С�����˳�����
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class I34_ͼƬ����_�ַ����� {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			char[] chars = line.toCharArray();
			//��������Զ���ķ���
			Character[] Chars = new Character[chars.length]; 
			for(int i = 0; i < chars.length; ++i)
				Chars[i] = chars[i];
			Arrays.sort(Chars, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
				
			});;;
			
			for(Character c: Chars)
				System.out.print(c);
			System.out.println();
		}
	}
}
