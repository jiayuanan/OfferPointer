package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item41:��Ϊs��������������
 * ����������
 */
import java.util.ArrayList;
class Solution41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(sum <= 0)
    	   return result;
       //��sum���طֽ⣻ǰһ�������������һ�������ֵ
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
