package huawei.jishi1;

/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
ԭ��ip��ַ��ÿ�ο��Կ�����һ��0-255����������ÿ�β�ֳ�һ����������ʽ���������Ȼ��������������ת���
һ����������
������һ��ip��ַΪ10.0.3.193
ÿ������             ���Ӧ�Ķ�������
10                   00001010
0                    00000000
3                    00000011
193                  11000001
���������Ϊ��00001010 00000000 00000011 11000001,ת��Ϊ10���������ǣ�167773121������IP��ַת��������־������ˡ�
��ÿ�ο��Կ�����һ��0-255����������Ҫ��IP��ַ����У��
��������:
���� 
1 ����IP��ַ
2 ����10�����͵�IP��ַ

�������:
���
1 ���ת����10���Ƶ�IP��ַ
2 ���ת�����IP��ַ
 */
//˼·��������Ҫע��������⣬��int�������
import java.util.Scanner;
public class I33_������IP��ַת�� {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String ip = scan.nextLine();
			String number = scan.nextLine();
			//����ip��ַ
			String[] ips = ip.split("\\.");
			//System.out.println(ips[0]);
			Long ipToDouble = (Long.parseLong(ips[0]) << 24) + (Long.parseLong(ips[1]) << 16) + 
					          (Long.parseLong(ips[2]) << 8 )+  Long.parseLong(ips[3]) ; 
			//�������ip��ַ������
			Long num = Long.parseLong(number);
			long ipd = num % 256;
			long ipc = (num >> 8) % 256;
			long ipb = (num >> 16) % 256;
			long ipa = (num >> 24) % 256;
			
			System.out.println(ipToDouble);
			System.out.println(ipa + "." + ipb + "." + ipc + "." + ipd);
		}
		//System.out.println((255l << 24) + (3 <<8) +193);
	}
}
