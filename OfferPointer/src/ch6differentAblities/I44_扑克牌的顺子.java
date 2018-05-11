package ch6differentAblities;



/**
 * 2018年3月26日 @author jiayuanan
 * item44：扑克牌的顺子
 * 问题描述：从一副扑克牌抽5张牌，判断是不是一个顺子——一个56张牌，包括2个大王和2个小王。大小王可以为任意牌。大小王为0.
 */
import java.util.Arrays;
class Solution44 {
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length != 5)
    		return false;
    	Arrays.sort(numbers);    //1.排序
    	int cntOfZeros = cntZeros(numbers);//2.计算0的个数
    	//System.out.println(cntOfZeros);
    	int distance = 0;  //3.计算间隔的总距离
    	for(int index = cntOfZeros + 1; index < numbers.length; ++index) {
    		if(numbers[index] == numbers[index - 1])
    			return false;  //存在对子，肯定不是顺子
    		else
    			distance += numbers[index] - numbers[index - 1] - 1; //注意，这里算distance要先减去1个1
    	}
    	
    	if(cntOfZeros >= distance)
    		return true;
    	else
    		return false;
    }
    
    public int cntZeros(int[] numbers) {
    	int result = 0;
    	for(int i = 0; i < numbers.length; ++i) {
    		if(numbers[i] == 0)
    			++result;
    		else
    			break;
    	}
    	return result;
    }
}
public class I44_扑克牌的顺子 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,6,0,0,7};
		System.out.println(new Solution44().isContinuous(numbers));

	}

}
