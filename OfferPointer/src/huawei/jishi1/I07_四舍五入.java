package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
输入描述:
输入一个正浮点数值
输出描述:
输出该数值的近似整数值 
 */
import java.util.Scanner;
public class I07_四舍五入 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long result = (long) (scan.nextDouble() + 0.5); //注意，以防万一，类型设为long和double
		System.out.println(result);

	}

}
