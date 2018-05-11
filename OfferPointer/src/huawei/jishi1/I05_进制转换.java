package huawei.jishi1;



/**
 * 2018年4月7日 @author jiayuanan
题目描述
写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。

输出描述:
输出该数值的十进制字符串。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class I05_进制转换 {
	
	public static void converter(String str) {
		int result = 0;
		for(int i = 2; i < str.length(); ++i) {
			int num = 0;
			switch(str.charAt(i)) {
			case 'A':case 'B': case 'C':case 'D':case 'E':case 'F':num = str.charAt(i) - 'A' + 10;
			                                                        break;
			case 'a':case 'b': case 'c':case 'd':case 'e':case 'f':num = str.charAt(i) - 'a' + 10;
                                                                    break;
            default:
            	num = str.charAt(i) - '0';
            	break;		
			}
			
			result = result * 16 + num;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		List<String> numbers = new ArrayList<>();
		while(scan.hasNext()) {
			numbers.add(scan.next());
		}
		
		for(String s : numbers)
			converter(s);
		
	}

}
