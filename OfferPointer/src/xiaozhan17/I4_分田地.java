package xiaozhan17;

/**
 * 2018年4月19日 @author jiayuanan
牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，
作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多
 */
import java.util.Scanner;
public class I4_分田地{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	double num = scan.nextDouble();
        	int length = scan.nextInt();
        	System.out.println(num + " " +length);
        	System.out.printf(".2f%",num);
        }
        scan.close();
    }
}
