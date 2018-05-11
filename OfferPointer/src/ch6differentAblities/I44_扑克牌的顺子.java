package ch6differentAblities;



/**
 * 2018��3��26�� @author jiayuanan
 * item44���˿��Ƶ�˳��
 * ������������һ���˿��Ƴ�5���ƣ��ж��ǲ���һ��˳�ӡ���һ��56���ƣ�����2��������2��С������С������Ϊ�����ơ���С��Ϊ0.
 */
import java.util.Arrays;
class Solution44 {
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length != 5)
    		return false;
    	Arrays.sort(numbers);    //1.����
    	int cntOfZeros = cntZeros(numbers);//2.����0�ĸ���
    	//System.out.println(cntOfZeros);
    	int distance = 0;  //3.���������ܾ���
    	for(int index = cntOfZeros + 1; index < numbers.length; ++index) {
    		if(numbers[index] == numbers[index - 1])
    			return false;  //���ڶ��ӣ��϶�����˳��
    		else
    			distance += numbers[index] - numbers[index - 1] - 1; //ע�⣬������distanceҪ�ȼ�ȥ1��1
    	}
    	
    	if(cntOfZeros >= distance)
    		return true;
    	else
    		return false;
    }
    
    public int cntZeros(int[] numbers) {
    	int result = 0;
    	for(int i = 0; i < numbers.length; ++i) {
    		if(numbers[i] == 0)
    			++result;
    		else
    			break;
    	}
    	return result;
    }
}
public class I44_�˿��Ƶ�˳�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,6,0,0,7};
		System.out.println(new Solution44().isContinuous(numbers));

	}

}
