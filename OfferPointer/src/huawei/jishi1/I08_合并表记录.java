package huawei.jishi1;





/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ���������ͬ��������ֵ����������㣬�������keyֵ������������

��������:
�������ֵ�Եĸ���
Ȼ������ɶԵ�index��valueֵ���Կո����

�������:
����ϲ���ļ�ֵ�ԣ����У� 
 */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
public class I08_�ϲ����¼ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int num = scan.nextInt();
			TreeMap<Integer, Integer> treemap = new TreeMap<>();
			for(int i = 0; i < num; ++i) {
				//2��2����ȡ��
				int key = scan.nextInt();
				int value = scan.nextInt();
				//key���ھ��ۼӣ�������ֱ�ӷ���
				if(treemap.containsKey(key)) {
					int value1 = treemap.remove(key);
					treemap.put(key, value + value1);
				} else
					treemap.put(key, value);
			}
			//TreeMap�ı���
	        Iterator<Integer> it = treemap.keySet().iterator();  
	        while (it.hasNext()) {  
	        	//it.next()�õ�����key��treemap.get(key)�õ�value 
	        	int key = it.next();
	            System.out.println(key + " " + treemap.get(key));  
	        }			
		}

	}

}
