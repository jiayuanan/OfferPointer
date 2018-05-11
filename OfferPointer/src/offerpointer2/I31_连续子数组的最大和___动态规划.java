package offerpointer2;

/**
 * 2018��3��23�� @author jiayuanan
 * item31:���������������
 * ������������������������������,������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 *         ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ˼·������ǰN����������<0�������������ں�����ڵĸ��������ȱ���һ�����ֵ���ڶԱȣ����Ӷ�O(n)
 */
class Solution31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
        	return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; ++i) {
        	//ǰn��ʹ���0��������������
        	if(sum <= 0)
        		sum = array[i];
        	else
        		sum += array[i];
        	//����ʵʱ���ֵ
        	if(sum > max)
        		max = sum;
        }
        
        return max;
    }
}
//��̬�滮����
class MySolution31{
	public  int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0]; //��¼��ǰ����������ĺ͵����ֵ
        int sum=array[0];   //����array[i]�������������ֵ
        for (int i = 1; i < array.length; i++) {
            sum=Math.max(sum+array[i], array[i]); //sum<=0ʱ���¿�ʼ��
            max=Math.max(sum, max);      //�Ա�
        }
        return max;
}
}
public class I31_���������������___��̬�滮 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(new Solution31().FindGreatestSumOfSubArray(array));
	}

}
