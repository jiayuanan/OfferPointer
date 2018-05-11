package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I59_字符串中第一个只输出一个的字符.java
 * 
 */
import java.util.*;
public class I59_字符串中第一个只输出一个的字符{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String line = scan.nextLine();
        	HashMap<Character, Integer> map = new LinkedHashMap<>();//按输入顺序排放
        	int length = line.length();
        	for(int i = 0; i < length; ++i) {
        		char ch = line.charAt(i);
        		if(map.containsKey(ch))
        			map.put(ch, 0);
        		else
        			map.put(ch, 1);
        	}
        	boolean exist = false;
        	for(Character ch : map.keySet()) {
        		if(map.get(ch) == 1) {
        			System.out.println(ch);
        			exist = true;
        			break;   //这一句不可少
        		}	
        	}
        	if(!exist)
        		System.out.println(-1);
        }
        scan.close();
    }
}
