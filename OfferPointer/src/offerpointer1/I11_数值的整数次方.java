package offerpointer1;

/**
 * 2018��3��20�� @author jiayuanan
 * ��Ŀ��item11������ֵ�������η�
 * ����������һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * ˼·�������ݣ�Ҳ����ʹ��λ����
 */

class Solution11 {
    public double Power(double base, int exponent) {
    	boolean negtive = false;  //�����Ϊ���������
    	//��������
    	if(exponent == 0)
    		return 1;
    	if(exponent == 1) 
    		return base;
    	//��������
    	if(exponent < 0) {
    		exponent = - exponent;
    		negtive = true;
    	}
    	//��ʽ���㣬�ݹ鷽ʽ
    	double result = 1;
		if((exponent & 1) == 0)
			result = Power(base, exponent >> 1) * Power(base, exponent >> 1);
		else
			result = base * Power(base, exponent -1);
    	
    	if(negtive)
    		result = 1 / result;
    	return result;
        
  }
}


public class I11_��ֵ�������η� {
	public static void main(String...args) {
		System.out.println(new Solution11().Power(2, 6));
		System.out.println((1<<31)-1);
		System.out.println((1l<<63)-1);
	}
}
