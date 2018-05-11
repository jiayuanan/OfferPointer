package ch2basicknowledge;

/**
 * 2018年3月20日 @author jiayuanan
 * item12:打印1到最大的N位数
 * 思路：考虑到n可以很大，所以采用数组/字符串模拟数字
 * 字符串——剑指offerP95； 全排列——剑指offerP97
 */
public class I12_打印1到最大的N位数 {

	public void print(int n) {
		if(n <= 0)
			return;
		int[] number = new int[n];
		
		while(!isLast(number)) {  //结束判断
			increase(number);    //模拟加1操作
			printNumber(number); //打印该数
		}
	
	}
	//判断是否为最大的N位数
	boolean isLast(int[] number) {
		for(int index = 0; index < number.length; ++ index) {
			if(number[index] != 9)
				return false;
		}
		return true;
	}
	//打印一个数
	static void printNumber(int[] number) {
		for(int index = 0; index < number.length; ++ index) {
			//找到从大到小第一个非零位，从那位开始打印——不用考虑纯零的情形
			if(number[index] == 0)
				continue;
			else {
				printNumberRest(number, index, number.length); //开始没加break语句，bug
				break;
			}
				
			
		}
	}
	static void printNumberRest(int[] number, int start, int end) {
		for(int index = start; index < end; ++index) {  //变量定义多了，也容易混淆
			System.out.print(number[index]);
		}
		System.out.println();
	}
	
	void increase(int[] number) {
		int digit = number.length;
		//针对进1特点进行设计——难点在于不确定数的实际位数，无法使用if和switch语句
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = { 0,0,1,2};
		printNumber(number);
	}

}
