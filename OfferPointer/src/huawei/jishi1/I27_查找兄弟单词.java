package huawei.jishi1;

/**
 * 2018年4月10日 @author jiayuanan
 * I27_查找兄弟单词.java
 * 
 */
import java.io.*;
import java.util.*;
public class I27_查找兄弟单词 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	    	//读取字典
	    	int num = scan.nextInt();
	    	String[] words = new String[num];
	    	for(int i = 0; i < num ; ++i)
	    		words[i] = scan.next();
	    	String word = scan.next();
	    	int pos = scan.nextInt(); //表示要取第几个兄弟
	    	//字典元素——需要排序!!!!!————注意，指望Tree排序不一定靠谱，还是使用sort吧
	    	int brotherWordNumber = 0;
	    	List<String> list = new ArrayList<>();
	    	for(int i = 0; i < words.length; ++i) {
	    		if(isBrother(word, words[i])) {
	    			list.add(words[i]);
	    			++brotherWordNumber;
	    		}
	    	}
	    	Collections.sort(list);
	    	System.out.println(brotherWordNumber);
	    	if(pos <= brotherWordNumber) //注意，题中并未提供安全保证
	    		System.out.println(list.get(pos - 1));
	    }
	}
	
	public static boolean isBrother(String s1, String s2) {
		if(s1.equals(s2))
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2); //注意，判断数组内容相等需要用这个Arrays.equal()
	}
}
