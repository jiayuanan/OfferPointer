package offerpointer1;

/**
 * 2018��3��20�� @author jiayuanan
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * n<=39
 */

class Solution9 {
    public int Fibonacci(int n) {
    	//�����ж�
    	if(n < 0)
    		throw new RuntimeException("n should be over 0");
    	if(n == 0)
    		return 0;
    	if(n == 1)
    		return 1;
    	
    	int first = 0; 
    	int second = 1;
    	while(n >= 1) {
    		second += first;
    		first = second - first;
    		--n;
    	}
    	return first;
    }
}



public class I09_쳲��������� {
	public static void main(String...args) {
		System.out.println(new Solution9().Fibonacci(3));
	}
}
