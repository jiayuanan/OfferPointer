package ch6differentAblities;

/**
 * 2018年3月26日 @author jiayuanan
 * item41:和为s的连续正数序列
 * 问题描述：
 */
import java.util.ArrayList;
class Solution41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(sum <= 0)
    	   return result;
       //将sum因素分解；前一个代表个数，后一个代表均值
       for(int counts = sum; counts > 0; --counts) {
    	   if(sum % counts != 0) {
    		   continue;
    	   } else {
    		   int meanValue = sum / counts;
    		   
    	   }
       }
    }
}
public class I41_FindContinuousSequence {

}
