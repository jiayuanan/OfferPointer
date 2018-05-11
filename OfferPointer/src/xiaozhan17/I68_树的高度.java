package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * .java
��Ŀ����
������һ�úϷ��Ķ����������Ľڵ㶼�������ֱ�ʾ�����ڸ�������������еĸ��ӹ�ϵ����������ĸ߶�
��������:
����ĵ�һ�б�ʾ�ڵ�ĸ���n��1 �� n �� 1000���ڵ�ı��Ϊ0��n-1����ɣ�
������n-1�У�ÿ����������������һ������ʾ���ڵ�ı�ţ��ڶ�������ʾ�ӽڵ�ı��
�������:
������ĸ߶ȣ�Ϊһ������
 */
//˼·���ӽڵ�����ȸ��ڵ��1������һ��map����¼����
//������Ŀ����Ŀ������֤Ϊ������
//��������ȷ�Ľ����Ҫ����һ��map�����ӽڵ���������2��ʱ�����ԡ�������
import java.util.*;
public class I68_���ĸ߶�{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	HashMap<Integer, Integer> levelMap = new HashMap<>(); //�ֱ��Žڵ��źͶ�Ӧ����
        	HashMap<Integer, Integer> childNum = new HashMap<>();//�ֱ��ű�źͶ�Ӧ���ӽڵ����
        	//��������
        	levelMap.put(0, 1);
        	childNum.put(0, 0);
        	int number = scan.nextInt();
        	for(int i = 0; i < number - 1; ++i) {
        		int father = scan.nextInt();
        		int self = scan.nextInt();
        		//���Ҳ������ڵ㡪����ǰ��ĳ�������Ե��ˣ���������ӽڵ㳬���ˣ��ͺ��԰�
        		if(!levelMap.containsKey(father) || childNum.get(father) >= 2) 
        			continue;
        		//��������map��Ϣ
        		childNum.put(father, childNum.get(father) + 1);
        		levelMap.put(self, levelMap.get(father) + 1);
        		childNum.put(self, 0);   //��ʼ�������
        	}
        	int height = 1;
        	for(Integer i : levelMap.keySet())
        		if(levelMap.get(i) > height)
        			height = levelMap.get(i);
        	System.out.println(height);
        }
        scan.close();
    }
}
