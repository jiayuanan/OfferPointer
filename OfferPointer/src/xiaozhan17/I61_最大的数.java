package xiaozhan17;

/**
 * 2018年4月19日 @author jiayuanan
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大
 * 
 */
//思路:从左到右找第一次出现比后面小的数，找到后就记录下这个数的位置，然后删除
import java.util.Scanner;
public class I61_最大的数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String num = scan.nextLine();
        	int cnt = Integer.parseInt(scan.nextLine());//注意输入描述
        	StringBuilder sb = new StringBuilder();
        	sb.append(num);
        	if(sb.length() <= cnt)
        		System.out.println(0);
        	while(cnt > 0) {
        		int pos = 0; //要删除的字符的位置
        		for(; pos < sb.length() - 1; ++pos) {
        			if(sb.charAt(pos) < sb.charAt(pos + 1)) {
        				break;
        			}
        		}     				
        		sb.deleteCharAt(pos);
        		--cnt;

        	}
        	System.out.println(sb);
        }
        scan.close();
    }
}
