package offerpointer1;

/**
 * 2018年3月20日 @author jiayuanan
 * 题目：item11——数值的整数次方
 * 描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 思路：分数幂，也可以使用位运算
 */

class Solution11 {
    public double Power(double base, int exponent) {
    	boolean negtive = false;  //针对幂为负数的情况
    	//基本情形
    	if(exponent == 0)
    		return 1;
    	if(exponent == 1) 
    		return base;
    	//负数处理
    	if(exponent < 0) {
    		exponent = - exponent;
    		negtive = true;
    	}
    	//正式计算，递归方式
    	double result = 1;
		if((exponent & 1) == 0)
			result = Power(base, exponent >> 1) * Power(base, exponent >> 1);
		else
			result = base * Power(base, exponent -1);
    	
    	if(negtive)
    		result = 1 / result;
    	return result;
        
  }
}


public class I11_数值的整数次方 {
	public static void main(String...args) {
		System.out.println(new Solution11().Power(2, 6));
		System.out.println((1<<31)-1);
		System.out.println((1l<<63)-1);
	}
}
