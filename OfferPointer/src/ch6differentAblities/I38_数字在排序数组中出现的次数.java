package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item38:���������������г��ֵĴ���
 * ����������ͳ��һ�����������������г��ֵĴ�����
 * ˼·��ʹ�ö��ֲ��ң��ֱ��ҵ������������е�һ�κ����һ�γ��ֵ�λ��
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
    //�ݹ�д��
    int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){  //��ߵ�ֵ=�м��ֵ=��Ҫ�ҵ�ֵ
            return getFirstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }
    //ѭ��д��
    int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){ //�ұߵ�ֵ=�м��ֵ=��Ҫ�ҵ�ֵ
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1; //�Ҳ���
    }
}
public class I38_���������������г��ֵĴ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,3,3,3,4,5,6,6,6,7,7,8,8,9,10};
		System.out.println(new Solution38().GetNumberOfK(array, 6));
	}

}
