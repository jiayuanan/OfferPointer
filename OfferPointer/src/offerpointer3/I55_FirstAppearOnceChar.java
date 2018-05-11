package offerpointer3;

/**
 * 2018年3月27日 @author jiayuanan
 * item55:字符中第一个不重复的字符
 * 问题描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *         例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *         如果当前字符流没有存在出现一次的字符，返回#字符。
 */
import java.util.LinkedList;
import java.util.Queue;
class Solution55 {
	Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(!queue.contains(ch))
        	queue.add(ch);
        else
        	queue.remove(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	if(queue == null || queue.isEmpty())
    		return '#';
    	else
    		return queue.peek();
    }
}
public class I55_FirstAppearOnceChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution55 s = new Solution55();
		String str = "google";
		for(int index = 0; index < str.length(); ++index)
			s.Insert(str.charAt(index));
		System.out.println(s.FirstAppearingOnce());
	}

}
