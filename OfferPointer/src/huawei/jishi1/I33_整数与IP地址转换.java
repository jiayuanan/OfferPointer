package huawei.jishi1;

/**
 * 2018年4月9日 @author jiayuanan
题目描述
原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
的每段可以看成是一个0-255的整数，需要对IP地址进行校验
输入描述:
输入 
1 输入IP地址
2 输入10进制型的IP地址

输出描述:
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址
 */
//思路：本题主要注意溢出问题，用int可能溢出
import java.util.Scanner;
public class I33_整数与IP地址转换 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String ip = scan.nextLine();
			String number = scan.nextLine();
			//处理ip地址
			String[] ips = ip.split("\\.");
			//System.out.println(ips[0]);
			Long ipToDouble = (Long.parseLong(ips[0]) << 24) + (Long.parseLong(ips[1]) << 16) + 
					          (Long.parseLong(ips[2]) << 8 )+  Long.parseLong(ips[3]) ; 
			//处理代表ip地址的数字
			Long num = Long.parseLong(number);
			long ipd = num % 256;
			long ipc = (num >> 8) % 256;
			long ipb = (num >> 16) % 256;
			long ipa = (num >> 24) % 256;
			
			System.out.println(ipToDouble);
			System.out.println(ipa + "." + ipb + "." + ipc + "." + ipd);
		}
		//System.out.println((255l << 24) + (3 <<8) +193);
	}
}
