package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
��Ŀ����
���ͳ�Ƶĸ�����ͬ������ASII����С����������� ������������ַ��������Щ�ַ����ý���ͳ�ơ�
ʵ�����½ӿڣ�
    ����һ���ַ��������ַ��еĸ���Ӣ���ַ������֣��ո����ͳ�ƣ��ɷ������ã�
    ����ͳ�Ƹ����ɶൽ�����ͳ�ƽ�������ͳ�Ƶĸ�����ͬ������ASII����С�����������
    ���Ŀǰ��ͳ�ƽ��������ͳ��
�����߻ᱣ֤��
������ַ����ԡ�\0����β��
 */
import java.util.*;
public class I102_�ַ�ͳ������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String line = scan.nextLine();
        	//����map
        	HashMap<Character, Integer> map = new HashMap<>();
        	for(int i = 0; i < line.length(); ++i) {
        		Character ch = line.charAt(i);
        		if(map.containsKey(ch)) {
        			map.put(ch, map.get(ch) + 1);
        		} else 
        			map.put(ch, 1);
        	}
        	//����
        	ArrayList<Character> list = new ArrayList<>();
        	list.addAll(map.keySet());
        	//System.out.println(list);
        	Collections.sort(list, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					if(map.get(o1) != map.get(o2))
						return map.get(o2) - map.get(o1); //�������ɴ�С����
					else 
						return o1 - o2;      //������ͬ����ASCII������С����
				}	
        	});
        	//���
        	//System.out.println(list);
        	for(Character c: list)
        		System.out.print(c );// + "" +  map.get(c));
        	System.out.println();
        }
        scan.close();
    }
}
