package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
输入描述:
输入N个字符

输出描述:
输出该字符串反转后的字符串
 */
import java.util.Scanner;
public class I12_字符串反转 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse().toString());

	}

}
