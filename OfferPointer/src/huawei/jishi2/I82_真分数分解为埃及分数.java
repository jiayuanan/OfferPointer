package huawei.jishi2;

/**
 * 2018��4��18�� @author jiayuanan
 * .java
��a��bΪ������������a<b ����a/b �������µĲ���ֽ�����ɸ���λ����֮�ͣ�
����һ����b����a��������q������r��r=b-a*q��
�������a/b = 1/(q+1) + (a-r)/b(q+1��
������������(a-r)/b(q+1),�ظ�һ�Ͷ���ֱ���ֽ����
 */
import java.util.*;
public class I82_������ֽ�Ϊ��������{
	   public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner in=new Scanner(System.in);
	        while(in.hasNext()){
	        String str=in.next();
	        Egyptsocre(str);
	        }
	 
	        }
	        public static void Egyptsocre(String str){
	        String[] parts=str.split("/");
	        int a=Integer.parseInt(parts[0]);//����
	        int b=Integer.parseInt(parts[1]);//��ĸ
	        StringBuilder sb=new StringBuilder();
	        int c;
           while (a != 1) {
               if (b % (a - 1) == 0) {
                   sb.append("1/").append(b / (a - 1)).append('+');
                   a = 1;
               } else {
                   c = b / a + 1; //��Ҫ��
                   sb.append("1/").append(c).append('+');
                   a = a * c - b;
                   b = c * b;          //�����ʽ��
                   if (b % a == 0) {
                       b = b / a;
                       a = 1;
                   }
               }
           }
           sb.append("1/").append(b);
           System.out.println(sb.toString());
       }
	
	
//���ַֽⷽʽ��ţ�����𰸲���	
/*    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String num = scan.next();
        	String[] nums = num.split("/");
        	ArrayList<Integer> fenzis = new ArrayList<>();
        	int a = Integer.parseInt(nums[0]);
        	int b = Integer.parseInt(nums[1]);
        	int q = b / a;
        	int r = b % a;
        	fenzis.add(q + 1);
        	while(a - r != 1) {
        		a = a - r;
        		b = b * (q + 1);
        		q = b / a;
        		r = b % a;
        		fenzis.add(q + 1);
        	}
        	fenzis.add(b * (q + 1));
        	
        	for(Integer i : fenzis)
        		System.out.println(i);
        }
        scan.close();
    }*/
}
