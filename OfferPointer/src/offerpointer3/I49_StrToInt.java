package offerpointer3;

/**
 * 2018��3��26�� @author jiayuanan
 * item48:���ַ���ת������
 * ������������һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */
class Solution49 {
    public int StrToInt(String str) {
        if(str == null || str.trim().equals(""))
        	return 0;
        //�����ִ���
        if(!pureNumbers(str))
        	return 0;
        
        //����ǰ�������Ŵ���
        boolean negtive = false;
        if(str.charAt(0) == '-') {
        	negtive = true;
        	str = str.substring(1);
        } 
        
        if (str.charAt(0) == '+') {
        	negtive = false;
        	str = str.substring(1);
        } 
        //��ֵ����
        int result = 0;
        for(int i = 0; i < str.length(); ++i) {
        	result *= 10;
        	result += str.charAt(i) - '0';
        }
        //����
        if(negtive)
        	result = -result;
        
        return result;        	
    }
    
    public boolean pureNumbers(String str) {
    	int num = str.charAt(0) -'0';
    	if(str.length() == 1 && (num >9 || num < 0))
    		return false;
    	if(str.charAt(0) == '-' || str.charAt(0) == '+')
    		str = str.substring(1);
    	
    	for(int index = 0; index < str.length(); ++index) {
    		int help = str.charAt(index) - '0';
    		if(help > 9 || help < 0)
    			return false;
    	}
    	
    	return true;
    		
    }
}
public class I49_StrToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution49().StrToInt(""));
	}

}
