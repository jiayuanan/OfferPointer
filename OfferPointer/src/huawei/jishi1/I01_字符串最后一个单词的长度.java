package huawei.jishi1;

import java.util.Scanner;

/**
 * 2018年4月7日 @author jiayuanan
 *题目描述：
计算字符串最后一个单词的长度，单词以空格隔开。 
输入描述:
一行字符串，非空，长度小于5000。
输出描述:
整数N，最后一个单词的长度。
 * 
 */
public class I01_字符串最后一个单词的长度 {
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		String str = san.nextLine();
		String[] strList = str.split(" ");
		System.out.println(strList[strList.length - 1].length());
	}
}


