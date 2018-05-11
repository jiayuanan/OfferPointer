package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����  
����Ҫ��:
1.���ȳ���8λ
2.������Сд��ĸ.����.��������,����������������
3.��������ͬ���ȳ�2���Ӵ��ظ�
˵��:���ȳ���2���Ӵ�
��������:
һ�����鳤�ȳ���2���ӷ�����ÿ��ռһ��
�������:
�������Ҫ�������OK���������NG
 */
//�����ѵ㡪���ַ���ƥ�䣬�����õı����������и�����ѭ��������Ҫ����
import java.io.*;
import java.util.*;
public class I20_����ϸ���֤���� {
	public static void main(String...args) {
		ArrayList<String> result = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String password = scan.nextLine();
			
			if(password.length() <= 8) {
				result.add("NG");
				continue;
			}
			
			int[] kinds = new int[4];
			for(int i = 0; i < password.length(); ++i) {
				char c = password.charAt(i);
				if(Character.isDigit(c))
					++kinds[2];
				else if (Character.isLowerCase(c))
					++kinds[1];
				else if (Character.isUpperCase(c))
					++kinds[0];
				else
					++kinds[3];
			}
			
			int num = 0;
			for(int i = 0; i < 4; ++i)
				if(kinds[i] > 0)
					++num;
			if(num < 3) {
				result.add("NG");
				continue;
			}
			boolean flag = true;
			for(int length = 3; length <= password.length() / 2; ++length ) {//ע�⣬��ʼlength��3������2
				for(int pos = 0; pos + length <= password.length(); ++pos) {
					if(password.substring(length+pos).contains(password.substring(pos, pos+length))) {
						flag = false;
						break;
					}
						
				}
				if(!flag)
					break;
			}
			if(flag)
				result.add("OK");
			else
				result.add("NG");
			
		}
		for(String s : result)
			System.out.println(s);
	}
}