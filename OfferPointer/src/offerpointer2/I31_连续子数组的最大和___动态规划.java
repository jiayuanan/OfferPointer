package offerpointer2;

/**
 * 2018年3月23日 @author jiayuanan
 * item31:连续子数组的最大和
 * 问题描述：计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *         例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 思路：对于前N个数，若和<0，则舍弃；对于后面存在的负数，则先保留一个最大值用于对比，复杂度O(n)
 */
class Solution31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
        	return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; ++i) {
        	//前n项和大于0则保留，否则清零
        	if(sum <= 0)
        		sum = array[i];
        	else
        		sum += array[i];
        	//保存实时最大值
        	if(sum > max)
        		max = sum;
        }
        
        return max;
    }
}
//动态规划法：
class MySolution31{
	public  int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0]; //记录当前所有子数组的和的最大值
        int sum=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            sum=Math.max(sum+array[i], array[i]); //sum<=0时重新开始算
            max=Math.max(sum, max);      //对比
        }
        return max;
}
}
public class I31_连续子数组的最大和___动态规划 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(new Solution31().FindGreatestSumOfSubArray(array));
	}

}
