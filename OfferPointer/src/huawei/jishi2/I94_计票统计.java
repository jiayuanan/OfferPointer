package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I94_��Ʊͳ��.java
 * 
 */
import java.util.*;
public class I94_��Ʊͳ��{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	//����ͶƱ������
        	int candidateCnt = Integer.parseInt(scan.nextLine());
        	String[] candidates = scan.nextLine().trim().split(" ");  //û������char��ֻ����String
        	Map<String, Integer> map = new LinkedHashMap<>();
        	for(int i = 0; i < candidateCnt; ++i)
        		map.put(candidates[i], 0);
        	
        	//����ͶƱ������
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
