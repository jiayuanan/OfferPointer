package ch6differentAblities;

/**
 * 2018年3月27日 @author jiayuanan
 * item54:表示数字的字符串
 * 问题描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *         例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
class Solution54 {
	
	//思路：主要对e和'.'做处理，其中，e左边需要为数，有边为整数； '.'左右都需要为数
    public boolean isNumeric(char[] str) {
    	//异常输入处理
    	if(str == null)
    		return false;
    	//处理仅1位且不为数字的情形
    	if(str.length == 1 && !isDigit(str[0]))
    		return false;
    	//处理开头可能出现的+-——此时，至少有2位
    	int index = 0;
    	if(str[0] == '-' || str[0] == '+')
    		index = 1;
    	//此时最少有1位
    	for(int i = index; i < str.length; ++i) {
    		if(isDigit(str[i]))
    			continue;   //若出现数字则正常；
    		//处理出现E/e的情形
    		else if (str[i] == 'e' || str[i] == 'E') {
    			if(i == index || i == str.length - 1)
    				return false;//若出现在开头和结尾，返回false
    			//下面，e后面至少有1个char
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
    		//处理出现小数点的情形
    		else if(str[i] == '.') {
    			if(i == str.length - 1)// i == index || i == str.length - 1  ————判题中，.123为true
    				return false;
    			for(int j = i + 1; j < str.length; ++j) {
    				//针对.后面出现e的情形
    				if (str[j] == 'e' || str[j] == 'E') {
    	    			if(j == i + 1 || j == str.length - 1)
    	    				return false;//若e紧跟小数点或在结尾，返回false
    	    			//下面，e前面和后面只有有1个char
    	    			else {
    	    				//若e后面只有1位且不为数字，返回false
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
