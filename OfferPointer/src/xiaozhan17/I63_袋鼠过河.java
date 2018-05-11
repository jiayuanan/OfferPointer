package xiaozhan17;

/**
 * 2018年4月19日 @author jiayuanan
 * .java
 * 
 */
import java.util.Scanner;
//思路：递归，跟华为春招第二题很像——更难一点，需要考虑跳不过去的情况；针对这种情况，给一个大步长，对结果进行判断
public class I63_袋鼠过河{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	int[] steps = new int[num];
        	for(int i = 0; i < num; ++i)
        		steps[i] = scan.nextInt();
/*        	if(jump(steps) > num)
        		System.out.println(-1);
        	else*/
        		System.out.println(jump(steps));
        }
        scan.close();
    }
    public static int jump(int[] steps) {
    	int length = steps.length;
    	int[] min = new int[length];
    	for(int i = length - 1; i >= 0; --i) {
    		if(steps[i] + i >= length)
    			min[i] = 1;
    		else if (steps[i] == 0){
    			min[i] = length + 1;
    		} else {
    			int minStep = length + 1;
    			for(int j = 1; j <= steps[i]; ++j)
    				if(1 + min[i + j] < minStep)
    					minStep = 1 + min[i + j]; //这里取数组min，而不是数组steps
    			min[i] = minStep;
    		}
    	}
    	for(int i : min)
    		System.out.print(i + "   ");
    	System.out.println();
    	return min[0];
    }
    
    
    
    
    
    //递归，超时
/*    public static int jump(int[] steps, int start, int end) {
    	if(start + steps[start] >= end)
    		return 1;
    	if(steps[start] == 0)
    		return steps.length + 1;   //若跳不过去，取一个很大的数，在输出时进行判断
    	int min = steps.length;
    	for(int step = 1; step <= steps[start]; ++step) {
    		if(jump(steps, start + step, end) < min)
    			min = jump(steps, start + step, end);
    	}
    	return 1 + min;
    }*/
}
