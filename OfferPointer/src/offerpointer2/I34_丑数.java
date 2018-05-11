package offerpointer2;

/**
 * 2018年3月26日 @author jiayuanan
 * item34：丑数
 * 问题描述：把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

//空间换时间
class Solution34 {
    public int GetUglyNumber_Solution(int index) {
    	if(index <= 0)
    		return 0;
    	int[] uglyNumbers = new int[index + 1];
    	uglyNumbers[0] = 0;
    	uglyNumbers[1] = 1;
    	int uglyIndex = 1;
    	//下面找出满足条件的下一个丑数,其必是已有丑数的2,3,5倍
    	int two = 1, three = 1, five = 1;
    	
    	while(uglyIndex < index) {
    		//分别找出已存在的丑数*2，*3，*5，比已有的丑数大的最小的那个丑数
    		for(int i = uglyIndex; i >= 0; --i) {
    			if(2 * uglyNumbers[i] > uglyNumbers[uglyIndex] && 2 * uglyNumbers[i-1] <= uglyNumbers[uglyIndex]) { //注意后者是<=
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

//直接判断，复杂度过高
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
    //判断一个数是不是丑数
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
public class I34_丑数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution34().GetUglyNumber_Solution(1500));
	}

}
