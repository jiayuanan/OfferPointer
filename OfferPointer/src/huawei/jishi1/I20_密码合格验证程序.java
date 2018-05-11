package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述  
密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串
输入描述:
一组或多组长度超过2的子符串。每组占一行
输出描述:
如果符合要求输出：OK，否则输出NG
 */
//本题难点——字符串匹配，这里用的笨方法里面有个二重循环跳出需要技巧
import java.io.*;
import java.util.*;
public class I20_密码合格验证程序 {
	public static void main(String...args) {
		ArrayList<String> result = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String password = scan.nextLine();
			
			if(password.length() <= 8) {
				result.add("NG");
				continue;
			}
			
			int[] kinds = new int[4];
			for(int i = 0; i < password.length(); ++i) {
				char c = password.charAt(i);
				if(Character.isDigit(c))
					++kinds[2];
				else if (Character.isLowerCase(c))
					++kinds[1];
				else if (Character.isUpperCase(c))
					++kinds[0];
				else
					++kinds[3];
			}
			
			int num = 0;
			for(int i = 0; i < 4; ++i)
				if(kinds[i] > 0)
					++num;
			if(num < 3) {
				result.add("NG");
				continue;
			}
			boolean flag = true;
			for(int length = 3; length <= password.length() / 2; ++length ) {//注意，初始length是3，不是2
				for(int pos = 0; pos + length <= password.length(); ++pos) {
					if(password.substring(length+pos).contains(password.substring(pos, pos+length))) {
						flag = false;
						break;
					}
						
				}
				if(!flag)
					break;
			}
			if(flag)
				result.add("OK");
			else
				result.add("NG");
			
		}
		for(String s : result)
			System.out.println(s);
	}
}