package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * ����һ��Ӣ���ַ���,��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ���
 * 
 */
import java.util.*;
public class I13_�ַ�ͳ��{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String line = scan.nextLine();
            int length = line.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i = 0; i < length; ++i) {
                char ch = line.charAt(i);
                if(!Character.isLetter(ch) && !Character.isDigit(ch))
                	continue;
                if(!map.containsKey(ch))
                    map.put(ch, 1);
                else 
                    map.put(ch, map.get(ch) + 1);
                if(map.get(ch) == 3) {
                	System.out.println(ch);
                	break;
                }
            }
        }
        scan.close();
    }
}
