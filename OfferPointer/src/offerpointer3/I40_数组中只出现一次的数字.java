package offerpointer3;



/**
 * 2018年3月26日 @author jiayuanan
 * item40:数组中只出现一次的数字
 * 问题描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
class Solution40 {
	/**
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
     */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        //一个数与其本身亦或得0
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        //找到异或结果中从右到左中第一个非0的，其位置为index
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) 
            	break;
        }
        //以index那位为0/1为准，将数分为2波。分别求解
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
/**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     */
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }
/**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     */
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }

}

public class I40_数组中只出现一次的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new Solution40().findNumsAppearOnce(array, num1, num2);
	}

}
