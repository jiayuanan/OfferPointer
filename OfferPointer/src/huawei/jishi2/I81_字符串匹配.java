package huawei.jishi2;

/**
 * 2018��4��18�� @author jiayuanan
��Ŀ���⣺
�ж϶��ַ����е������ַ��Ƿ��ڳ��ַ�����ȫ������
��ϸ������
�ӿ�˵��
ԭ��
boolIsAllCharExist(char* pShortString,char* pLongString);
���������
    char* pShortString�����ַ���
    char* pLongString�����ַ���
 */

//˼·������ַ����ܳ������Դ���һ��������б�ǣ�һ������£�ֱ�ӱ����Ϳ�����
import java.util.Scanner;
public class I81_�ַ���ƥ�� {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String shortStr = scan.nextLine();
        	String longStr = scan.nextLine();
        	System.out.println(IsAllCharExist(shortStr, longStr));
        }
        scan.close();
    }
    
    public static boolean IsAllCharExist(String shortStr, String longStr) {
    	if(shortStr == null || longStr == null)
    		return false;
    	for(int i = 0; i < shortStr.length(); ++i) {
    		if(longStr.indexOf(shortStr.charAt(i)) == -1)  //����-1˵���������ַ�
    			return false;
    	}
    	return true;
    		
    }
}
