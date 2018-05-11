package huawei.jishi1;


/**
 * 2018年4月8日 @author jiayuanan
题目描述
给定n个字符串，请对n个字符串按照字典序排列。
输入描述:
输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
输出描述:
数据输出n行，输出结果为按照字典序排列的字符串。 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class I14_字符串的连接最长路径查找 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> strArr = new ArrayList<>();
		
		while(scan.hasNext()) {
			int num = scan.nextInt();
			
			for(int i = 0; i < num; ++i) {
				strArr.add(scan.next());
			}
		}
		//自定义Comparator
		Collections.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}		
		});
		
		for(String s : strArr)
			System.out.println(s);

	}

}
