package ch6differentAblities;



/**
 * 2018��3��26�� @author jiayuanan
 * item49:�������ظ�����
 * ������������һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 *         ���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
import java.util.HashSet;
class Solution51 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(numbers == null || length <= 1)
    		return false;
    	HashSet<Integer> set =new HashSet<>();
    	for(int i = 0; i < length; ++i) {
    		if(set.contains(numbers[i])) {
    			duplication[0] = numbers[i];
    			return true;
    		} else {
    			set.add(numbers[i]);
    		}
    	}
    	return false;
    }
}
public class I51_�������ظ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2,3,1,0,2,5,3};
		int[] duplication = new int[1];
		System.out.println(new Solution51().duplicate(numbers, numbers.length, duplication));
		System.out.println(duplication[0]);

	}

}
