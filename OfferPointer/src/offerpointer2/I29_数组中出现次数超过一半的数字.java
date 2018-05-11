package offerpointer2;

/**
 * 2018��3��23�� @author jiayuanan
 * item29:�����г��ִ�������һ�������
 * ������������������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 *         ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
class Solution29 {
	//�����������Ա�д
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
        	return 0;
        if(array.length == 1)
        	return array[0];
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; ++i) {//ע�⣬i��1��ʼ
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
    //ʹ�ÿ��ŵ�Partition������д ???????????���
    public int MoreThanHalfNum(int[] array) {
        if(array == null || array.length == 0)
        	return 0;
        if(array.length == 1)
        	return array[0];
        int middle = array.length >> 1; //����������Ҫ������������������м�λ�ÿ϶�Ϊ����
        
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
public class I29_�����г��ִ�������һ������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2,2};
		System.out.println(new Solution29().MoreThanHalfNum(array));
	}

}
