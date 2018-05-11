package offerpointer1;

/**
 * 2018年3月20日 @author jiayuanan
 * item10:二进制中1的个数
 * 描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 关联题：item40,47
 * 思路：一位一位的比，进行按位与运算； 陷阱——若对数进行移位可能会陷入死循环，改为对位运算的数移位即可
 */


class Solution10 {
    public int NumberOf1(int n) {
    	int op = 1;
    	int result = 0;
    	while(op != 0) {
    		if((op & n) == op)   //右侧应该是op，开始错写为1, 也可为 ！=0
    			++result;
    		op <<= 1;
    	}
    	
    	return result;
    }
}

public class I10_进制中1的个数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution10().NumberOf1(7));
	}

}
