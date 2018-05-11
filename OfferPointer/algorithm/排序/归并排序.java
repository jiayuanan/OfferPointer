package 排序;

import java.util.Arrays;

/**
 * 2018年4月10日 @author jiayuanan
 * 归并排序.java
 * 
 */
public class 归并排序 {
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

        // 声明新的数组，临时储存归并结果
        int[] temp = new int[high - low + 1];
        int i = low; //左指针
        int k = 0;
        int j = mid + 1; //右指针
        // 把数从小到大先移到临时数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖原数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }

    }
}
