package huawei.jishi1;




/**
 * 2018��4��7�� @author jiayuanan
��Ŀ����
��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��1000����
���������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣
����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ����� 
Input Param 
     n               ����������ĸ���     
 inputArray      n�����������ɵ����� 

Return Value
     OutputArray    ����������������

ע������������֤�����������ȷ�ԣ�������������֤������������ֹһ�顣
��������:
������У���������������ĸ�������������Ӧ����������

�������:
���ض��У������Ľ�� 
 */
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
public class I03_���е�ȥ�غ����� {
//��TreeSet��������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Set<Integer> tree = new TreeSet<Integer>();
		while(scan.hasNext()) {
			int sum = scan.nextInt();
			for(int i = 0; i < sum; ++i) {
				tree.add(scan.nextInt());
			}
			
			for(Integer i : tree)
				System.out.println(i);
		}
		
		Iterator<Integer> it = tree.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
