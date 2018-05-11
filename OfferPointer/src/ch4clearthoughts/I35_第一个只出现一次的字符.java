package ch4clearthoughts;

/**
 * 2018年3月26日 @author jiayuanan
 * item35: 第一个只出现一次的字符
 * 问题描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 思路：创建一个数组保存每个字符第一次出现的位置，若出现第二次，置一个大数，最后遍历数组，找最小的，O(n)
 */
class Solution35 {
    public int FirstNotRepeatingChar(String str) {
    	if(str.length() == 1)
    		return 0;
    	//这里的字符啥意思哈，区分大小写不？还是以ASCII为准啊
    	int size = 128; //以ASCII为准
    	int[] pos = new int[size];
    	
    	int big = 1 << 14;
    	for(int i = 0; i < pos.length; ++i)
    		pos[i] = -1; //-1 表示没出现过
    	
    	int length = str.length();
    	for(int i = 0; i < length; ++i) {
    		char c = str.charAt(i);
    		int position = c - 0; //获取其在数组中位置
    		
    		if(pos[position] == -1)
    			pos[position] = i;
    		else
    			pos[position] = big; //表示出现超过1次；
    	}
    	
    	int result = big;
    	for(int i = 0; i < pos.length; ++i) {
    		if(pos[i] != -1 && pos[i] != big && pos[i] < result)
    			result = pos[i];
    	}
    	
    	if(result == big)
    		return -1;  //不存在返回-1
    	else
    		return result;
    }
}
public class I35_第一个只出现一次的字符 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		System.out.println(new Solution35().FirstNotRepeatingChar(str));
	}

}
