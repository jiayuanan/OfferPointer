package huawei.jishi1;


/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
����n���ַ��������n���ַ��������ֵ������С�
��������:
�����һ��Ϊһ��������n(1��n��1000),����n��Ϊn���ַ���(�ַ������ȡ�100),�ַ�����ֻ���д�Сд��ĸ��
�������:
�������n�У�������Ϊ�����ֵ������е��ַ����� 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class I14_�ַ����������·������ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> strArr = new ArrayList<>();
		
		while(scan.hasNext()) {
			int num = scan.nextInt();
			
			for(int i = 0; i < num; ++i) {
				strArr.add(scan.next());
			}
		}
		//�Զ���Comparator
		Collections.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}		
		});
		
		for(String s : strArr)
			System.out.println(s);

	}

}
