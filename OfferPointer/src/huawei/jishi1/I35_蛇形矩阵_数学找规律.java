package huawei.jishi1;

/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
��Ŀ˵��
���ξ�������1��ʼ����Ȼ���������гɵ�һ�������������Ρ�
��������
5
�������
1 3 6 10 15
2 5 9 14
4 8 13
7 12
11
�ӿ�˵��
ԭ��
void GetResult(int Num, char * pResult)
���������
        int Num�������������N
���������
        int * pResult��ָ�������ξ�����ַ���ָ��
                ָ��ָ����ڴ�����֤��Ч
����ֵ��
        void
��������:
����������N��N������100��
�������:
���һ��N�е����ξ���
 */
import java.util.Scanner;
public class I35_���ξ���_��ѧ�ҹ��� {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) { //��Ҫдѭ�����
			int length = scan.nextInt();
			
			int[][] matrix = new int[length][length];
			int numberInMatrix = 1;
			for(int i = 0; i < length; ++i) {
				int row = i; //Ӧ���¶���һ����������ʼֱ���õ�i��������ѭ��
				int column = 0;
				while(row >= 0) {
					//System.out.println(i);
					matrix[row][column] = numberInMatrix;
					//System.out.println(numberInMatrix);
					--row;
					++column;
					++numberInMatrix;
				}
			}
			//System.out.println(0);
			for(int i = 0; i < length; ++i) {
				for(int j = 0; j < length; ++j) {
					if(matrix[i][j] != 0) {
						if(j == 0) {
							System.out.print(matrix[i][j]);
						} else {
							System.out.print(" " +matrix[i][j]); 
						}
					} else 
						break;
				}
				System.out.println();
			}
		}

	}
}
