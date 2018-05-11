package huawei.jishi1;


/**
 * 2018年4月9日 @author jiayuanan
题目描述
Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
输入描述:
Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
输出描述:
Lily的所有图片按照从小到大的顺序输出
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class I34_图片整理_字符排序 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			char[] chars = line.toCharArray();
			//下面采用自定义的方法
			Character[] Chars = new Character[chars.length]; 
			for(int i = 0; i < chars.length; ++i)
				Chars[i] = chars[i];
			Arrays.sort(Chars, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
				
			});;;
			
			for(Character c: Chars)
				System.out.print(c);
			System.out.println();
		}
	}
}
