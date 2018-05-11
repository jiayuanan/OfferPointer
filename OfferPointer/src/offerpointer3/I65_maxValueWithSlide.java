package offerpointer3;



/**
 * 2018��3��27�� @author jiayuanan
 * item65:�������ڵ����ֵ
 * ��������������һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 *         ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *          {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
        
        int lasting = size ; //���ֵ�ĳ���ʱ��
        for(int i = size - 1; i >=0 ; --i) {
        	if(num[i] == max0) {
        		lasting = i; //��ʼ��lastingһ��Ҫ���㣬�������ֵ��λ��
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
        int lasting = size ; //���ֵ�ĳ���ʱ��
        for(int i = size - 1; i >=0 ; --i) {
        	if(num[i] == max0) {
        		lasting = i; //��ʼ��lastingһ��Ҫ���㣬�������ֵ��λ��
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
