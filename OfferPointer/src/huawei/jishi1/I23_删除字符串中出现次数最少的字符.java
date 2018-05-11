package huawei.jishi1;


/**
 * 2018年4月8日 @author jiayuanan
题目描述
实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。 
输入描述:
字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

输出描述:
删除字符串中出现次数最少的字符后的字符串。
 */
//思路：使用map，存放出现次数；找到最小次数，再找到对应的字符；最后进行字符串重组
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
public class I23_删除字符串中出现次数最少的字符 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String chars = scan.nextLine();
			//字符串中每个字符出现的次数统计
			HashMap<Character,Integer> map = new HashMap<>();
			for(int i = 0; i < chars.length(); ++i) {
				char key = chars.charAt(i);
				if(map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			//找到最少的次数
			int min = 100;
			for(Integer i : map.values())
				if(i < min)
					min = i;
			//找到最少次数对应的字符
			TreeSet<Character> set = new TreeSet<>();
			for(Character c : map.keySet()) {
				if(map.get(c) == min)
					set.add(c);
			}
			//将不需要删除的字符拼接
			String result = "";
			for(int i = 0; i < chars.length(); ++i) {
				char key = chars.charAt(i);
				if(!set.contains(key))
					result += key;
				
			}
			System.out.println(result);
		}
	}
}
