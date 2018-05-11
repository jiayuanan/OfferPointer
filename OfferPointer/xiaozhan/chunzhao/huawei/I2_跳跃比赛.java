package chunzhao.huawei;

/**
 * 2018年4月10日 @author jiayuanan
 * I2_跳跃比赛.java
 * 
 */

import java.util.*;

public class I2_跳跃比赛 {
	public static int min(int[] steps, int start, int end) {
		//递归结束条件——当一步就可以达到终点时
		if(start + steps[start] >= end)
			return 1; //一步之遥
		
		int min = 100;//取一个很大的数
		//使用递归
		int maxSteps = steps[start];
		for(int step = 1; step <= maxSteps; ++ step) {
			if(min(steps, start + step, end) < min)
				min = min(steps, start + step, end);
		}
		return 1 + min;
	}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//注意while处理多个case
        	//读取数据
    		int num = scan.nextInt();
    		int[] steps = new int[num];
    		for(int i = 0; i < num; ++i)
    			steps[i] = scan.nextInt();

    		int result = min(steps, 0, steps.length - 1);
        	System.out.println(result);
        }
        scan.close();
    }
}
