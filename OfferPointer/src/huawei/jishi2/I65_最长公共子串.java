package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I65_������Ӵ�.java
 * 
 */
import java.util.*;
public class I65_������Ӵ�{
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
    	String longStr = str1.length() < str2.length() ? str2 : str1;  //��֤������ͬʱ��ѡ��Ĳ���ͬһ��
    	
    	int length1 = longStr.length();
    	int length2 = shortStr.length();
    	for(int i = 0; i < length1; ++i) {
    		
    	}
    }
}
