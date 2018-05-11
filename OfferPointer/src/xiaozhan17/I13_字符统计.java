package xiaozhan17;

/**
 * 2018年4月20日 @author jiayuanan
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * 
 */
import java.util.*;
public class I13_字符统计{
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
