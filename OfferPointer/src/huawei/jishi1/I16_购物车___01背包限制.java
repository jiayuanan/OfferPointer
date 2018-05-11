package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
主件	附件
电脑	打印机，扫描仪
书柜	图书
书桌	台灯，文具
工作椅	无
如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。————————这里的附件个数指不同的，且题目里已限制好，无需特殊处理
王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。
他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
    设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
    请你帮助王强设计一个满足要求的购物单。
输入描述:
输入的第 1 行，为两个正整数，用一个空格隔开：N m
（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
（其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
输出描述:
 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 */ 
//01背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }   加以判断主附件
import java.util.Scanner;
 public class I16_购物车___01背包限制 {  
	    public static void main(String[] args) {  
	        Scanner scan = new Scanner(System.in);  
	  
	        int money = scan.nextInt(); //总钱数 
	        int number = scan.nextInt();  //总个数
	  
	        int[] price = new int[money];   //物品价格
	        int[] q = new int[money];   //物品附属编号
	        int[] value = new int[money];  //物品价值——价格*重要度
	 
	        //输入数据
	        for (int i = 0; i < number; i++) {  
	            price[i] = scan.nextInt();  
	            value[i] = scan.nextInt() * price[i];  
	            q[i] = scan.nextInt();  
	        }  
	  
	        System.out.println(f(price, value, q, number, money));  
	    }  
	  
	    public static int f(int[] price, int[] value, int[] q, int nunmber, int money) { 
	    	// 第一维：当前第几个物品；第二维：当前的背包承重；值：当前背包最大价值
	        int[][] dp = new int[nunmber + 1][money + 1];  //防止越界
	  
	        for (int i = 1; i <= nunmber; i++) {    //i与个数相关
	            for (int j = 1; j <= money; j++) {  //j与价格相关
	                if (q[i - 1] == 0) {  //主件 
	                    if (price[i - 1] <= j) {   //左边是不放第i个物品，右边是放第i个物品
	                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1]] + value[i - 1]);  //转移方程
	                    }     
	                }   else {  //附件
	                    if (price[i - 1] + price[q[i - 1]] < j) { //判断时要加上主件  ,同上
	                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1]] + value[i - 1]);  
	                    }  
	                }  
	            }  
	        }  
	        return dp[nunmber][money];  
	    }  
	  
	}  