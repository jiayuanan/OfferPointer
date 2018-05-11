package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
题目描述
如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
实现以下接口：
    输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
    按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出
    清空目前的统计结果，重新统计
调用者会保证：
输入的字符串以‘\0’结尾。
 */
import java.util.*;
public class I102_字符统计排序{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String line = scan.nextLine();
        	//构建map
        	HashMap<Character, Integer> map = new HashMap<>();
        	for(int i = 0; i < line.length(); ++i) {
        		Character ch = line.charAt(i);
        		if(map.containsKey(ch)) {
        			map.put(ch, map.get(ch) + 1);
        		} else 
        			map.put(ch, 1);
        	}
        	//排序
        	ArrayList<Character> list = new ArrayList<>();
        	list.addAll(map.keySet());
        	//System.out.println(list);
        	Collections.sort(list, new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					if(map.get(o1) != map.get(o2))
						return map.get(o2) - map.get(o1); //按个数由大到小排序
					else 
						return o1 - o2;      //个数相同，按ASCII排序由小到大
				}	
        	});
        	//输出
        	//System.out.println(list);
        	for(Character c: list)
        		System.out.print(c );// + "" +  map.get(c));
        	System.out.println();
        }
        scan.close();
    }
}
