package offerpointer2;

/**
 * 2018��3��26�� @author jiayuanan
 * item36:�����е������
 * �����������������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 *         ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 * ˼·��ʹ�ù鲢����ȥ���������
 */
//�����е�4��ȡ�࣬һ��������
class Solution36 {
    public static int InversePairs(int[] array) {
        if(array == null || array.length <= 0)
        	return 0;
        // ������������
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length); //��������
        int numberOfInversePairs = InversePairs(array, copy, 0, length - 1);
        
        int result = numberOfInversePairs % 1000000007;

        return result;

    }

    //array δ�鲢����  copy ���ڴ洢�鲢�����ݵ�����  begin ��ʼλ�� end ����λ��  ������
    public static int InversePairs(int[] array, int[] copy, int begin, int end) {
    	//�ݹ��������
        if(begin == end)
            return 0;
        int mid = (begin + end) / 2;
        // �ݹ����
        int left = InversePairs(copy, array, begin, mid) % 1000000007;
        int right = InversePairs(copy, array, mid + 1, end) % 1000000007;
        // �鲢����ʱ�������ź���
        int i = mid, j = end, pos = end;
        int count = 0; // ��¼�����������������
        
        while(i >= begin && j >= mid + 1)
        {
            if(array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
                if(count >= 1000000007)
                	count %= 1000000007;
            } else
                copy[pos--] = array[j--];
        }
        
        while(i >= begin)
            copy[pos--] = array[i--];
        while(j >= mid + 1)
            copy[pos--] = array[j--];
        
        return (left + right + count) % 1000000007;
    }
}
public class I36_�����е������___�鲢���� {
	//������
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 0)
        	return 0;
        long cnt = 0;
        for(int i = 0; i < array.length - 1; ++i) {
        	for(int j = i + 1; j < array.length; ++j)
        		if(array[i] > array[j])
        			++cnt;
        }
        
        return (int) (cnt % 1000000007);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,0};
		System.out.println(new Solution36().InversePairs(array));

        System.out.println(1<<31);


	}

}
