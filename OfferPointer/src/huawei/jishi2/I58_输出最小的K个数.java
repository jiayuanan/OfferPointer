package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
输入n个整数，输出其中最小的k个。
详细描述：
接口说明
原型：
bool GetMinK(unsignedint uiInputNum, int * pInputArray, unsignedint uiK, int * pOutputArray)
输入参数：
     unsignedint uiInputNum //输入整数个数
int * pInputArray  //输入整数数
unsignedint uiK   //需输出uiK个整数
输出参数（指针指向的内存区域保证有效）：
    int * pOutputArray //最小的uiK个整数
返回值：
        false 异常失败
          true  输出成功
 */
import java.util.*;
public class I58_输出最小的K个数{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	//输入
        	int length = scan.nextInt();
        	int value = scan.nextInt();
        	int[] num = new int[length];
        	for(int i = 0; i < length; ++i)
        		num[i] = scan.nextInt();
        	int[] minK = new int[value];
        	//处理
        	GetMinK(length, num, value, minK);
        }
        scan.close();
    }
    public static boolean GetMinK(int length, int[] num, int K, int[] minK) {
    	if(length <= 0 || K <= 0 || K > length)
    		return false;
    	int pos = -1;
		int start = 0;
		int end = length - 1;
    	while(pos != K) {  //使用快排的Partition函数
    		pos = Partition(num, start, end);
    		if(pos > K) {
    			end = pos - 1;
    		} else if (pos < K) {
    			start = pos + 1;
    		}
    	}
    	for(int i = 0; i < K; ++i)
    		minK[i] = num[i];
    	Arrays.sort(minK);
    	//打印minK
    	boolean first = true;
    	for(int i :minK) {
    		if(first) {
    			System.out.print(i);
    			first = false;
    		} else {
    			System.out.print(" " + i);
    		}
    	}
    	System.out.println();
    	return true;
    }
    public static int Partition(int[] array, int start, int end) {
    	int random = array[end];
    	int smallerPos = start;
    	for(int i = start; i < end; ++i) {
    		if(array[i] <= random) {
    			if(i != smallerPos)
    				swap(array, i, smallerPos++);
    			else
    				smallerPos++;
    		}
    	}
    	swap(array, smallerPos, end);
    	return smallerPos; //再下一个则为random在排序数组中的位置
    }
    
    public static void swap(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}
