package huawei.jishi1;

/**
 * 2018��4��10�� @author jiayuanan
��Ŀ����
��дһ�����򣬽������ַ����е��ַ������¹�������
���� 1 ��Ӣ����ĸ�� A �� Z ���У������ִ�Сд��
       �磬���룺 Type   ����� epTy
���� 2 ��ͬһ��Ӣ����ĸ�Ĵ�Сдͬʱ����ʱ����������˳�����С�
     �磬���룺 BabA   ����� aABb
���� 3 ����Ӣ����ĸ�������ַ�����ԭ����λ�á�
     �磬���룺 By?e   ����� Be?y
������
    ���룺
   A Famous Saying: Much Ado About Nothing(2012/8).
    �����
   A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
 */
import java.io.*;
import java.util.*;
public class I26_�ַ������� {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	    	String str = scan.nextLine();
	    	TreeMap<Integer, Character> map = new TreeMap<>();//��λ��˳���ŷ���ĸ��
	    	ArrayList<Character> list = new ArrayList<>(); //�����ĸ
	    	//������
	    	for(int i = 0; i < str.length(); ++i) {
	    		char ch = str.charAt(i);
	    		if(Character.isLetter(ch)) {
	    			list.add(ch);
	    		} else {
	    			map.put(i, ch);
	    		}
	    	}
	    	//����ĸ����
	    	Collections.sort(list, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					char c1 = Character.toLowerCase(o1);
					char c2 = Character.toLowerCase(o2);
					return c1 - c2;
				}
	    		
	    	});
	    	//�ٺϲ��ɽ��
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
