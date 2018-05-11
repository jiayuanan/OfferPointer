package huawei.jishi1;


/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
�������������ĺ�Ϊ����������������������֮Ϊ���������¡�����2��5��6��13��������Ӧ����ͨ�ż��ܡ�
��������ѧ���������һ�����򣬴����е�N��NΪż����������������ѡ�����ɶ���ɡ��������¡�����ѡ�������ֶ�����
������4����������2��5��6��13�������5��6��Ϊһ����ֻ�ܵõ�һ�顰�������¡�������2��5��6��13���齫�õ����顰�������¡�������ɡ��������¡����ķ�����Ϊ����ѷ�������
��Ȼ����ѧ��ϣ����Ѱ�ҳ�����ѷ�������
����:
��һ����ż��N��N��100������ʾ����ѡ����Ȼ���ĸ��������������������֣���ΧΪ[2,30000]��
���:
���һ������K����ʾ����õġ���ѷ�������ɡ��������¡��Ķ�����
��������:
����˵��
1 ����һ����ż��n
2 ����n������
�������:
��õġ���ѷ�������ɡ��������¡��Ķ�����
 */
//�������=��+ż�������Է�Ϊ���ѣ����ж���ͼ�����ƥ�䣬ʹ���������㷨
import java.util.Scanner;
import java.util.ArrayList;
public class I28_��������____����ͼ�����ƥ��_�������㷨 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			//��ȡ���е���
			int N = scan.nextInt();
			int[] numbers = new int[N];
			for(int i = 0; i < N; ++i)
				numbers[i] = scan.nextInt();
			//��ż����
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();
            for(int i = 0;i < N; i++){
                if (numbers[i] % 2 == 0) {           
                    evens.add(numbers[i]);
                }else {                          
                    odds.add(numbers[i]);
                }
            }
            //��������������ʼ���
            int[] evensMatch = new int[evens.size()]; //��ʾ���Ӧλ��ż����Ե�������λ��
            int result = 0;
            //int[] used = new int[evens.size()];  //������ʾż�������״������0��ʾδ�����
            for(int i = 0;i < odds.size(); i++){
                int[] used = new int[evens.size()];  //������ʾż�������״������0��ʾδ�����,ע������λ�ã�����������ˣ����ڱ�����ռ��ż����Ӧ����������ȥһһ��ռ��
                if (find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);
 
        }
	}
	
	public static boolean find(int x, ArrayList<Integer> evens, int[] used, int[] evensMatch) {
        int j;
        //�Դ���������������ż������һһƥ��
        for(j = 0;j < evens.size(); j++){
        	//���ܴ�����������Ҹ�ż����δ�����
            if (isPrime(x + evens.get(j)) && used[j] == 0) {
                used[j] = 1;
                //����ǰ����û�б���Ի��߱���Ե��������ҵ���һ��ż����������Գɹ�
                if (evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)) {
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
	
	
	//�����ж�
	public static boolean isPrime(int num) {
	    if (num == 2)
	        return true;
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0)
	            return false;
	    }
	    return true;
	}
}
