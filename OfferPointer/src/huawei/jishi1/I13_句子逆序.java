package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
��һ��Ӣ������Ե���Ϊ��λ�����ŷš����硰I am a boy���������ŷź�Ϊ��boy a am I��
���е���֮����һ���ո����������г���Ӣ����ĸ�⣬���ٰ��������ַ�


�ӿ�˵��


 * ��ת����
 * 
 * @param sentence ԭ����
 * @return ��ת��ľ���
public String reverse(String sentence);

��������:
��һ��Ӣ������Ե���Ϊ��λ�����ŷš�

�������:
�õ�����ľ���  I13_reverseSentence
 */
import java.util.Scanner;
public class I13_�������� {
	public String reverse(String sentence) {
		String[] words = sentence.split(" ");
		String result = "";
		boolean first = true;
		
		//����ƴ��
		for(int i = (words.length - 1); i >= 0; --i) {
			if(first) {
				result += words[i];
				first = false;
			} else {
				result = result + " " + words[i];
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine();
		
		System.out.println(new I13_��������().reverse(sentence));
	}

}
