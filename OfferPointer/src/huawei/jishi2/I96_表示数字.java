package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
输入描述:
输入一个字符串
输出描述:
字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 */
import java.util.Scanner;
public class I96_表示数字{
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
