package xiaozhan17;

/**
 * 2018��4��19�� @author jiayuanan
 * ����һ��ʮ���Ƶ�������number��ѡ�������ȥ��һ�������֣�ϣ������������������ɵ����������
 * 
 */
//˼·:�������ҵ�һ�γ��ֱȺ���С�������ҵ���ͼ�¼���������λ�ã�Ȼ��ɾ��
import java.util.Scanner;
public class I61_������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String num = scan.nextLine();
        	int cnt = Integer.parseInt(scan.nextLine());//ע����������
        	StringBuilder sb = new StringBuilder();
        	sb.append(num);
        	if(sb.length() <= cnt)
        		System.out.println(0);
        	while(cnt > 0) {
        		int pos = 0; //Ҫɾ�����ַ���λ��
        		for(; pos < sb.length() - 1; ++pos) {
        			if(sb.charAt(pos) < sb.charAt(pos + 1)) {
        				break;
        			}
        		}     				
        		sb.deleteCharAt(pos);
        		--cnt;

        	}
        	System.out.println(sb);
        }
        scan.close();
    }
}
