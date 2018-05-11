package offerpointer3;



/**
 * 2018年3月27日 @author jiayuanan
 * item65:滑动窗口的最大值
 * 问题描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 *         那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *          {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.ArrayList;
class Solution65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(num == null || num.length == 0 || size > num.length)
        	return result;
        
        int max0 = max(num, 0, size - 1);
        result.add(max0);
        
        int lasting = size ; //最大值的持续时间
        for(int i = size - 1; i >=0 ; --i) {
        	if(num[i] == max0) {
        		lasting = i; //初始的lasting一定要计算，等于最大值的位置
        		break;
        	}
        		
        }
        
        for(int i = size; i < num.length; ++i) {
        	if(num[i] > max0) {
        		max0 = num[i];
        		lasting = size;
        	} else {
        		if(lasting == 0) {
        			max0 = max(num, i - size + 1, i);  
        			lasting = calculateLasting(num, i - size + 1, i);
        		}   
        		--lasing;
        	}
        		
        	result.add(max0);
        }
        
        return result;
        
    }
    
    public int max(int[] num, int start, int end) {
    	int result = num[start];
    	for(int i = start; i <= end; ++i)
    		if(num[i] > result)
    			result = num[i];
    	return result;
    }

    public int calculateLasting(int[] num, int start, int end) {
    	int result = num[end];
        int lasting = size ; //最大值的持续时间
        for(int i = size - 1; i >=0 ; --i) {
        	if(num[i] == max0) {
        		lasting = i; //初始的lasting一定要计算，等于最大值的位置
        		break;
        	}
    }
}
public class I65_maxValueWithSlide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {16,14,12,10,8,6,4};
		System.out.println(new Solution65().maxInWindows(num, 5));
	}

}
