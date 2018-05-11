package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
描述：
输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
输入描述:
输入一个int整数
输出描述:
将这个整数以字符串的形式逆序输出
 */
import java.util.Scanner;
public class I11_数字颠倒 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		StringBuilder sb = new StringBuilder(new Integer(num).toString());
		System.out.println(sb.reverse().toString());

	}

}
