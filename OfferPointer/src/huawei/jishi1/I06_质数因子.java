package huawei.jishi1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2018年4月7日 @author jiayuanan
题目描述
功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
最后一个数后面也要有空格
详细描述：
函数接口说明：
public String getResult(long ulDataInput)
输入参数：
long ulDataInput：输入的正整数
返回值：
String
输入描述:
输入一个long型整数

输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 */
public class I06_质数因子 {
	
	public String getResult(long ulDataInput) {
		String result = "";
		
		ArrayList<Integer> primes = new ArrayList<>();
		while(ulDataInput > 1) {
			for(int i = 2; i <= ulDataInput; ++i) {  //注意，是<= ,不是<
				if(ulDataInput % i == 0) {
					primes.add(i);
					//System.out.println(i);
					ulDataInput /= i;
					break;
				}
			}
		}
		
		for(Integer i : primes)
			result = result + i + " ";
		
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(new I06_质数因子().getResult(scan.nextLong()));		

	}

}
