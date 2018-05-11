package huawei.jishi1;



/**
 * 2018�?4�?7�? @author jiayuanan
题目描述
•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组�? 
•长度不�?8整数倍的字符串请在后面补数字0，空字符串不处理�? 
输入描述:
连续输入字符�?(输入2�?,每个字符串长度小�?100)
输出描述:
输出到长度为8的新字符串数�? 
 */
import java.util.Collections;
import java.util.Scanner;
public class I04_separateStrings {

	public static void print(String str) {
		int length = str.length();
		
		int yushu = length % 8;
		str = str + str.join("", Collections.nCopies((8-yushu)%8, "0"));
		for(int i = 0; i < str.length(); i += 8) {
			System.out.println(str.substring(i, i + 8));  //注意边界为i+8
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		print(s1);
		print(s2);

	}

}
