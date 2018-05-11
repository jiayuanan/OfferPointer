package ch2basicknowledge;


/**item8: ��ת�����е���С����  2018.03.20
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�  
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
class Solution8 {
    public int minNumberInRotateArray(int [] array) throws InterruptedException {
    	if(array == null)
    		return 0;
    	int start = 0; 
    	int end = array.length - 1;
    	int mid = start;
    	
    	//��������
    	while(array[start] >= array[end]) {
    		//�˳�����
    		if(end - start == 1) {  //��ʼд�� start - end �ˣ������˰���
    			mid = end;
    			break;
    		}
    		//���ֲ��ҡ���ע����������
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
    
    //˳�����
    public int seqSort(int[] array, int start, int end) {
    	int min = array[start];
    	for(int index = start; index < end; ++index) {
    		if(array[index] < min)
    			min = array[index];
    	}
    	return min;
    }
}


public class I08_��ת�����е���С���� {
	public static void main(String...args) throws InterruptedException {
		int[] array = {4,5,6,7,1,2,3};
		int[] array1 = {1,0,1,1,1,1,1};
		int[] array2 = {3,4,5,1,2};
		System.out.println(new Solution8().minNumberInRotateArray(array1));
	}

}
