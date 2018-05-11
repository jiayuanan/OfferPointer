package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I106_�ַ����и�.java
 * 
 */
import java.util.Scanner;
public class I106_�ַ����и�{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = Integer.parseInt(scan.nextLine()); //��������д����nextInt�ᱨ��
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
