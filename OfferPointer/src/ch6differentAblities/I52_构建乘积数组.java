package ch6differentAblities;

/**
 * 2018��3��27�� @author jiayuanan
 * item52:�����˻�����
 * ��������������һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */
import java.util.Arrays;
class Solution52 {
    public int[] multiply(int[] A) {
    	if(A == null)
    		return null;
    	int[] B = new int[A.length];
    	for(int i = 0; i < A.length; ++i) {
    		int temp = 1;
    		for(int j = 0; j < A.length; ++j) {
    			if(j == i)
    				continue;
    			else
    				temp *= A[j];
    		}
    		B[i] = temp;
    	}
    	
    	return B;
    }
}
public class I52_�����˻����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5};
		System.out.println(Arrays.toString(new Solution52().multiply(A)));

	}

}
