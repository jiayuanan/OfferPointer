package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
��Ŀ���� 
   Redraiment����÷��׮�ĸ��֡�Redraiment������㲻�ޣ���ǰ�������ߵ�׮���ߣ����ߵĲ�����࣬��֪��Ϊʲô��������Redraiment�о�������ߵĲ�����
�ӿ�˵��
����ԭ�ͣ�
    int GetResult(int num, int[] pInput, List  pResult);
���������
   int num����������ʾ����Ԫ�صĸ�������֤��Ч����
   int[] pInput: ���飬�����������֡�
���������
   List pResult: ��֤����һ���յ�List��Ҫ��ѽ�������һ��λ�á�
����ֵ��
  ��ȷ����1�����󷵻�0
 */
import java.util.*;
public class I103_÷��׮___�����������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = scan.nextInt();
        	int[] pInput = new int[num];
        	for(int i = 0; i < num; ++i) 
        		pInput[i] = scan.nextInt();

        	List<Integer> list = new ArrayList<>();
        	GetResult(num, pInput, list);
        }
        scan.close();
    }
    public static int GetResult(int num, int[] pInput, List  pResult) {
    	if(num == 0)
    		return 0;
    	int[] maxSteps = new int[num];
    	for(int i = 0; i < num - 1; ++i) {
    		maxSteps[i] = 1 + GetResultCore(pInput[i], i + 1, num, pInput);//�������о͵���1 + ʣ�µĵ�����
    		//System.out.println(maxSteps[i]);
    	}
    	int max = 0;
    	for(int i = 0; i < num; ++i)
    		if(maxSteps[i] > max)
    			max = maxSteps[i];
    	pResult.add(max);
    	System.out.println(max);  //������
    	return 1;
    }
    
    public static int GetResultCore(int nowBiggest,int start, int num, int[] pInput) {
    	if(start >= num)
    		return 0;
    	else if(start == num - 1) {
    		if(pInput[start] <= nowBiggest)
    			return 0;
    		else
    			return 1;
    	} else {
    		if(pInput[start] <= nowBiggest)
    			return  GetResultCore(nowBiggest, start + 1, num, pInput);
    		else {
    			return Math.max(1 + GetResultCore(pInput[start], start + 1, num, pInput),  GetResultCore(nowBiggest, start + 1, num, pInput)); //ת�ƾ���
    		}
    	}
    }
}
