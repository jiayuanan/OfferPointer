package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。 
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
输入描述:
整数N

输出描述:
最少需要几位同学出列
 */
//动态规划问题——递增子序列
//思路：找到数组中最大的数，分别向两边递减
import java.util.*;
public class I24_合唱团___递增子序列 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	        int num = scan.nextInt();
	        if(num <= 2){
	            System.out.println(0);
	        }
	        int[] members = new int[num];//存储每一个数据元素
	        int[] left_queue = new int[num];//数据元素从左到右对应的最大递增子序列数
	        int[] right_queue = new int[num];//数据元素从右到左对应的最大递增子序列数
	       //初始化各个数组数据
	        for(int i = 0; i < num; ++i) {
	        	members[i] = scan.nextInt();
	        	left_queue[i] = right_queue[i] = 1; //1指其本身
	        }

	        //求最大递增子序列数
	        for(int i = 0; i < num; ++i) {
	        	for(int j = 0; j < i; ++j) {
	        		if(members[i] > members[j] && left_queue[j] + 1 > left_queue[i])
	        			left_queue[i] = left_queue[j] + 1;    //一一更新left_queue[i]的值,其值必然与left_queue[j]相关
	        	}
	        }
	        
	        //求最大递减子序列数
	        for(int i = num - 1; i >= 0; --i) {
	        	for(int j = num - 1; j > i; --j ) {
	        		if(members[i] > members[j] && right_queue[i] < right_queue[j] + 1)
	        			right_queue[i] = right_queue[j] + 1;
	        	}
	        }

	        //总的最大，求和
	        int[] queue = new int[num];
	        int max = 0;
	        for(int i = 0; i < num; ++i) {
	        	queue[i] = left_queue[i] + right_queue[i];
	        	if(queue[i] > max)
	        		max = queue[i];
	        }
	        System.out.println(num - max + 1);
	    }
	}
}