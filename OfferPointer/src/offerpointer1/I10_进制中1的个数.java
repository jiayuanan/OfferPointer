package offerpointer1;

/**
 * 2018��3��20�� @author jiayuanan
 * item10:��������1�ĸ���
 * ����������һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * �����⣺item40,47
 * ˼·��һλһλ�ıȣ����а�λ�����㣻 ���塪��������������λ���ܻ�������ѭ������Ϊ��λ���������λ����
 */


class Solution10 {
    public int NumberOf1(int n) {
    	int op = 1;
    	int result = 0;
    	while(op != 0) {
    		if((op & n) == op)   //�Ҳ�Ӧ����op����ʼ��дΪ1, Ҳ��Ϊ ��=0
    			++result;
    		op <<= 1;
    	}
    	
    	return result;
    }
}

public class I10_������1�ĸ��� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution10().NumberOf1(7));
	}

}
