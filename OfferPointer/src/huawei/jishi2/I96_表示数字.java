package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
��������:
����һ���ַ���
�������:
�ַ������г��ֵ�����ǰ����Ϸ��š�*���������ַ����ֲ���
 */
import java.util.Scanner;
public class I96_��ʾ����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String s = scan.nextLine();
        	int sumOfNumStr = 0;
        	for(int i = 0; i < s.length(); ++i) {
        		char ch = s.charAt(i);
        		if(!Character.isDigit(ch))
        			continue;
        		else {
        			++ sumOfNumStr;
        			while(i < s.length()) {
        				if(Character.isDigit(s.charAt(i)))
        					++i;
        				else
        					break;
        			}
        		}
        	}
        	char[] str = new char[s.length() + 2 * sumOfNumStr];
        	
        	System.out.println(sumOfNumStr);
        }
        scan.close();
    }
}
