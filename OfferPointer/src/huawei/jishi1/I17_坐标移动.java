package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
����һ��������㹤�ߣ� A��ʾ�����ƶ���D��ʾ�����ƶ���W��ʾ�����ƶ���S��ʾ�����ƶ����ӣ�0,0���㿪ʼ�ƶ����������ַ��������ȡһЩ���꣬�����������������������ļ����档
���룺
�Ϸ�����ΪA(����D����W����S) + ���֣���λ���ڣ�
����֮����;�ָ���
�Ƿ��������Ҫ���ж�������AA10;  A1A;  $%$;  YAD; �ȡ�
������һ���򵥵����� �磺
A10;S20;W10;D30;X;A1A;B10A11;;A10;
������̣�
��㣨0,0��
+   A10   =  ��-10,0��
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10)
+   x    =  ��Ч
+   A1A   =  ��Ч
+   B10A11   =  ��Ч
+  һ���� ��Ӱ��
+   A10  =  (10,-10)
��� ��10�� -10��
��������:
һ���ַ���
�������:
�������꣬��,�ָ�
 */
import java.util.Scanner;
public class I17_�����ƶ� {
	//ţ��������ϵͳ�ǲ���ѭ���жϵġ���������ȫ�ֱ����޷���
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//�ڶ��θĶ�������hasNextLine()ѭ���ж�
		while(scan.hasNextLine()) {
			int x = 0;
			int y = 0;
			String[] orders = scan.nextLine().split(";");

			for(String order : orders) {
				try {
					int number = Integer.parseInt(order.substring(1));  //�õ����֡�����Ҫ�����쳣����
					//����
					if(order.charAt(0) == 'A')
						x -= number;
					//����
					if(order.charAt(0) == 'D')
						x += number;
					//����
					if(order.charAt(0) == 'W')
						y += number;
					//����
					if(order.charAt(0) == 'S')
						y -= number;
				} catch (Exception e) {
					continue;
				}
				
			}
			System.out.println(x + "," + y);
		}

	}

}


