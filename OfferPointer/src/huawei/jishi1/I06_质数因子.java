package huawei.jishi1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2018��4��7�� @author jiayuanan
��Ŀ����
����:����һ�������������մ�С�����˳����������������������ӣ���180����������Ϊ2 2 3 3 5 ��
���һ��������ҲҪ�пո�
��ϸ������
�����ӿ�˵����
public String getResult(long ulDataInput)
���������
long ulDataInput�������������
����ֵ��
String
��������:
����һ��long������

�������:
���մ�С�����˳����������������������ӣ��Կո���������һ��������ҲҪ�пո�
 */
public class I06_�������� {
	
	public String getResult(long ulDataInput) {
		String result = "";
		
		ArrayList<Integer> primes = new ArrayList<>();
		while(ulDataInput > 1) {
			for(int i = 2; i <= ulDataInput; ++i) {  //ע�⣬��<= ,����<
				if(ulDataInput % i == 0) {
					primes.add(i);
					//System.out.println(i);
					ulDataInput /= i;
					break;
				}
			}
		}
		
		for(Integer i : primes)
			result = result + i + " ";
		
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(new I06_��������().getResult(scan.nextLong()));		

	}

}
