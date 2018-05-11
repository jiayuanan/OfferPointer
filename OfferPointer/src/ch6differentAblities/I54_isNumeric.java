package ch6differentAblities;

/**
 * 2018��3��27�� @author jiayuanan
 * item54:��ʾ���ֵ��ַ���
 * ������������ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 *         ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
class Solution54 {
	
	//˼·����Ҫ��e��'.'���������У�e�����ҪΪ�����б�Ϊ������ '.'���Ҷ���ҪΪ��
    public boolean isNumeric(char[] str) {
    	//�쳣���봦��
    	if(str == null)
    		return false;
    	//�����1λ�Ҳ�Ϊ���ֵ�����
    	if(str.length == 1 && !isDigit(str[0]))
    		return false;
    	//����ͷ���ܳ��ֵ�+-������ʱ��������2λ
    	int index = 0;
    	if(str[0] == '-' || str[0] == '+')
    		index = 1;
    	//��ʱ������1λ
    	for(int i = index; i < str.length; ++i) {
    		if(isDigit(str[i]))
    			continue;   //������������������
    		//�������E/e������
    		else if (str[i] == 'e' || str[i] == 'E') {
    			if(i == index || i == str.length - 1)
    				return false;//�������ڿ�ͷ�ͽ�β������false
    			//���棬e����������1��char
    			else {
    				if(i+1 == str.length - 1 && !isDigit(str[i + 1]))
    					return false;
    				else {
    					int temp = i + 1;
    			    	if(str[temp] == '-' || str[temp] == '+')
    			    		++temp;
        				for(int j = temp; j < str.length; ++j) {
        					if(!isDigit(str[j]))
        						return false;        					
        					}
        				return true;   						
    				}
    			}
    		}
    		//�������С���������
    		else if(str[i] == '.') {
    			if(i == str.length - 1)// i == index || i == str.length - 1  �������������У�.123Ϊtrue
    				return false;
    			for(int j = i + 1; j < str.length; ++j) {
    				//���.�������e������
    				if (str[j] == 'e' || str[j] == 'E') {
    	    			if(j == i + 1 || j == str.length - 1)
    	    				return false;//��e����С������ڽ�β������false
    	    			//���棬eǰ��ͺ���ֻ����1��char
    	    			else {
    	    				//��e����ֻ��1λ�Ҳ�Ϊ���֣�����false
    	    				if(j + 1 == str.length - 1 && !isDigit(str[j + 1]))
    	    					return false;
    	    				else {
    	    					int temp = j + 1;
    	    			    	if(str[temp] == '-' || str[temp] == '+')
    	    			    		++temp;
    	        				for(int k = temp; k < str.length; ++k) {
    	        					if(!isDigit(str[k]))
    	        						return false;        					
    	        					}   
    	        				return true; 
    	    				}  	    				
    	    			}
    	    		}
    				
    				if(!isDigit(str[j]))
    					return false;
    			}
    				

    			return true;
    			
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
        
    }
    
    public boolean isDigit(char c) {
    	int help = c - '0';
    	if(help < 0 || help > 9) 
    		return false;
    	else
    		return true;
    }
}
public class I54_isNumeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'-', '.','4','5','5','6'};
		System.out.println(new Solution54().isNumeric(str));
	}

}
