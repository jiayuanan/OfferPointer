package huawei.jishi1;

/**
 * 2018年4月9日 @author jiayuanan
题目描述
1、对输入的字符串进行加解密，并输出。
2加密方法为：
当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
其他字符不做变化。
3、解密方法为加密的逆过程。
接口描述：
    实现接口，每个接口实现1个基本操作：
void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
说明：
1、字符串以\0结尾。
2、字符串最长100个字符。
int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
说明：
1、字符串以\0结尾。
2、字符串最长100个字符。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
   
public class I29_字符串加解密 {
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
  //编码加密
    public static String Encrypt(String line) {  
        StringBuilder  sb = new StringBuilder();
        char[] chars = line.toCharArray();
        for(int i=0;i<chars.length;++i)//小写字母
        {
            if(chars[i]>='a'&&chars[i]<='z'){
                if(chars[i] == 'z')
                    sb.append("A");
                else
                    sb.append((char)(chars[i]+1-32));
            }
            else if(chars[i]>='A'&&chars[i]<='Z'){//大写字母
                if(chars[i] == 'Z')
                    sb.append("a");
                else
                    sb.append((char)(chars[i]+1+32));
            }
            else if(chars[i]>='0'&&chars[i]<='9')//数字
                sb.append((chars[i]-48+1)%10);
            else
                sb.append(chars[i]);//其他
        }
        return sb.toString();
    }
    private static String unEncrypt(String line) {    //解码
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
