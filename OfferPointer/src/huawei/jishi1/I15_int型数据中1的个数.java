package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

输入描述:
 输入一个整数（int类型）

输出描述:
 这个数转换成2进制后，输出1的个数
 */
import java.util.Scanner;
public class I15_int型数据中1的个数 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		//将int型转化为二进制数组
		String str = Integer.toBinaryString(num);
		//System.out.println(str);
		int result = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == '1')
				++result;
		}
		
		System.out.println(result);

	}

}
