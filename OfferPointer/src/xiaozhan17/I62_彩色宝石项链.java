package xiaozhan17;

/**
 * 2018��4��19�� @author jiayuanan
��һ����ɫ��ʯ���������ɺܶ��ֲ�ͬ�ı�ʯ��ɵģ������챦ʯ������ʯ����ʯ����䣬����ȡ�
��һ������������ʹ͸���һ��ѧ�ߣ�������˵������Դ����������������������ϲ���챦ʯ������ʯ����ˮ����������ʯ�����֣�
��Ҫ��������н�ȡ������һС�λ����ң���һ���б���������е������ֱ�ʯ��ʣ�µĲ�������Դ��ߡ�����޷��ҵ���һ��Ҳ�޷����ߡ�
�����ѧ���ҳ�����з��������ܹ��õ����ı�ʯ��
 */
//˼·����String��ÿλ��ʼѭ�������������Ҫ�����������ABCDE
import java.util.Scanner;
public class I62_��ɫ��ʯ����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String diamond = scan.nextLine();
        	int length = diamond.length();
        	int[] min = new int[length];
        	for(int i = 0; i < length; ++i) {//��ʼλ�ã�
        		int exsit = 0; //��λ���㣬11111��ʾ������
        		for(int j = 0; j < length; ++j) {//����������
        			char ch = diamond.charAt((i + j) % length);  //��ȡ��ʵ��ѭ��
        			exsit |= 1 << (ch - 'A' );  //ע�⣬������|����
        			//System.out.println(exsit);
        			if((exsit & 31) == 31) {
        				min[i] = j + 1;
        				break;
        			}
        		}
        	}
        	int minLen = length;
        	for(int i = 0; i < length; ++i)
        		if(minLen > min[i])
        			minLen = min[i];
        	System.out.println(length - minLen);
        }
        scan.close();
    }
}
