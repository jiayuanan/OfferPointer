package xiaozhan17;

/**
 * 2018年4月19日 @author jiayuanan
有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，
我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。
请帮助学者找出如何切分项链才能够拿到最多的宝石。
 */
//思路，从String的每位开始循环数，看最短需要几个可以组成ABCDE
import java.util.Scanner;
public class I62_彩色宝石项链{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String diamond = scan.nextLine();
        	int length = diamond.length();
        	int[] min = new int[length];
        	for(int i = 0; i < length; ++i) {//开始位置，
        		int exsit = 0; //用位运算，11111表示都存在
        		for(int j = 0; j < length; ++j) {//遍历个数；
        			char ch = diamond.charAt((i + j) % length);  //用取余实现循环
        			exsit |= 1 << (ch - 'A' );  //注意，这里用|运算
        			//System.out.println(exsit);
        			if((exsit & 31) == 31) {
        				min[i] = j + 1;
        				break;
        			}
        		}
        	}
        	int minLen = length;
        	for(int i = 0; i < length; ++i)
        		if(minLen > min[i])
        			minLen = min[i];
        	System.out.println(length - minLen);
        }
        scan.close();
    }
}
