package chunzhao.huawei;

/**
 * 2018年4月10日 @author jiayuanan
 * I1__reorderStrings.java
 * 
 */


import java.util.*;
class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//注意while处理多个case
        	String str = scan.next();
        	int length = str.length();
        	TreeMap<Character, Integer> map = new TreeMap<>();
        	for(int i = 0; i < str.length(); ++i) {
        		char ch = str.charAt(i);
        		if(map.containsKey(ch)) {
        			map.put(ch, map.get(ch) + 1); //若存在则+1
        		} else {
        			map.put(ch, 1); //若不存在，则放进去
        		}
        	}
        	
        	while(length > 0) {  //不改变map元素，采用标记法
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
        				map.remove(ch);  //若只剩一个，则删除——删除的话会导致异常
        			else
        				 //若有多个，则数目-1
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