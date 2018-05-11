package offerpointer2;

/**
 * 2018��3��24�� @author jiayuanan
 * item33:�������ų���С������
 * ��������������һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 *         ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution33 {
    public String PrintMinNumber(int [] numbers) {
    	if(numbers == null || numbers.length == 0)
    		return "";
    	//��ֹƴ�Ӻ���������ַ�����ʾ����
    	ArrayList<String> list = new ArrayList<>();
    	for(int i = 0; i < numbers.length; i++)
    		list.add(Integer.valueOf(numbers[i]).toString());
    	//����һ���Ƚ���������������ķ�ʽ����ƴ��
    	Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str1.compareTo(str2);
			}
    		
    	});
    	StringBuilder result = new StringBuilder();
    	for(String s : list)
    		result.append(s);
    	return result.toString();
    		
    }
}
public class I33_�������ų���С���� {
	public static void main(String...args) {
		int[] numbers = {3,32,321};
		System.out.println(new Solution33().PrintMinNumber(numbers));
	}
}
