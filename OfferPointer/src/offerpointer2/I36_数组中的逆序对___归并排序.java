package offerpointer2;

/**
 * 2018年3月26日 @author jiayuanan
 * item36:数组中的逆序对
 * 问题描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *         输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 思路：使用归并排序去计数逆序对
 */
//解题中的4个取余，一个不能少
class Solution36 {
    public static int InversePairs(int[] array) {
        if(array == null || array.length <= 0)
        	return 0;
        // 创建辅助数组
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length); //复制数组
        int numberOfInversePairs = InversePairs(array, copy, 0, length - 1);
        
        int result = numberOfInversePairs % 1000000007;

        return result;

    }

    //array 未归并数组  copy 用于存储归并后数据的数组  begin 起始位置 end 结束位置  逆序数
    public static int InversePairs(int[] array, int[] copy, int begin, int end) {
    	//递归结束条件
        if(begin == end)
            return 0;
        int mid = (begin + end) / 2;
        // 递归调用
        int left = InversePairs(copy, array, begin, mid) % 1000000007;
        int right = InversePairs(copy, array, mid + 1, end) % 1000000007;
        // 归并，此时左右已排好序
        int i = mid, j = end, pos = end;
        int count = 0; // 记录相邻子数组间逆序数
        
        while(i >= begin && j >= mid + 1)
        {
            if(array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
                if(count >= 1000000007)
                	count %= 1000000007;
            } else
                copy[pos--] = array[j--];
        }
        
        while(i >= begin)
            copy[pos--] = array[i--];
        while(j >= mid + 1)
            copy[pos--] = array[j--];
        
        return (left + right + count) % 1000000007;
    }
}
public class I36_数组中的逆序对___归并排序 {
	//暴力法
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 0)
        	return 0;
        long cnt = 0;
        for(int i = 0; i < array.length - 1; ++i) {
        	for(int j = i + 1; j < array.length; ++j)
        		if(array[i] > array[j])
        			++cnt;
        }
        
        return (int) (cnt % 1000000007);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,0};
		System.out.println(new Solution36().InversePairs(array));

        System.out.println(1<<31);


	}

}
