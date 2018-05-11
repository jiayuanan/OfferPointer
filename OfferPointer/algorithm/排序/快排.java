package ����;

/**
 * 2018��4��10�� @author jiayuanan
 * ����.java
 * 
 */
public class ���� {

}

class QuickSort {
    public static int divide(int[] a, int start, int end){  
        //ÿ�ζ������ұߵ�Ԫ����Ϊ��׼ֵ  
        int base = a[end];  
        //startһ������end����˵����������ָ��ϲ�����ͬһλ�ã����Խ�������ѭ����  
        while(start < end){  
            while(start < end && a[start] <= base)  
                //����߿�ʼ����������Ȼ�׼ֵС���ͼ���������  
                start++;  
            //�����whileѭ������ʱ����˵����ǰ��a[start]��ֵ�Ȼ�׼ֵ��Ӧ���׼ֵ���н���  
            if(start < end){  
                //����  
                int temp = a[start];  
                a[start] = a[end];  
                a[end] = temp;  
                //�����󣬴�ʱ���Ǹ���������ֵҲͬʱ��������ȷ��λ��(��׼ֵ�ұ�)������ұ�ҲҪͬʱ��ǰ�ƶ�һλ  
                end--;  
            }     
            while(start < end && a[end] >= base)  
                //���ұ߿�ʼ����������Ȼ�׼ֵ�󣬾ͼ���������  
                end--;  
            //�����whileѭ������ʱ����˵����ǰ��a[end]��ֵ�Ȼ�׼ֵС��Ӧ���׼ֵ���н���  
            if(start < end){  
                //����  
                int temp = a[start];  
                a[start] = a[end];  
                a[end] = temp;  
                //�����󣬴�ʱ���Ǹ���������ֵҲͬʱ��������ȷ��λ��(��׼ֵ���)��������ҲҪͬʱ����ƶ�һλ  
                start++;  
            }     
              
        }  
        //���ﷵ��start����end�Կɣ���ʱ��start��end��Ϊ��׼ֵ���ڵ�λ��  
        return end;  
    }  
  

    public static void sort(int[] a, int start, int end){  
        if(start > end){  
            //���ֻ��һ��Ԫ�أ��Ͳ���������ȥ��  
            return;  
        }   
        else{  
            //�����ֹһ��Ԫ�أ������������ߵݹ�������ȥ  
            int partition = divide(a, start, end);  
            sort(a, start, partition-1);  
            sort(a, partition+1, end);  
        }  
              
    }  
       
}
