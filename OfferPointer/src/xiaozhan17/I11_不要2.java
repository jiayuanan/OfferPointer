package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * I11_��Ҫ2.java
 * 
 */
//˼·�����벻�ܵ���2��ֻ�к���������Ͼ���ſ��ܵ���2�����ÿ���б�򡪡��ҹ��ɣ����
import java.util.Scanner;
public class I11_��Ҫ2{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int H = scan.nextInt();
        	int W = scan.nextInt();
        	int[][] table = new int[H + 1][W + 1];//��������
        	int result = 0;
        	for(int i = 1; i <= H; ++i) {
        		for(int j = 1; j <= W; ++j) {
        			//��8������
        			if(    (i % 4 == 1 && (j % 4 == 1 || j % 4 == 2)) || (i % 4 == 2 && (j % 4 == 1 || j % 4 == 2) )  )
        				++result;
        			if(    (i % 4 == 3 && (j % 4 == 3 || j % 4 == 0)) || (i % 4 == 0 && (j % 4 == 3 || j % 4 == 0) )  )
        				++result;
        		}
        	}
        	System.out.println(result);
        }
        scan.close();
    }
}
