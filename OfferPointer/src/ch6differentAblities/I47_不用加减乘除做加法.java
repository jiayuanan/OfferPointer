package ch6differentAblities;

import java.math.BigInteger;

/**
 * 2018��3��26�� @author jiayuanan
 * item47: ���üӼ��˳����ӷ�
 */
class Solution47 {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;  //ÿλ��ӣ��������λ���������
            num2 = (num1 & num2) << 1;  //�����λ������*2
            num1 = temp;   //����
        }
        return num1;
    }
}
public class I47_���üӼ��˳����ӷ� {
	//ʹ�ô���
    public int Add(int num1,int num2) {
        BigInteger bi1=new BigInteger(String.valueOf(num1));
        BigInteger bi2=new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
