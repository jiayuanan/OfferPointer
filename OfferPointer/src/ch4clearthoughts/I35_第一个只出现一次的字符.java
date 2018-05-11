package ch4clearthoughts;

/**
 * 2018��3��26�� @author jiayuanan
 * item35: ��һ��ֻ����һ�ε��ַ�
 * ������������һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * ˼·������һ�����鱣��ÿ���ַ���һ�γ��ֵ�λ�ã������ֵڶ��Σ���һ�����������������飬����С�ģ�O(n)
 */
class Solution35 {
    public int FirstNotRepeatingChar(String str) {
    	if(str.length() == 1)
    		return 0;
    	//������ַ�ɶ��˼�������ִ�Сд����������ASCIIΪ׼��
    	int size = 128; //��ASCIIΪ׼
    	int[] pos = new int[size];
    	
    	int big = 1 << 14;
    	for(int i = 0; i < pos.length; ++i)
    		pos[i] = -1; //-1 ��ʾû���ֹ�
    	
    	int length = str.length();
    	for(int i = 0; i < length; ++i) {
    		char c = str.charAt(i);
    		int position = c - 0; //��ȡ����������λ��
    		
    		if(pos[position] == -1)
    			pos[position] = i;
    		else
    			pos[position] = big; //��ʾ���ֳ���1�Σ�
    	}
    	
    	int result = big;
    	for(int i = 0; i < pos.length; ++i) {
    		if(pos[i] != -1 && pos[i] != big && pos[i] < result)
    			result = pos[i];
    	}
    	
    	if(result == big)
    		return -1;  //�����ڷ���-1
    	else
    		return result;
    }
}
public class I35_��һ��ֻ����һ�ε��ַ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		System.out.println(new Solution35().FirstNotRepeatingChar(str));
	}

}
