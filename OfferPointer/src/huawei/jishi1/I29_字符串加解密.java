package huawei.jishi1;

/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
1����������ַ������мӽ��ܣ��������
2���ܷ���Ϊ��
��������Ӣ����ĸʱ���ø�Ӣ����ĸ�ĺ�һ����ĸ�滻��ͬʱ��ĸ�任��Сд,����ĸaʱ���滻ΪB����ĸZʱ���滻Ϊa��
������������ʱ��Ѹ����ּ�1����0�滻1��1�滻2��9�滻0��
�����ַ������仯��
3�����ܷ���Ϊ���ܵ�����̡�
�ӿ�������
    ʵ�ֽӿڣ�ÿ���ӿ�ʵ��1������������
void Encrypt (char aucPassword[], char aucResult[])���ڸú�����ʵ���ַ������ܲ����
˵����
1���ַ�����\0��β��
2���ַ����100���ַ���
int unEncrypt (char result[], char password[])���ڸú�����ʵ���ַ������ܲ����
˵����
1���ַ�����\0��β��
2���ַ����100���ַ���
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
   
public class I29_�ַ����ӽ��� {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line=br.readLine())!=null)
        {
             System.out.println(unEncrypt(line));
             
             line=br.readLine();
             System.out.println(unEncrypt(line));
        }
    }
  //�������
    public static String Encrypt(String line) {  
        StringBuilder  sb = new StringBuilder();
        char[] chars = line.toCharArray();
        for(int i=0;i<chars.length;++i)//Сд��ĸ
        {
            if(chars[i]>='a'&&chars[i]<='z'){
                if(chars[i] == 'z')
                    sb.append("A");
                else
                    sb.append((char)(chars[i]+1-32));
            }
            else if(chars[i]>='A'&&chars[i]<='Z'){//��д��ĸ
                if(chars[i] == 'Z')
                    sb.append("a");
                else
                    sb.append((char)(chars[i]+1+32));
            }
            else if(chars[i]>='0'&&chars[i]<='9')//����
                sb.append((chars[i]-48+1)%10);
            else
                sb.append(chars[i]);//����
        }
        return sb.toString();
    }
    private static String unEncrypt(String line) {    //����
        StringBuilder  sb = new StringBuilder();
        char[] chs = line.toCharArray();
        for(int i=0;i<chs.length;++i)
        {
            if(chs[i]>='a'&&chs[i]<='z'){
                if(chs[i] == 'a')
                    sb.append("Z");
                else
                    sb.append((char)(chs[i]-32-1));
            }
            else if(chs[i]>='A'&&chs[i]<='Z'){
                if(chs[i] == 'A')
                    sb.append("z");
                else
                    sb.append((char)(chs[i]+32-1));
            }
            else if(chs[i]>='0'&&chs[i]<='9')
                if(chs[i] == '0')
                    sb.append('9');
                else
                    sb.append(chs[i]-48-1);
            else
                sb.append(chs[i]);
        }
        return sb.toString();
    }
}
