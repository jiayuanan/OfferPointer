package xiaozhan17;

/**
 * 2018年4月20日 @author jiayuanan
 * I11_不要2.java
 * 
 */
//思路：距离不能等于2，只有横向和纵向上距离才可能等于2，不用考虑斜向——找规律，标点
import java.util.Scanner;
public class I11_不要2{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int H = scan.nextInt();
        	int W = scan.nextInt();
        	int[][] table = new int[H + 1][W + 1];//方便描述
        	int result = 0;
        	for(int i = 1; i <= H; ++i) {
        		for(int j = 1; j <= W; ++j) {
        			//共8种情形
        			if(    (i % 4 == 1 && (j % 4 == 1 || j % 4 == 2)) || (i % 4 == 2 && (j % 4 == 1 || j % 4 == 2) )  )
        				++result;
        			if(    (i % 4 == 3 && (j % 4 == 3 || j % 4 == 0)) || (i % 4 == 0 && (j % 4 == 3 || j % 4 == 0) )  )
        				++result;
        		}
        	}
        	System.out.println(result);
        }
        scan.close();
    }
}
