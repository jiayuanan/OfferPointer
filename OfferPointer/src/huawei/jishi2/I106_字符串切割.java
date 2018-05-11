package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I106_字符串切割.java
 * 
 */
import java.util.Scanner;
public class I106_字符串切割{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = Integer.parseInt(scan.nextLine()); //必须这样写，用nextInt会报错
        	for(int i = 0; i < num; ++i) {
        		String str = scan.nextLine();
        		separateString(str);
        	}
        }
        scan.close();
    }
    
    public static void separateString(String str) {
    	int length = str.length();
    	if(length % 8 != 0) {
    		int cnt = 8 - length % 8;
    		String suffix = "";
    		for(int i = 0; i < cnt; ++i)
    			suffix += '0';
    		str += suffix;
    	}
    	
    	for(int i = 0; i < length; i += 8) {
    		System.out.println(str.substring(i, i + 8));
    	}
    }
}
