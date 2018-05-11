package offerpointer3;

/**
 * 2018��3��27�� @author jiayuanan
 * item55:�ַ��е�һ�����ظ����ַ�
 * ������������ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 *         ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 *         �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
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
