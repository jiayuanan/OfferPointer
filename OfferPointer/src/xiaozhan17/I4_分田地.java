package xiaozhan17;

/**
 * 2018��4��19�� @author jiayuanan
ţţ�� 15 �������������������ص���Ϸ��ţţ��������������أ���������ؿ��Կ�����һ�����Σ�ÿ��λ����һ����ֵ���ָ���صķ����Ǻ��������������ֳ� 16 �ݣ�
��Ϊ�쵼�ɲ���ţţ���ǻ�ѡ�������ܼ�ֵ��С��һ����أ� ��Ϊţţ��õ����ѣ���ϣ��ţţȡ�õ���صļ�ֵ�;����ܴ���֪�����ֵ�������Ƕ�
 */
import java.util.Scanner;
public class I4_�����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	double num = scan.nextDouble();
        	int length = scan.nextInt();
        	System.out.println(num + " " +length);
        	System.out.printf(".2f%",num);
        }
        scan.close();
    }
}
