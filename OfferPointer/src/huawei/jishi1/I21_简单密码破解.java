package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
���������������зǳ���Ҫ�Ķ��������ǵ���ôһ�㲻��˵�����ܾ�ȫ�����ˡ��۹���. ������Ԩ��Ҫ������֮���ټ�һ�����룬��Ȼ�򵥵�Ҳ��ȫ��
����Ԩ��ԭ��һ��BBS�ϵ�����Ϊzvbo9441987,Ϊ�˷�����䣬��ͨ��һ���㷨���������任��YUANzhi1987��
����������������ֺͳ�����ݣ���ô���������ˣ����ҿ�����Ŀ�ŵ��ط������۵ĵط�����������֪�����������롣
������ô�任�ģ���Ҷ�֪���ֻ��ϵ���ĸ�� 1--1�� abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
����ô�򵥣�Ԩ�Ӱ������г��ֵ�Сд��ĸ����ɶ�Ӧ�����֣����ֺ������ķ��Ŷ������任��
������������û�пո񣬶������г��ֵĴ�д��ĸ����Сд֮��������һλ���磺X���ȱ��Сд����������һλ��������y����򵥰ɡ���ס��z��������aŶ��
��������:
�����������������ݡ�������һ�����ģ����볤�Ȳ�����100���ַ�������ֱ���ļ���β
�������:
���Ԩ������������
 */
import java.util.Scanner;
public class I21_�������ƽ� {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String mingwen = scan.nextLine();
			char[] miwen = new char[mingwen.length()];
			
			for(int i = 0; i < mingwen.length(); ++i) {
				char c = mingwen.charAt(i);
				if(Character.isDigit(c)) {
					miwen[i] = c;
				} else if (Character.isLowerCase(c)) {
					switch(c) {
					case 'a': case 'b':case 'c': miwen[i] = '2'; break;
					case 'd': case 'e':case 'f': miwen[i] = '3'; break;
					case 'g': case 'h':case 'i': miwen[i] = '4'; break;
					case 'j': case 'k':case 'l': miwen[i] = '5'; break;
					case 'm': case 'n':case 'o': miwen[i] = '6'; break;
					case 'p': case 'q':case 'r':case 's': miwen[i] = '7'; break;
					case 't': case 'u':case 'v': miwen[i] = '8'; break;
					case 'w': case 'x':case 'y':case 'z': miwen[i] = '9'; break;
					}
				} else {
					if(new Character('Z').equals(c))
						miwen[i] = 'a';
					else
						miwen[i] = (char) (Character.toLowerCase(c) + 1);
				}
			}
			
			System.out.println(new String(miwen));
		}
	}
}
