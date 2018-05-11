package xiaozhan17;

/**
 * 2018年4月20日 @author jiayuanan
 * 小米2017：翻转句子
 * 
 */
import java.util.Scanner;
public class I67_翻转句子{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String sentence = scan.nextLine();
        	String[] words = sentence.split(" ");
        	int length = words.length;
        	for(int i = length - 1; i >= 0; --i) {
        		System.out.print(words[i]);
        		if(i != 0)
        			System.out.print(" ");
        	}
        		
        	System.out.println();
        }
        scan.close();
    }
}
