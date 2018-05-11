package huawei.jishi2;

/**
 * 2018年4月18日 @author jiayuanan
 * .java
设a、b为互质正整数，a<b 分数a/b 可用以下的步骤分解成若干个单位分数之和：
步骤一：用b除以a，得商数q及余数r（r=b-a*q）
步骤二：a/b = 1/(q+1) + (a-r)/b(q+1）
步骤三：对于(a-r)/b(q+1),重复一和二，直到分解完毕
 */
import java.util.*;
public class I82_真分数分解为埃及分数{
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
	        int a=Integer.parseInt(parts[0]);//分子
	        int b=Integer.parseInt(parts[1]);//分母
	        StringBuilder sb=new StringBuilder();
	        int c;
           while (a != 1) {
               if (b % (a - 1) == 0) {
                   sb.append("1/").append(b / (a - 1)).append('+');
                   a = 1;
               } else {
                   c = b / a + 1; //重要点
                   sb.append("1/").append(c).append('+');
                   a = a * c - b;
                   b = c * b;          //计算分式子
                   if (b % a == 0) {
                       b = b / a;
                       a = 1;
                   }
               }
           }
           sb.append("1/").append(b);
           System.out.println(sb.toString());
       }
	
	
//这种分解方式和牛客网答案不符	
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
