package huawei.jishi1;

/**
 * 2018��4��9�� @author jiayuanan
����ָ�������������ַ������д���
��ϸ������
������������ַ����ϲ���
�Ժϲ�����ַ�����������Ҫ��Ϊ���±�Ϊ�������ַ����±�Ϊż�����ַ��ֱ��С��������
������±���˼���ַ����ַ����е�λ�á�
���������ַ������в���������ַ�Ϊ��0��������9�����ߡ�A��������F�����ߡ�a��������f������������������16���Ƶ�������BIT����Ĳ�������ת��Ϊ��Ӧ�Ĵ�д�ַ���
���ַ�Ϊ��4����Ϊ0100b����ת��Ϊ0010b��Ҳ����2��ת������ַ�Ϊ��2���� ���ַ�Ϊ��7����Ϊ0111b����ת��Ϊ1110b��Ҳ����e��ת������ַ�Ϊ��д��E����
����������str1Ϊ"dec"��str2Ϊ"fab"���ϲ�Ϊ��decfab�����ֱ�ԡ�dca���͡�efb���������������Ϊ��abcedf����ת����Ϊ��5D37BF��
�ӿ���Ƽ�˵����
����:�ַ�������
����:�����ַ���,��Ҫ�쳣����
���:�ϲ��������ַ���������Ҫ��ο��ĵ�
����:��
void ProcessString(char* str1,char *str2,char * strOutput)
��������:
���������ַ���
�������:
���ת����Ľ��
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class I30_�ַ����ϲ����� {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null) {
        	//�ϲ��ַ���
            String[] str=line.split(" ");
            String s=str[0]+str[1];
            //��ż����
            StringBuilder br1=new StringBuilder();
            StringBuilder br2=new StringBuilder();
            for(int i=0;i<s.length();i++) {
                if(i%2==0) {
                    br1.append(s.charAt(i));
                }
                else {
                    br2.append(s.charAt(i));
                }
            }
            //����
            char[] ch1=br1.toString().toCharArray();
            char[] ch2=br2.toString().toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            //������ϲ�
            char[] ch=new char[ch1.length+ch2.length];
            for(int i=0;i<ch.length;i++) {
                if(i%2==0) {
                    ch[i]=ch1[i/2];
                }
                else {
                    ch[i]=ch2[i/2];
                }
            }
            //ת��
            String password = "0123456789abcdefABCDEF";
            char[] dictionary = {'0','8','4','C','2','A','6','E','1','9','5','D','3','B','7','F','5','D','3','B','7','F'};
            for(int i=0;i<ch.length;i++) {
                if((ch[i]>='0'&&ch[i]<='9')||(ch[i]>='a'&&ch[i]<='f')||(ch[i]>='A'&&ch[i]<='F')) {
                    ch[i]=dictionary[password.indexOf(ch[i])];
                }
            }
            System.out.println(ch);
        }      
    }
}
