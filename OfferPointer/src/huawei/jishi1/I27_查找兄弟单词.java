package huawei.jishi1;

/**
 * 2018��4��10�� @author jiayuanan
 * I27_�����ֵܵ���.java
 * 
 */
import java.io.*;
import java.util.*;
public class I27_�����ֵܵ��� {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	    	//��ȡ�ֵ�
	    	int num = scan.nextInt();
	    	String[] words = new String[num];
	    	for(int i = 0; i < num ; ++i)
	    		words[i] = scan.next();
	    	String word = scan.next();
	    	int pos = scan.nextInt(); //��ʾҪȡ�ڼ����ֵ�
	    	//�ֵ�Ԫ�ء�����Ҫ����!!!!!��������ע�⣬ָ��Tree����һ�����ף�����ʹ��sort��
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
	    	if(pos <= brotherWordNumber) //ע�⣬���в�δ�ṩ��ȫ��֤
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
		return Arrays.equals(c1, c2); //ע�⣬�ж��������������Ҫ�����Arrays.equal()
	}
}
