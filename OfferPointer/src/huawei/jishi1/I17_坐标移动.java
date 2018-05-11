package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
输入：
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
坐标之间以;分隔。
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
下面是一个简单的例子 如：
A10;S20;W10;D30;X;A1A;B10A11;;A10;
处理过程：
起点（0,0）
+   A10   =  （-10,0）
+   S20   =  (-10,-20)
+   W10  =  (-10,-10)
+   D30  =  (20,-10)
+   x    =  无效
+   A1A   =  无效
+   B10A11   =  无效
+  一个空 不影响
+   A10  =  (10,-10)
结果 （10， -10）
输入描述:
一行字符串
输出描述:
最终坐标，以,分隔
 */
import java.util.Scanner;
public class I17_坐标移动 {
	//牛客网判题系统是采用循环判断的。。。所以全局变量无法用
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//第二次改动，加了hasNextLine()循环判断
		while(scan.hasNextLine()) {
			int x = 0;
			int y = 0;
			String[] orders = scan.nextLine().split(";");

			for(String order : orders) {
				try {
					int number = Integer.parseInt(order.substring(1));  //得到数字——需要进行异常处理
					//向左
					if(order.charAt(0) == 'A')
						x -= number;
					//向右
					if(order.charAt(0) == 'D')
						x += number;
					//向上
					if(order.charAt(0) == 'W')
						y += number;
					//向下
					if(order.charAt(0) == 'S')
						y -= number;
				} catch (Exception e) {
					continue;
				}
				
			}
			System.out.println(x + "," + y);
		}

	}

}


