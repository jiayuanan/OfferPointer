package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item42:��ת����˳��
 * ���������������������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ������������
 *         ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc��
 */
class Solution42_1 {
    public String LeftRotateString(String str,int n) {
        if(str == null)
        	return null;
        if(str.length() == 0)
        	return str;
        
        
        int length = str.length();
        n = n % length;
        
        if(n == 0)
        	return str;
        
        return str.substring(n) + str.substring(0, n);
        
    }
}
public class I42_��ת����˳�� {

	public static void main(String[] args) {
		String s = "12345";
		System.out.println(s.substring(3) + s.substring(0, 3));
		// TODO Auto-generated method stub

	}

}
