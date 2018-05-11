package huawei.jishi2;

/**
 * 2018年4月12日 @author jiayuanan
输入整型数组和排序标识，对其元素按照升序或降序进行排序
接口说明
原型：
void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
输入参数：
    Integer[] pIntegerArray：整型数组
int  iSortFlag：排序标识：0表示按升序，1表示按降序
输出参数：
    无
返回值：
    void
 */
import java.util.*;
public class I101_按要求排序{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int length = scan.nextInt();
        	Integer[] array = new Integer[length];
        	for(int i = 0; i < length; ++i) 
        		array[i] = scan.nextInt();
        	int flag = scan.nextInt();
        	sortIntegerArray(array, flag);
        	boolean first = true;
        	if(flag == 0) {
        		for(int i = 0; i < length; ++i) {//正序
            		if(first) {
            			System.out.print(array[i]);
            			first = false;
            		} else {
            			System.out.print(" " + array[i]);
            		}
        		}			
        	} else {  //倒序
        		for(int i = length - 1; i >= 0; --i) {
            		if(first) {
            			System.out.print(array[i]);
            			first = false;
            		} else {
            			System.out.print(" " + array[i]);
            		}
        		}
        	}
        	System.out.println();
        }
        scan.close();
    }
    
    public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
    		Arrays.sort(pIntegerArray);
    }
}
