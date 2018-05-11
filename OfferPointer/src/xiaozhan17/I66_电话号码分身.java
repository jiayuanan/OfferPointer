package xiaozhan17;

/**
 * 2018��4��20�� @author jiayuanan
 * .java
 * 
 */
import java.util.Scanner;
//����һ�����͵����±����⡪����Ŀ���ѣ�ҪС��
public class I66_�绰�������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int num = Integer.parseInt(scan.nextLine());
        	String[] calls = new String[num];
        	for(int i = 0; i < num; ++i)
        		calls[i] = scan.nextLine();
        	
        	for(int i = 0; i < num; ++i)
        		System.out.println(converter(calls[i]));
        }
        scan.close();
    }
    //����ת���������±��룬�����ַ�������
    public static String converter(String s) {
    	int[] result = new int[10]; //�洢�������ĸ���
    	int length = s.length();
    	int numT = 0;
    	int numF = 0;
    	int numV = 0;
    	int numO = 0;
    	int numI = 0;
    	for(int i = 0; i < length; ++i) {
    		char ch = s.charAt(i);
    		switch(ch) {
    		case 'Z': ++result[0]; break;
    		case 'W': ++result[2]; break;
    		case 'X': ++result[6]; break;
    		case 'G': ++result[8]; break;  
    		case 'U': ++result[4]; break; 
    		case 'T': ++numT; break;
    		case 'F': ++numF; break;
    		case 'V': ++numV; break;
    		case 'O': ++numO; break;
    		case 'I': ++numI; break;
    		default: break;
    		}
    	}
    	result[3] = numT - result[2] - result[8];
    	result[5] = numF - result[4];
    	result[7] = numV - numF + result[4];
    	result[1] = numO - result[0] - result[2] - result[4];
    	result[9] = numI - result[6] - result[8] - result[5];
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < 10; ++i) {
    		for(int j = 0; j < result[(i + 8) % 10]; ++j) //�и���λ
    			sb.append(i);
    	}
    	return sb.toString();
    }
}
