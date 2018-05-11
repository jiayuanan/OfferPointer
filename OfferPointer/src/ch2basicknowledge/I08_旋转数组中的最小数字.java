package ch2basicknowledge;


/**item8: 旋转数组中的最小数字  2018.03.20
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。  
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
class Solution8 {
    public int minNumberInRotateArray(int [] array) throws InterruptedException {
    	if(array == null)
    		return 0;
    	int start = 0; 
    	int end = array.length - 1;
    	int mid = start;
    	
    	//迭代过程
    	while(array[start] >= array[end]) {
    		//退出条件
    		if(end - start == 1) {  //开始写成 start - end 了，调试了半天
    			mid = end;
    			break;
    		}
    		//二分查找——注意特例情形
    		mid = (start + end) / 2;
    		if(array[start] == array[end] && array[start] == array[mid]) 
    			return seqSort(array, start, end);
    		if(array[mid] >= array[start])
    			start = mid;
    		else if (array[mid] <= array[end])
    			end = mid;
    		
    	}
    	return array[mid];
    	
    }
    
    //顺序查找
    public int seqSort(int[] array, int start, int end) {
    	int min = array[start];
    	for(int index = start; index < end; ++index) {
    		if(array[index] < min)
    			min = array[index];
    	}
    	return min;
    }
}


public class I08_旋转数组中的最小数字 {
	public static void main(String...args) throws InterruptedException {
		int[] array = {4,5,6,7,1,2,3};
		int[] array1 = {1,0,1,1,1,1,1};
		int[] array2 = {3,4,5,1,2};
		System.out.println(new Solution8().minNumberInRotateArray(array1));
	}

}
