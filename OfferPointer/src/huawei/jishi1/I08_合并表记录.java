package huawei.jishi1;





/**
 * 2018年4月8日 @author jiayuanan
题目描述
数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

输入描述:
先输入键值对的个数
然后输入成对的index和value值，以空格隔开

输出描述:
输出合并后的键值对（多行） 
 */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
public class I08_合并表记录 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int num = scan.nextInt();
			TreeMap<Integer, Integer> treemap = new TreeMap<>();
			for(int i = 0; i < num; ++i) {
				//2个2个的取数
				int key = scan.nextInt();
				int value = scan.nextInt();
				//key存在就累加，不存在直接放入
				if(treemap.containsKey(key)) {
					int value1 = treemap.remove(key);
					treemap.put(key, value + value1);
				} else
					treemap.put(key, value);
			}
			//TreeMap的遍历
	        Iterator<Integer> it = treemap.keySet().iterator();  
	        while (it.hasNext()) {  
	        	//it.next()得到的是key，treemap.get(key)得到value 
	        	int key = it.next();
	            System.out.println(key + " " + treemap.get(key));  
	        }			
		}

	}

}
