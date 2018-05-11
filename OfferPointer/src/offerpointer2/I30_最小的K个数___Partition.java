package offerpointer2;



/**
 * 2018年3月23日 @author jiayuanan
 * item30:最小的K个数
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k <= 0)
        	return result;
        
        int start = 0; int end = input.length - 1;
        int index = Partition(input, start, end);
        while(index != k - 1) { //注意是k-1
        	if(index > k - 1) {
        		end = index - 1; //注意，赋值操作不可省略！！！
        		index = Partition(input, start, end);
        	}
        		
        	else {
        		start = index + 1;
        		index = Partition(input, start, end);
        	}
        		
        }

        for(int i = 0; i < k; ++i)
        	result.add(input[i]);
        Collections.sort(result);
        return result;
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
    public void swap(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}

//解法二——使用最大堆，特别适合于大数据
class MaxHeapSolution {
	   public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
	       ArrayList<Integer> result = new ArrayList<Integer>();
	       int length = input.length;
	       if(k > length || k == 0){
	           return result;
	       }
	       //最大堆实现
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
	 
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                return o2.compareTo(o1);
	            }
	        });
	        for (int i = 0; i < length; i++) {
	            if (maxHeap.size() != k) {
	                maxHeap.offer(input[i]);
	            } else if (maxHeap.peek() > input[i]) {
	                Integer temp = maxHeap.poll();
	                temp = null;
	                maxHeap.offer(input[i]);
	            }
	        }
	        for (Integer integer : maxHeap) {
	            result.add(integer);
	        }
	        return result;
	    }
	}
public class I30_最小的K个数___Partition {
	public static void main(String...args) {
		int[] input = {1,2,3,4,5,6,7,8};
		System.out.println(new Solution30().GetLeastNumbers_Solution(input, 2));
	}
}
