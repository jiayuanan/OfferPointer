package huawei.jishi1;


/**
 * 2018�?4�?8�? @author jiayuanan
题目描述
信息社会，有海量的数据需要分析处理，比如公安�?分析身份证号码�?? QQ 用户、手机号码�?�银行帐号等信息及活动记录�??  
采集输入大数据和分类规则，�?�过大数据分类处理程序，将大数据分类输出�?
输入描述:
﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第�?个整数为序列的个数（个数不包含第�?个整数）；整数范围为0~0xFFFFFFFF，序列个数不�?
输出描述:
﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>�? 
I<j>整数对应的数字需要连续包含R<i>对应的数字�?�比如R<i>�?23，I<j>�?231，那么I<j>包含了R<i>，条件满�? �? 
按R<i>从小到大的顺�?:
(1)先输出R<i>�? 
(2)再输出满足条件的I<j>的个数； 
(3)然后输出满足条件的I<j>在I序列中的位置索引(�?0�?�?)�? 
(4)�?后再输出I<j>�? 
附加条件�? 
(1)R<i>�?要从小到大排序�?�相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉 
(2)如果没有满足条件的I<j>，对应的R<i>不用输出 
(3)�?后需要在输出序列的第�?个整数位置记录后续整数序列的个数(不包含�?�个数�?�本�?)
序列I�?15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第�?�?15表明后续�?15个整数） 
序列R�?5,6,3,6,3,0（第�?�?5表明后续�?5个整数） 
输出�?30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
说明�?
30----后续�?30个整�?
3----从小到大排序，第�?个R<i>�?0，但没有满足条件的I<j>，不输出0，�?�下�?个R<i>�?3
6--- 存在6个包�?3的I<j> 
0--- 123�?在的原序号为0 
123--- 123包含3，满足条�?  
 */
import java.util.*;

public class I25_数据分类处理 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			//读取整数和规则序�?
			int num1 = scan.nextInt();
			int[] integers = new int[num1];
			for(int i = 0; i < num1; ++i)
				integers[i] = scan.nextInt();
			int num2 = scan.nextInt();
			int[] rules = new int[num2];
			for(int i = 0; i < num2; ++i)
				rules[i] = scan.nextInt();
			System.out.println(dealingPart(integers, rules));
			

		}
	}
	
	public static String dealingPart(int[] integers, int[] rules) {
		//用来存放rules并排序去�?
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0; i < rules.length; ++i) {
			set.add(rules[i]);
		}
		//TreeMap用String排序和用Integer排序的结果并非一样，�?以要定义�?个比较器
		Comparator<String> com = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {			
				return Integer.parseInt(o1) - Integer.parseInt(o2);
			}
			
		};
		Map<String, TreeSet<Integer>> map = new TreeMap<>(com);  //value放的是I序列中数的位�?
		int total = 0;
		for(Integer in : set) {
			for(int i = 0; i < integers.length; ++i) {
				if(String.valueOf(integers[i]).contains(String.valueOf(in))) { //I序列的数包含规则s
					if(map.containsKey(String.valueOf(in))) {
						map.get(String.valueOf(in)).add(i);   // 给已存在的map元素增加�?个set元素
					} else {
						TreeSet<Integer> sets = new TreeSet<>(); //新添加一个map元素
						sets.add(i);
						map.put(String.valueOf(in), sets);
					}
				//System.out.println(integers[i]);
				total++;
				}
					
			}
		}
		
		
		StringBuilder result = new StringBuilder("");
		result.append(total * 2 + map.size() * 2);  //输出总和—�?�注意，总和和total的关�?
		Set<String> keys = map.keySet();
		
		for(String key : keys) {  //规则set
			result.append(" " + key); //先输出规�?
			result.append(" " + map.get(key).size()); //再输出I<j>总数
			//输出满足条件的数�?
			for(Integer i : map.get(key)) {
				result.append(" " + i);   //输出位置
				result.append(" " + integers[i]); //输出�?
			}
		}
		return result.toString();
	}
}
