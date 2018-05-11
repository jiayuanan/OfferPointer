package chunzhao.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 2018��4��10�� @author jiayuanan
 * I3_�������.java
 * 
 */
class Main {
	//ģ��˷�����
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
	public static char[] add(char[] chars1, char[] chars2) {//chars2��һЩ
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
        while (scan.hasNext()) {//ע��while������case
        	//��ȡ����
        	String num1 = scan.nextLine();
        	String num2 = scan.nextLine();
        	
        	char[] bd1 = num1.toCharArray();
        	char[] bd2 = num2.toCharArray();
        	
        	char[] result = new char[bd1.length + bd2.length];
        	//�ֽ⣬һλһλ����ˡ����ֽ�bd2���ֱ�ȥ��bd1��������Ҫ������������
        	int yiweiFactor = 0;
        	for(int i = 0; i < bd2.length; ++i) {
        		char ch = bd2[i];
        		char[] res = multiply(bd1, ch);
        		res = yiwei(res, yiweiFactor);  //��λ����
        		++yiweiFactor;
        		result = add(result, res);
        	}
        	
        	System.out.println(result);

        }
        
        scan.close();
	}
}
public class I3_������� {

	//ģ��˷�����
	public static char[] multiply(char[] chars, char ch) {
		int jinwei = 0;
		int length = chars.length;
		int num1 = ch - '0';
		char[] result = new char[length + 1];//�����1λ
		for(int i = chars.length - 1; i >= 0; --i) {
			int num2 = chars[i] - '0';
			int res = num1 * num2 + jinwei;
			jinwei = res / 10;
			result[i + 1] = (char) (res % 10 + '0'); //ע���±�
		}
		result[0] = (char) (jinwei + '0');//ע���±�0�������λ
		//System.out.println(result);
		return result;
	}
	//ģ��ӷ�����
	public static char[] add(char[] result, char[] chars2) {//chars2��һЩ
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
		
		result[0] = (char) (jinwei + '0');   //ע���±�Ϊ0
		//System.out.println(result);
		return result;
	}
	//ģ����λ����
	public static char[] yiwei(char[] chars, int n) {
		//System.out.println(chars.length );
		
		char[] result = new char[chars.length + n];
		for(int i = 0; i < chars.length + n; ++i)
			result[i] = '0';  //��λȫ����ʼ��Ϊ0
		for(int i = n; i < chars.length + n; ++i)
			result[i] = chars[i-n];
		//System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//ע��while������case
        	//��ȡ����
        	char[] bd1 = scan.nextLine().toCharArray();
        	char[] bd2 = scan.nextLine().toCharArray();
        	
        
        	//ע���ʼ��
        	char[] result = new char[bd1.length + bd2.length];//�˻������λ��
        	for(int i = 0; i < result.length; ++i)
        		result[i] = '0';
        	//�ֽ⣬һλһλ����ˡ����ֽ�bd2���ֱ�ȥ��bd1��������Ҫ�����������㡪��һλ*��λ����λ��+
        	int yiweiFactor = 0;
        	for(int i = bd2.length - 1; i >= 0; --i) {
        		char ch = bd2[i];  //��ȡbd2��ĳһλ����
        		char[] res = multiply(bd1, ch);  //res��λ��Ҫ��bd1��һλ
        		char[] res1 = yiwei(res, yiweiFactor);  //��λ��������res1��res��λ����һ��һ��
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
        while (scan.hasNext()) {//ע��while������case
        	//��ȡ����
        	BigInteger bi1 = new BigInteger(scan.nextLine());
        	BigInteger bi2 = new BigInteger(scan.nextLine());

        	System.out.println(bi1.multiply(bi2));
        }
	}*/

}
