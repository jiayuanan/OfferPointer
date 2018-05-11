package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
�������ٳ��ж���λͬѧ��ʹ��ʣ�µ�ͬѧ�ųɺϳ�����
˵����
Nλͬѧվ��һ�ţ�������ʦҪ�����е�(N-K)λͬѧ���У�ʹ��ʣ�µ�Kλͬѧ�ųɺϳ����Ρ� 
�ϳ�������ָ������һ�ֶ��Σ���Kλͬѧ���������α��Ϊ1��2����K�����ǵ���߷ֱ�ΪT1��T2������TK��   �����ǵ�����������i��1<=i<=K��ʹ��T1<T2<......<Ti-1<Ti>Ti+1>......>TK�� 
��������ǣ���֪����Nλͬѧ����ߣ�����������Ҫ��λͬѧ���У�����ʹ��ʣ�µ�ͬѧ�ųɺϳ����Ρ� 
��������:
����N

�������:
������Ҫ��λͬѧ����
 */
//��̬�滮���⡪������������
//˼·���ҵ����������������ֱ������ߵݼ�
import java.util.*;
public class I24_�ϳ���___���������� {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (scan.hasNext()) {
	        int num = scan.nextInt();
	        if(num <= 2){
	            System.out.println(0);
	        }
	        int[] members = new int[num];//�洢ÿһ������Ԫ��
	        int[] left_queue = new int[num];//����Ԫ�ش����Ҷ�Ӧ����������������
	        int[] right_queue = new int[num];//����Ԫ�ش��ҵ����Ӧ����������������
	       //��ʼ��������������
	        for(int i = 0; i < num; ++i) {
	        	members[i] = scan.nextInt();
	        	left_queue[i] = right_queue[i] = 1; //1ָ�䱾��
	        }

	        //����������������
	        for(int i = 0; i < num; ++i) {
	        	for(int j = 0; j < i; ++j) {
	        		if(members[i] > members[j] && left_queue[j] + 1 > left_queue[i])
	        			left_queue[i] = left_queue[j] + 1;    //һһ����left_queue[i]��ֵ,��ֵ��Ȼ��left_queue[j]���
	        	}
	        }
	        
	        //�����ݼ���������
	        for(int i = num - 1; i >= 0; --i) {
	        	for(int j = num - 1; j > i; --j ) {
	        		if(members[i] > members[j] && right_queue[i] < right_queue[j] + 1)
	        			right_queue[i] = right_queue[j] + 1;
	        	}
	        }

	        //�ܵ�������
	        int[] queue = new int[num];
	        int max = 0;
	        for(int i = 0; i < num; ++i) {
	        	queue[i] = left_queue[i] + right_queue[i];
	        	if(queue[i] > max)
	        		max = queue[i];
	        }
	        System.out.println(num - max + 1);
	    }
	}
}