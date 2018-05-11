package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I65_最长公共子串.java
 * 
 */
import java.util.*;
public class I65_最长公共子串{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String str1 = scan.nextLine();
        	String str2 = scan.nextLine();
        	System.out.println(getMaxCommonString(str1,str2));
        }
        scan.close();
    }
    
    public static String getMaxCommonString(String str1, String str2) {
    	ArrayList<String> result = new ArrayList<>();
    	String shortStr = str1.length() < str2.length() ? str1 : str2;
    	String longStr = str1.length() < str2.length() ? str2 : str1;  //保证长度相同时，选择的不是同一串
    	
    	int length1 = longStr.length();
    	int length2 = shortStr.length();
    	for(int i = 0; i < length1; ++i) {
    		
    	}
    }
}
