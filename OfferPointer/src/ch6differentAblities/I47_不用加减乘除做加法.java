package ch6differentAblities;

import java.math.BigInteger;

/**
 * 2018年3月26日 @author jiayuanan
 * item47: 不用加减乘除做加法
 */
class Solution47 {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;  //每位相加，不处理进位——即亦或
            num2 = (num1 & num2) << 1;  //处理进位，即并*2
            num1 = temp;   //迭代
        }
        return num1;
    }
}
public class I47_不用加减乘除做加法 {
	//使用大数
    public int Add(int num1,int num2) {
        BigInteger bi1=new BigInteger(String.valueOf(num1));
        BigInteger bi2=new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
