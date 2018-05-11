package xiaozhan17;

import java.util.Scanner;

/**
 * 2018年4月7日 @author jiayuanan
 * item:水仙花数
 * 问题描述：“水仙花数”是指一个三位数，它的各位数字的立方和等于其本身
 */
public class I65_水仙花数 {
	public void solution(int min, int max) {
		boolean first = true;
		int cnt = 0;
		for(int i = min; i <= max; ++i) {
			
		
			int x = i % 100 % 10;   //这不不能错
			int y = i /10 % 10;
			int z = i / 100;
			
			
			//System.out.println(z + " " + y + " " + x);
			if( x*x*x + y*y*y + z*z*z == i) {
				++cnt;
				if(first) 
					first = false;
				else
					System.out.print(" ");	
				System.out.print(i);
			}
				
		}
		if(cnt == 0)
			System.out.println("no");
		else 
			System.out.println();
	}
	
	
	public static void main(String...args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
			new I65_水仙花数().solution(m, n);
		}

	}
}
