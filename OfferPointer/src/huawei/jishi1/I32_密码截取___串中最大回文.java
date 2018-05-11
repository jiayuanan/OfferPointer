package huawei.jishi1;

/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
Catcher��MCA�����鱨Ա��������ʱ���ֵй�����һЩ�ԳƵ��������ͨ�ţ���������ЩABBA��ABA��A��123321��
����������ʱ���ڿ�ʼ�����ʱ����һЩ�޹ص��ַ��Է�ֹ����ƽ⡣����������б仯 ABBA->12ABBA,ABA->ABAKK,123321->51233214����
��Ϊ�ػ�Ĵ�̫���ˣ����Ҵ��ڶ��ֿ��ܵ������abaaab�ɿ�����aba,��baaab�ļ�����ʽ����
Cathcer�Ĺ�����ʵ����̫���ˣ���ֻ������Ը������������ܰ�Catcher�ҳ������Ч���봮��
��������:
����һ���ַ���
�������:
������Ч���봮����󳤶�
 */
//���ַ����е������ġ���manacher�㷨(1975�꣬�������㷨)
import java.io.*;
import java.util.*;
public class I32_�����ȡ___���������� {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
         String s = in.nextLine();
         System.out.println(manacher(s));   
        }
         
     }
      
     public static int manacher(String s) {
         int maxLength =0;//��¼������
         StringBuffer sb = new StringBuffer();
         char[] c =s.toCharArray();
         sb.append("#");//��ֹԽ��
         //���ַ������з�װ
         for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
         }
         int[] radius = new int[sb.length()];//��¼���ַ�����ÿ���ַ�Ϊ���ĵ������İ뾶
         char[] cl = sb.toString().toCharArray();
         int max=0;//��¼�Ѿ���Ѱ���Ļ��İ뾶�ܵ����Ҷ˵�����ֵ
         int id=0;//��¼���İ뾶�ܵ������ж˵Ļ����ַ���������
         for (int i = 1; i < cl.length; i++) {
            if (i < max) {
                radius[i]=Math.min(radius[2*id-i], max-i);  //�㷨�ĺ�������һ�䡪�������i����id�ĶԳƵ㣬�ұ���i��max�ľ��룻�������м�
            }else {
                radius[i]=1;
            }
            while (i-radius[i]>=0 && i+radius[i]<cl.length && cl[(i-radius[i])]==cl[(i+radius[i])]) {
                radius[i]++;
            }
            if (i+radius[i]>max) { //����max��id
                max=i+radius[i];
                id=i;
            }
            maxLength=Math.max(maxLength, radius[i]-1);  //rad[i]-1������ĳ���
         }
          
          
         return maxLength;
      }
      
}
