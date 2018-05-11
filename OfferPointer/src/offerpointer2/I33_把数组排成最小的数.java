package offerpointer2;

/**
 * 2018年3月24日 @author jiayuanan
 * item33:把数组排成最小的数；
 * 问题描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *         例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution33 {
    public String PrintMinNumber(int [] numbers) {
    	if(numbers == null || numbers.length == 0)
    		return "";
    	//防止拼接后溢出，用字符串表示数字
    	ArrayList<String> list = new ArrayList<>();
    	for(int i = 0; i < numbers.length; i++)
    		list.add(Integer.valueOf(numbers[i]).toString());
    	//定义一个比较器，最终以排序的方式进行拼接
    	Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str1.compareTo(str2);
			}
    		
    	});
    	StringBuilder result = new StringBuilder();
    	for(String s : list)
    		result.append(s);
    	return result.toString();
    		
    }
}
public class I33_把数组排成最小的数 {
	public static void main(String...args) {
		int[] numbers = {3,32,321};
		System.out.println(new Solution33().PrintMinNumber(numbers));
	}
}
