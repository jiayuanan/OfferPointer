package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * С��2017����ת����
 * 
 */
import java.util.Scanner;
public class I67_��ת����{
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
