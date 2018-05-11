package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。

输入描述:
输入N个字符，字符在ACSII码范围内。

输出描述:
输出范围在(0~127)字符的个数。
 */
import java.util.Scanner;
public class I10_字符个数统计 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] charsets= new int[128];
		Scanner scan = new Scanner(System.in);
		
		//读取字符串并计数
		while(scan.hasNext()) {
			String temp = scan.nextLine();
			for(int i = 0; i < temp.length(); ++i) {
				char c = temp.charAt(i);
				if(c >= 0 && c <= 127)
					++charsets[c];
			}
		}
		//计算result
		int result = 0;
		for(int i = 0; i < 128; ++i) {
			if(charsets[i] > 0)
				++result;
		}

		System.out.println(result);
	}

}
