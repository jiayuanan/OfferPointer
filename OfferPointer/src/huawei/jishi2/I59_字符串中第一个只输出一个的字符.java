package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I59_�ַ����е�һ��ֻ���һ�����ַ�.java
 * 
 */
import java.util.*;
public class I59_�ַ����е�һ��ֻ���һ�����ַ�{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String line = scan.nextLine();
        	HashMap<Character, Integer> map = new LinkedHashMap<>();//������˳���ŷ�
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
        			break;   //��һ�䲻����
        		}	
        	}
        	if(!exist)
        		System.out.println(-1);
        }
        scan.close();
    }
}
