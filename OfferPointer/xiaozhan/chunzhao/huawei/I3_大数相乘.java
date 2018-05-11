package chunzhao.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 2018年4月10日 @author jiayuanan
 * I3_大数相乘.java
 * 
 */
class Main {
	//模拟乘法运算
	public static char[] multiply(char[] chars, char ch) {
		int jinwei = 0;
		int length = chars.length;
		char[] result = new char[length + 1];
		for(int i = 0; i < length; ++i) {
			int num1 = ch - '0';
			int num2 = chars[i] - '0';
			int res = num1 * num2 + jinwei;
			jinwei = res / 10;
			result[i] = (char) (res % 10 + '0');
		}
		result[length] = (char) (jinwei + '0');
		return result;
	}
	public static char[] add(char[] chars1, char[] chars2) {//chars2短一些
		int jinwei = 0;
		int length = chars2.length;
		for(int i = 0; i < length; ++i) {
			int num1 = chars1[i] - '0';
			int num2 = chars2[i] - '0';
			int res = num1 + num2 + jinwei;
			jinwei = res / 10;
			chars1[i] = (char) (res % 10 + '0');
		}
		chars1[length] = (char) (jinwei + '0');
		return chars1;
	}
	public static char[] yiwei(char[] chars, int n) {
		char[] result = new char[chars.length + n];
		for(int i = 0; i < n; ++i)
			result[i] = '0';
		for(int i = n; i < result.length; ++i) {
			result[i] = chars[i-n];
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//注意while处理多个case
        	//读取数据
        	String num1 = scan.nextLine();
        	String num2 = scan.nextLine();
        	
        	char[] bd1 = num1.toCharArray();
        	char[] bd2 = num2.toCharArray();
        	
        	char[] result = new char[bd1.length + bd2.length];
        	//分解，一位一位的相乘——分解bd2，分别去乘bd1。这里需要定义两个运算
        	int yiweiFactor = 0;
        	for(int i = 0; i < bd2.length; ++i) {
        		char ch = bd2[i];
        		char[] res = multiply(bd1, ch);
        		res = yiwei(res, yiweiFactor);  //移位操作
        		++yiweiFactor;
        		result = add(result, res);
        	}
        	
        	System.out.println(result);

        }
        
        scan.close();
	}
}
public class I3_大数相乘 {

	//模拟乘法运算
	public static char[] multiply(char[] chars, char ch) {
		int jinwei = 0;
		int length = chars.length;
		int num1 = ch - '0';
		char[] result = new char[length + 1];//结果多1位
		for(int i = chars.length - 1; i >= 0; --i) {
			int num2 = chars[i] - '0';
			int res = num1 * num2 + jinwei;
			jinwei = res / 10;
			result[i + 1] = (char) (res % 10 + '0'); //注意下标
		}
		result[0] = (char) (jinwei + '0');//注意下标0代表最高位
		//System.out.println(result);
		return result;
	}
	//模拟加法运算
	public static char[] add(char[] result, char[] chars2) {//chars2短一些
		//System.out.println(chars2);
		//System.out.println(result);
		int jinwei = 0;
		int length = chars2.length;
		for(int i = length - 1; i >= 0; --i) {
			int num1 = result[i] - '0';
			int num2 = chars2[i] - '0';
			int res = num1 + num2 + jinwei;
			jinwei = res / 10;
			result[i] = (char) (res % 10 + '0');
		}
		
		result[0] = (char) (jinwei + '0');   //注意下标为0
		//System.out.println(result);
		return result;
	}
	//模拟移位运算
	public static char[] yiwei(char[] chars, int n) {
		//System.out.println(chars.length );
		
		char[] result = new char[chars.length + n];
		for(int i = 0; i < chars.length + n; ++i)
			result[i] = '0';  //各位全部初始化为0
		for(int i = n; i < chars.length + n; ++i)
			result[i] = chars[i-n];
		//System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//注意while处理多个case
        	//读取数据
        	char[] bd1 = scan.nextLine().toCharArray();
        	char[] bd2 = scan.nextLine().toCharArray();
        	
        
        	//注意初始化
        	char[] result = new char[bd1.length + bd2.length];//乘积的最大位数
        	for(int i = 0; i < result.length; ++i)
        		result[i] = '0';
        	//分解，一位一位的相乘——分解bd2，分别去乘bd1。这里需要定义三个运算——一位*多位；移位；+
        	int yiweiFactor = 0;
        	for(int i = bd2.length - 1; i >= 0; --i) {
        		char ch = bd2[i];  //获取bd2上某一位的数
        		char[] res = multiply(bd1, ch);  //res的位数要比bd1多一位
        		char[] res1 = yiwei(res, yiweiFactor);  //移位操作——res1和res的位数不一定一样
        		++yiweiFactor;
        		//System.out.println(res1.length);
        		//System.out.println(res1);
        		result = add(result, res1);
        	}
        	boolean firstZeros = true;
        	for(int i = 0; i < result.length; ++i) {
        		char ch = result[i];
        		if(firstZeros) {
        			if(ch == '0')
        				continue;
        			else {
        				firstZeros = false;
        				System.out.print(ch);
        			}
        		} else {
        			System.out.print(ch);
        		}
        	}
        	System.out.println();

        }
        
        scan.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//注意while处理多个case
        	//读取数据
        	BigInteger bi1 = new BigInteger(scan.nextLine());
        	BigInteger bi2 = new BigInteger(scan.nextLine());

        	System.out.println(bi1.multiply(bi2));
        }
	}*/

}
