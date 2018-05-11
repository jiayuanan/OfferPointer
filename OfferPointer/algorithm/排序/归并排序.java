package ����;

import java.util.Arrays;

/**
 * 2018��4��10�� @author jiayuanan
 * �鲢����.java
 * 
 */
public class �鲢���� {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        new MergeSort().mergeSort(a);
    }
}
class MergeSort {
    public void mergeSort(int[] array) {
    	int[] a  = array.clone();
        sort(a, 0, array.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public void merge(int[] a, int low, int mid, int high) {

        // �����µ����飬��ʱ����鲢���
        int[] temp = new int[high - low + 1];
        int i = low; //��ָ��
        int k = 0;
        int j = mid + 1; //��ָ��
        // ������С�������Ƶ���ʱ������
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // �����ʣ�������������
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // ���ұ߱�ʣ�������������
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // ���������е�������ԭ����
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }

    }
}
