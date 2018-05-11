package xiaozhan17;

import java.util.Arrays;
/**
 * 2018年4月20日 @author jiayuanan
题目描述
设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
输入描述:
有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
输出描述:
每组数据输出一个表示最大的整数
 */
import java.util.*;
public class I69_数串{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String num1 = scan.nextLine();
        	String[] nums1 = scan.nextLine().split(" ");
        	
        	System.out.println(maxNumberString(nums1));
        }
        scan.close();
    }
  //思路，转化成字符串；两两比较，按先后顺序组成两个串，比大小
    public static String maxNumberString(String[] nums) {
    	Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				int length = s1.length();
				for(int i = 0; i < length; ++i) {
					char c1 = s1.charAt(i);
					char c2 = s2.charAt(i);
					if(c1 != c2)
						return c2 - c1;
				}
				return 0;
    	
			}
    		
    	});
    	StringBuilder sb = new StringBuilder();
    	for(String s : nums)
    		sb.append(s);
    	return sb.toString();
    }
}
