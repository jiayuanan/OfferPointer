package offerpointer2;

/**
 * 2018��3��26�� @author jiayuanan
 * item34������
 * ������������ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */

//�ռ任ʱ��
class Solution34 {
    public int GetUglyNumber_Solution(int index) {
    	if(index <= 0)
    		return 0;
    	int[] uglyNumbers = new int[index + 1];
    	uglyNumbers[0] = 0;
    	uglyNumbers[1] = 1;
    	int uglyIndex = 1;
    	//�����ҳ�������������һ������,��������г�����2,3,5��
    	int two = 1, three = 1, five = 1;
    	
    	while(uglyIndex < index) {
    		//�ֱ��ҳ��Ѵ��ڵĳ���*2��*3��*5�������еĳ��������С���Ǹ�����
    		for(int i = uglyIndex; i >= 0; --i) {
    			if(2 * uglyNumbers[i] > uglyNumbers[uglyIndex] && 2 * uglyNumbers[i-1] <= uglyNumbers[uglyIndex]) { //ע�������<=
    				two = 2 * uglyNumbers[i];
    				//System.out.print(2);
    				break;
    			}
    		}

    		for(int i = uglyIndex; i >= 0; --i) {
    			if(3 * uglyNumbers[i] > uglyNumbers[uglyIndex] && 3 * uglyNumbers[i-1] <= uglyNumbers[uglyIndex]) {
    				three = 3 * uglyNumbers[i];
    				//System.out.print(3);
    				break;
    			}
    		}

    		for(int i = uglyIndex; i >= 0; --i) {
    			if(5 * uglyNumbers[i] > uglyNumbers[uglyIndex] && 5 * uglyNumbers[i-1] <= uglyNumbers[uglyIndex]) {
    				five = 5 * uglyNumbers[i];
    				//System.out.print(5);
    				break;
    			}
    		}

    		uglyNumbers[++uglyIndex] = min(two,three,five);
    		//System.out.println();
    	}
    	
    	return uglyNumbers[index];
    }
    
    public int min(int i, int j, int k) {
    	int min = i < j ? i : j;
    	return min < k ? min : k;
    }
}

//ֱ���жϣ����Ӷȹ���
class MySolution34 {
    public int GetUglyNumber_Solution(int index) {
    	if(index <= 0)
    		return 0;
    	if(index == 1)
    		return 1;
    	int cnt = 1;
    	int i;
    	for(i = 2; cnt != index; ++i) {
    		if(isUgly(i))
    			++cnt;
    	}
    	return i;
    }
    //�ж�һ�����ǲ��ǳ���
    public boolean isUgly(int num) {
    	while(true) {
    		if(num % 2 == 0) {
    			num /= 2;
    		} else if (num % 3 == 0) {
    			num /= 3;
    		} else if (num % 5 == 0) {
    			num /= 5;
    		} else if (num == 1) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
}
public class I34_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution34().GetUglyNumber_Solution(1500));
	}

}
