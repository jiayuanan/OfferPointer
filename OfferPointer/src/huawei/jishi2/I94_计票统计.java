package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I94_计票统计.java
 * 
 */
import java.util.*;
public class I94_计票统计{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	//处理被投票者输入
        	int candidateCnt = Integer.parseInt(scan.nextLine());
        	String[] candidates = scan.nextLine().trim().split(" ");  //没法读入char，只能用String
        	Map<String, Integer> map = new LinkedHashMap<>();
        	for(int i = 0; i < candidateCnt; ++i)
        		map.put(candidates[i], 0);
        	
        	//处理投票者输入
        	int invalid = 0;
        	int voteCnt = Integer.parseInt(scan.nextLine());
        	String[] votes = scan.nextLine().trim().split(" "); 
        	for(String vote : votes) {
        		if(map.containsKey(vote)) {
        			map.put(vote, map.get(vote) + 1);
        		} else
        			++invalid;
        	}
        	
        	for(String candidate : map.keySet()) {
        		System.out.println(candidate + " : " + map.get(candidate));
        	}
        	System.out.println("Invalid : " + invalid);
        	
        	
        }
        scan.close();
    }
}
