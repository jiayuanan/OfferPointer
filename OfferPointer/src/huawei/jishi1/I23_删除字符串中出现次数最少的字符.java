package huawei.jishi1;


/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
ʵ��ɾ���ַ����г��ִ������ٵ��ַ���������ַ����ִ���һ������ɾ�������ɾ����Щ���ʺ���ַ������ַ����������ַ�����ԭ����˳�� 
��������:
�ַ���ֻ����СдӢ����ĸ, �����ǷǷ����룬������ַ�������С�ڵ���20���ֽڡ�

�������:
ɾ���ַ����г��ִ������ٵ��ַ�����ַ�����
 */
//˼·��ʹ��map����ų��ִ������ҵ���С���������ҵ���Ӧ���ַ����������ַ�������
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
public class I23_ɾ���ַ����г��ִ������ٵ��ַ� {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String chars = scan.nextLine();
			//�ַ�����ÿ���ַ����ֵĴ���ͳ��
			HashMap<Character,Integer> map = new HashMap<>();
			for(int i = 0; i < chars.length(); ++i) {
				char key = chars.charAt(i);
				if(map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			//�ҵ����ٵĴ���
			int min = 100;
			for(Integer i : map.values())
				if(i < min)
					min = i;
			//�ҵ����ٴ�����Ӧ���ַ�
			TreeSet<Character> set = new TreeSet<>();
			for(Character c : map.keySet()) {
				if(map.get(c) == min)
					set.add(c);
			}
			//������Ҫɾ�����ַ�ƴ��
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
