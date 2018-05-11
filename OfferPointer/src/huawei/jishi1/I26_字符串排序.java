package huawei.jishi1;

/**
 * 2018年4月10日 @author jiayuanan
题目描述
编写一个程序，将输入字符串中的字符按如下规则排序。
规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
       如，输入： Type   输出： epTy
规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     如，输入： BabA   输出： aABb
规则 3 ：非英文字母的其它字符保持原来的位置。
     如，输入： By?e   输出： Be?y
样例：
    输入：
   A Famous Saying: Much Ado About Nothing(2012/8).
    输出：
   A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
 */
import java.io.*;
import java.util.*;
public class I26_字符串排序 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	    	String str = scan.nextLine();
	    	TreeMap<Integer, Character> map = new TreeMap<>();//按位置顺序存放非字母；
	    	ArrayList<Character> list = new ArrayList<>(); //存放字母
	    	//分类存放
	    	for(int i = 0; i < str.length(); ++i) {
	    		char ch = str.charAt(i);
	    		if(Character.isLetter(ch)) {
	    			list.add(ch);
	    		} else {
	    			map.put(i, ch);
	    		}
	    	}
	    	//对字母排序
	    	Collections.sort(list, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					char c1 = Character.toLowerCase(o1);
					char c2 = Character.toLowerCase(o2);
					return c1 - c2;
				}
	    		
	    	});
	    	//再合并成结果
	    	String result = "";
	    	int listPos = 0;
	    	for(int i = 0; i < str.length(); ++i) {
	    		if(map.containsKey(i))
	    			result += map.get(i);
	    		else {
	    			result += list.get(listPos++);
	    		}
	    		
	    	}
	    	System.out.println(result);
	    }
	}
}
