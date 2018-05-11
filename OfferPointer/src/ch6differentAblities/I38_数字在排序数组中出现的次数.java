package ch6differentAblities;

/**
 * 2018年3月26日 @author jiayuanan
 * item38:数字在排序数组中出现的次数
 * 问题描述：统计一个数字在排序数组中出现的次数。
 * 思路：使用二分查找，分别找到数字在数组中第一次和最后一次出现的位置
 */
class Solution38 {
    public int GetNumberOfK(int [] array , int k) {
    	if(array == null || array.length <= 0)
    		return 0;
        int length = array.length;
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
             return lastK - firstK + 1;
        }
        return 0;
    }
    //递归写法
    int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){  //左边的值=中间的值=所要找的值
            return getFirstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }
    //循环写法
    int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){ //右边的值=中间的值=所要找的值
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1; //找不到
    }
}
public class I38_数字在排序数组中出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,3,3,3,4,5,6,6,6,7,7,8,8,9,10};
		System.out.println(new Solution38().GetNumberOfK(array, 6));
	}

}
