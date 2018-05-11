package chunzhao.huawei;

/**
 * 2018��4��10�� @author jiayuanan
 * I2_��Ծ����.java
 * 
 */

import java.util.*;

public class I2_��Ծ���� {
	public static int min(int[] steps, int start, int end) {
		//�ݹ��������������һ���Ϳ��Դﵽ�յ�ʱ
		if(start + steps[start] >= end)
			return 1; //һ��֮ң
		
		int min = 100;//ȡһ���ܴ����
		//ʹ�õݹ�
		int maxSteps = steps[start];
		for(int step = 1; step <= maxSteps; ++ step) {
			if(min(steps, start + step, end) < min)
				min = min(steps, start + step, end);
		}
		return 1 + min;
	}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//ע��while������case
        	//��ȡ����
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
