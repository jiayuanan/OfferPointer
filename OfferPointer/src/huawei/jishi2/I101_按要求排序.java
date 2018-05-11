package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
������������������ʶ������Ԫ�ذ�����������������
�ӿ�˵��
ԭ�ͣ�
void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
���������
    Integer[] pIntegerArray����������
int  iSortFlag�������ʶ��0��ʾ������1��ʾ������
���������
    ��
����ֵ��
    void
 */
import java.util.*;
public class I101_��Ҫ������{
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
        		for(int i = 0; i < length; ++i) {//����
            		if(first) {
            			System.out.print(array[i]);
            			first = false;
            		} else {
            			System.out.print(" " + array[i]);
            		}
        		}			
        	} else {  //����
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
