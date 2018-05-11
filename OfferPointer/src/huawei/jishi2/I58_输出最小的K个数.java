package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
����n�����������������С��k����
��ϸ������
�ӿ�˵��
ԭ�ͣ�
bool GetMinK(unsignedint uiInputNum, int * pInputArray, unsignedint uiK, int * pOutputArray)
���������
     unsignedint uiInputNum //������������
int * pInputArray  //����������
unsignedint uiK   //�����uiK������
���������ָ��ָ����ڴ�����֤��Ч����
    int * pOutputArray //��С��uiK������
����ֵ��
        false �쳣ʧ��
          true  ����ɹ�
 */
import java.util.*;
public class I58_�����С��K����{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	//����
        	int length = scan.nextInt();
        	int value = scan.nextInt();
        	int[] num = new int[length];
        	for(int i = 0; i < length; ++i)
        		num[i] = scan.nextInt();
        	int[] minK = new int[value];
        	//����
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
    	while(pos != K) {  //ʹ�ÿ��ŵ�Partition����
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
    	//��ӡminK
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
    	return smallerPos; //����һ����Ϊrandom�����������е�λ��
    }
    
    public static void swap(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}
