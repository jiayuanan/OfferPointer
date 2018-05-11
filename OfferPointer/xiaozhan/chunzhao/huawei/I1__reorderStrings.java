package chunzhao.huawei;

/**
 * 2018��4��10�� @author jiayuanan
 * I1__reorderStrings.java
 * 
 */


import java.util.*;
class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//ע��while������case
        	String str = scan.next();
        	int length = str.length();
        	TreeMap<Character, Integer> map = new TreeMap<>();
        	for(int i = 0; i < str.length(); ++i) {
        		char ch = str.charAt(i);
        		if(map.containsKey(ch)) {
        			map.put(ch, map.get(ch) + 1); //��������+1
        		} else {
        			map.put(ch, 1); //�������ڣ���Ž�ȥ
        		}
        	}
        	
        	while(length > 0) {  //���ı�mapԪ�أ����ñ�Ƿ�
        		Set<Character> set = map.keySet();
        		Iterator<Character> it = set.iterator();
        		while(it.hasNext()) {
        			char ch = it.next();
        			if(map.get(ch) >= 1) {
        				System.out.print(ch);
        				map.put(ch, map.get(ch) - 1);
        				--length;
        			}
        			
/*        			if(map.get(ch) == 1)
        				map.remove(ch);  //��ֻʣһ������ɾ������ɾ���Ļ��ᵼ���쳣
        			else
        				 //���ж��������Ŀ-1
*/        		}       			
        	}
        	System.out.println();
        }
    }
}


public class I1__reorderStrings {
	public static void main(String...args) {
		String[] arg = {"haha"};
		new Main1().main(arg);
	}
}