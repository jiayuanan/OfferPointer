package huawei.jishi1;



/**
 * 2018年4月8日 @author jiayuanan
题目描述
输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

输入描述:
输入一个int型整数

输出描述:
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 
 */
import java.util.Scanner;
import java.util.TreeSet;
public class I09_提取不重复的整数 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//使用set存放已经出现过的数。。将数转化成String进行操作，更方便
		String number = new Integer(num).toString();		
		TreeSet<Integer> set = new TreeSet<>();
		
		int result = 0;
		for(int i = number.length() - 1; i >= 0; --i) {
			
			if(!set.contains(number.charAt(i)-'0')) {
				result = result * 10 + number.charAt(i)-'0';
				set.add(number.charAt(i)-'0');
			}
		}
		System.out.println(result);
	}

}
