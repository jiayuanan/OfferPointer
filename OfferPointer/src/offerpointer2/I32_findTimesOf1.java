package offerpointer2;

/**
 * 2018Äê3ÔÂ23ÈÕ @author jiayuanan
 *
 * 
 */
class Solution32 {
    public int NumberOf1Between1AndN_Solution(int n) {
    
    	return 0;
    }
}
public class I32_findTimesOf1 {
	//O(n2)
	int NumberOf1Between1AndN_Solution(int n)
	{
		int sum = 0;
		for (int i = 1; i <= n; ++i) {
			for(int j=i;j>=1;j/=10)
				if(j % 10== 1)
				    sum ++;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
