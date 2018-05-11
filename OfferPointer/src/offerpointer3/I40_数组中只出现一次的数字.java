package offerpointer3;



/**
 * 2018��3��26�� @author jiayuanan
 * item40:������ֻ����һ�ε�����
 * ����������һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */
//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
import java.util.*;
class Solution40 {
	/**
     * ����������������һ�ε����֣��������ֶ��������Σ��ҳ�����������
     */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        //һ�������䱾������0
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        //�ҵ�������д��ҵ����е�һ����0�ģ���λ��Ϊindex
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) 
            	break;
        }
        //��index��λΪ0/1Ϊ׼��������Ϊ2�����ֱ����
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
/**
     * ����a��ֻ��һ��������һ�Σ���������������2�Σ��ҳ��������
     */
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }
/**
     * ����a��ֻ��һ��������һ�Σ��������ֶ�������3�Σ��ҳ��������
     */
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }

}

public class I40_������ֻ����һ�ε����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new Solution40().findNumsAppearOnce(array, num1, num2);
	}

}
