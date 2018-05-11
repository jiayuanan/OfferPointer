package offerpointer1;

/**
 * 2018��3��20�� @author jiayuanan
 * item14:��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ����������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
class Solution14 {
    public void reOrderArray(int [] array) {
    	//����һ���������������
        int[] result = new int[array.length];
        //����2��λ�ø���ֱ�����������ż����
        int odd = 0; 
        int even = result.length - 1;
        //��������
        for(int index = 0; index < array.length; ++index) {
        	if((array[index] & 1) == 1) 
        		result[odd++] = array[index];
        }
        //����ż��
        for(int index = array.length -1; index >= 0; --index) {
        	if((array[index] & 1) == 0)
        		result[even--] = array[index];
        }
        
        //array = result;   //�����ǲ��е�
        
        for(int i = 0; i < array.length; ++i) {
        	array[i] = result[i];
        }
    }
}

public class I14_��������˳��ʹ����λ��ż��ǰ�� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		new Solution14().reOrderArray(array);
	}

}
