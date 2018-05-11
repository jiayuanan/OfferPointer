package offerpointer2;

/**
 * 2018年3月23日 @author jiayuanan
 * item29:数组中出现次数超过一半的数字
 * 问题描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *         例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
class Solution29 {
	//根据数组特性编写
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
        	return 0;
        if(array.length == 1)
        	return array[0];
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; ++i) {//注意，i从1开始
        	if(times == 0) {
        		result = array[i];
        	}
        	if(array[i] == result)
        		++times;
        	else
        		--times;
        }
        if(resultOK(result, array))
        	return result;
        else
        	return 0;
    }
    //使用快排的Partition函数编写 ???????????溢出
    public int MoreThanHalfNum(int[] array) {
        if(array == null || array.length == 0)
        	return 0;
        if(array.length == 1)
        	return array[0];
        int middle = array.length >> 1; //若存在满足要求的数，则在排序后的中间位置肯定为该数
        
        int start = 0; int end = array.length - 1;
        int index = Partition(array, start, end);
        while(index != middle) {
        	if(index > middle) {
        		end = index - 1;
        		index = Partition(array, start, end);
        	} else {
        		start = index + 1;
        		index = Partition(array, start, end);
        	}
        }
        int result = array[middle];
        if(resultOK(result, array))
        	return result;
        else
        	return 0;       
    }
    public int Partition(int[] array, int start, int end) {
    	int random = (start + end) / 2;
    	swap(array, random, end);
    	
    	int index = start;
    	for(int i = start; i <= end; ++i) {
    		if(array[i] < array[end]) {
    			if(i != index)
    				swap(array, i, index);
    			++index;
    		}
    			
    	}
    	swap(array, index, end);
    	return index;
    }
    public void swap(int[] array, int random, int end) {
    	int temp = array[random];
    	array[random] = array[end];
    	array[end] = temp;
    }
    public boolean resultOK(int result, int[] array) {
    	boolean isOkay = false;
    	int frequency = 0;
    	for(int i = 0; i < array.length; ++i)
    		if(array[i] == result)
    			++frequency;
    	if(frequency * 2 > array.length)
    		isOkay = true;
    	return isOkay;
    			
    }
}
public class I29_数组中出现次数超过一半的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2,2};
		System.out.println(new Solution29().MoreThanHalfNum(array));
	}

}
