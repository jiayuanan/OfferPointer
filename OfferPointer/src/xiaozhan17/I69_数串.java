package xiaozhan17;

import java.util.Arrays;
/**
 * 2018��4��20�� @author jiayuanan
��Ŀ����
����n�������������������ӳ�һ�ţ����һ�����Ķ�λ������
��:n=3ʱ��3������13,312,343,���ɵ��������Ϊ34331213��
��:n=4ʱ,4������7,13,4,246���ӳɵ��������Ϊ7424613��
��������:
�ж������������ÿ����������������У���һ��Ϊһ������N��N<=100�����ڶ��а���N����(ÿ����������1000���ո�ֿ�)��
�������:
ÿ���������һ����ʾ��������
 */
import java.util.*;
public class I69_����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String num1 = scan.nextLine();
        	String[] nums1 = scan.nextLine().split(" ");
        	
        	System.out.println(maxNumberString(nums1));
        }
        scan.close();
    }
  //˼·��ת�����ַ����������Ƚϣ����Ⱥ�˳��������������ȴ�С
    public static String maxNumberString(String[] nums) {
    	Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				int length = s1.length();
				for(int i = 0; i < length; ++i) {
					char c1 = s1.charAt(i);
					char c2 = s2.charAt(i);
					if(c1 != c2)
						return c2 - c1;
				}
				return 0;
    	
			}
    		
    	});
    	StringBuilder sb = new StringBuilder();
    	for(String s : nums)
    		sb.append(s);
    	return sb.toString();
    }
}
