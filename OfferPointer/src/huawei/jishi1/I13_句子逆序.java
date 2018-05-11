package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符


接口说明


 * 反转句子
 * 
 * @param sentence 原句子
 * @return 反转后的句子
public String reverse(String sentence);

输入描述:
将一个英文语句以单词为单位逆序排放。

输出描述:
得到逆序的句子  I13_reverseSentence
 */
import java.util.Scanner;
public class I13_句子逆序 {
	public String reverse(String sentence) {
		String[] words = sentence.split(" ");
		String result = "";
		boolean first = true;
		
		//反向拼接
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
		
		System.out.println(new I13_句子逆序().reverse(sentence));
	}

}
