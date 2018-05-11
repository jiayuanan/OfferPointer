package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I90_�Ϸ�IP.java
 * 
 */
import java.util.*;
public class I90_�Ϸ�IP{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String ip = scan.nextLine();
        	String[] ips = ip.split("\\.");
        	boolean yes = true;
        	for(String s : ips) {
        		try {
        			int num = Integer.parseInt(s);
        			if(num < 0 || num >= 255) {
        				//System.out.println("NO");
        				yes = false;
        				break;
        			}
        		} catch (Exception e) {
        			//System.out.println("NO");
        			yes = false;
        			break;
        		}
        	}
        	if(yes)
        		System.out.println("YES");
        	else
        		System.out.println("NO");
        		
        }
        scan.close();
    }
}
