package xiaozhan17;

/**
 * 2018��4��19�� @author jiayuanan
 * .java
 * 
 */
import java.util.Scanner;
//˼·���ݹ飬����Ϊ���еڶ�����񡪡�����һ�㣬��Ҫ����������ȥ���������������������һ���󲽳����Խ�������ж�
public class I63_�������{
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
    					minStep = 1 + min[i + j]; //����ȡ����min������������steps
    			min[i] = minStep;
    		}
    	}
    	for(int i : min)
    		System.out.print(i + "   ");
    	System.out.println();
    	return min[0];
    }
    
    
    
    
    
    //�ݹ飬��ʱ
/*    public static int jump(int[] steps, int start, int end) {
    	if(start + steps[start] >= end)
    		return 1;
    	if(steps[start] == 0)
    		return steps.length + 1;   //��������ȥ��ȡһ���ܴ�����������ʱ�����ж�
    	int min = steps.length;
    	for(int step = 1; step <= steps[start]; ++step) {
    		if(jump(steps, start + step, end) < min)
    			min = jump(steps, start + step, end);
    	}
    	return 1 + min;
    }*/
}
