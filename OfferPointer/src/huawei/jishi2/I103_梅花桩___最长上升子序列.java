package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
题目描述 
   Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
接口说明
方法原型：
    int GetResult(int num, int[] pInput, List  pResult);
输入参数：
   int num：整数，表示数组元素的个数（保证有效）。
   int[] pInput: 数组，存放输入的数字。
输出参数：
   List pResult: 保证传入一个空的List，要求把结果放入第一个位置。
返回值：
  正确返回1，错误返回0
 */
import java.util.*;
public class I103_梅花桩___最长上升子序列{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	int[] pInput = new int[num];
        	for(int i = 0; i < num; ++i) 
        		pInput[i] = scan.nextInt();

        	List<Integer> list = new ArrayList<>();
        	GetResult(num, pInput, list);
        }
        scan.close();
    }
    public static int GetResult(int num, int[] pInput, List  pResult) {
    	if(num == 0)
    		return 0;
    	int[] maxSteps = new int[num];
    	for(int i = 0; i < num - 1; ++i) {
    		maxSteps[i] = 1 + GetResultCore(pInput[i], i + 1, num, pInput);//递增序列就等于1 + 剩下的递增的
    		//System.out.println(maxSteps[i]);
    	}
    	int max = 0;
    	for(int i = 0; i < num; ++i)
    		if(maxSteps[i] > max)
    			max = maxSteps[i];
    	pResult.add(max);
    	System.out.println(max);  //输出结果
    	return 1;
    }
    
    public static int GetResultCore(int nowBiggest,int start, int num, int[] pInput) {
    	if(start >= num)
    		return 0;
    	else if(start == num - 1) {
    		if(pInput[start] <= nowBiggest)
    			return 0;
    		else
    			return 1;
    	} else {
    		if(pInput[start] <= nowBiggest)
    			return  GetResultCore(nowBiggest, start + 1, num, pInput);
    		else {
    			return Math.max(1 + GetResultCore(pInput[start], start + 1, num, pInput),  GetResultCore(nowBiggest, start + 1, num, pInput)); //转移矩阵
    		}
    	}
    }
}
