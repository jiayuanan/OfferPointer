package ch6differentAblities;

/**
 * 2018年3月26日 @author jiayuanan
 * item42: 另一题——翻转单词顺序
 * 问题描述：“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 */
class Solution42 {
    public String ReverseSentence(String str) {
    	if(str == null)
    		return null;
    	//这一个判断好蠢，题目描述不清
        if(str.trim().equals(""))
            return str;
        String[] ss = str.split(" ");
        
        StringBuilder result = new StringBuilder("");
        int length = ss.length;
        for(int i = length - 1; i >= 0; --i) {
        	result.append(ss[i]);
        	if(i != 0)
        		result.append(" ");
        }
        
        return result.toString();
    }
}
public class I42_翻转句子顺序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " ";
		System.out.print(new Solution42().ReverseSentence(str));
		System.out.println("haha");
	}

}
