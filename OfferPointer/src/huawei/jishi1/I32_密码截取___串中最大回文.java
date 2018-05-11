package huawei.jishi1;

/**
 * 2018年4月9日 @author jiayuanan
题目描述
Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
输入描述:
输入一个字符串
输出描述:
返回有效密码串的最大长度
 */
//求字符串中的最大回文——manacher算法(1975年，马拉车算法)
import java.io.*;
import java.util.*;
public class I32_密码截取___串中最大回文 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
         String s = in.nextLine();
         System.out.println(manacher(s));   
        }
         
     }
      
     public static int manacher(String s) {
         int maxLength =0;//记录最大回文
         StringBuffer sb = new StringBuffer();
         char[] c =s.toCharArray();
         sb.append("#");//防止越界
         //对字符串进行封装
         for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
         }
         int[] radius = new int[sb.length()];//记录新字符串以每个字符为中心的最大回文半径
         char[] cl = sb.toString().toCharArray();
         int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
         int id=0;//记录回文半径能到达最有端的回文字符串的中心
         for (int i = 1; i < cl.length; i++) {
            if (i < max) {
                radius[i]=Math.min(radius[2*id-i], max-i);  //算法的核心在这一句——左边是i关于id的对称点，右边是i到max的距离；在两者中间
            }else {
                radius[i]=1;
            }
            while (i-radius[i]>=0 && i+radius[i]<cl.length && cl[(i-radius[i])]==cl[(i+radius[i])]) {
                radius[i]++;
            }
            if (i+radius[i]>max) { //更新max和id
                max=i+radius[i];
                id=i;
            }
            maxLength=Math.max(maxLength, radius[i]-1);  //rad[i]-1代表回文长度
         }
          
          
         return maxLength;
      }
      
}
