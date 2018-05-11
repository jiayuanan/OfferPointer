package offerpointer1;

/**
 * 2018年3月20日 @author jiayuanan
 * item14:调整数组顺序使奇数位于偶数前面
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
class Solution14 {
    public void reOrderArray(int [] array) {
    	//创建一个新数组充填数据
        int[] result = new int[array.length];
        //设置2个位置浮标分别用来进行奇偶操作
        int odd = 0; 
        int even = result.length - 1;
        //整理奇数
        for(int index = 0; index < array.length; ++index) {
        	if((array[index] & 1) == 1) 
        		result[odd++] = array[index];
        }
        //整理偶数
        for(int index = array.length -1; index >= 0; --index) {
        	if((array[index] & 1) == 0)
        		result[even--] = array[index];
        }
        
        //array = result;   //这样是不行的
        
        for(int i = 0; i < array.length; ++i) {
        	array[i] = result[i];
        }
    }
}

public class I14_调整数组顺序使奇数位于偶数前面 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		new Solution14().reOrderArray(array);
	}

}
