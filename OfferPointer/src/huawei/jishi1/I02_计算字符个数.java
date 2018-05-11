package huawei.jishi1;



/**
 * 2018年4月7日 @author jiayuanan
题目描述
写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

输入描述:
输入一个有字母和数字以及空格组成的字符串，和一个字符。

输出描述:
输出输入字符串中含有该字符的个数。

说明：牛客网的测例很傻比，一输入是分两行给的，二不区分大小写
 * 
 */
import java.util.Scanner;
public class I02_计算字符个数 {
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

