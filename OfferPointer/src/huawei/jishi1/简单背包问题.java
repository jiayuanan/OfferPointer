package huawei.jishi1;

/**
 * 2018年4月10日 @author jiayuanan
 * 简单背包问题.java
 * 
 */

public class 简单背包问题 {
    public static int f(int[] price, int[] value, int[] q, int nunmber, int money) { 
    	// 第一维：当前第几个物品；第二维：当前的背包承重；值：当前背包最大价值
        int[][] dp = new int[nunmber + 1][money + 1];  //防止越界
  
        for (int i = 1; i <= nunmber; i++) {    //i与个数相关
            for (int j = 1; j <= money; j++) {  //j与价格相关
                    if (price[i - 1] <= j) {   //左边是不放第i个物品，右边是放第i个物品
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1]] + value[i - 1]);  //转移方程
                    }     
            }     
        }  
        return dp[nunmber][money];  
    }  
}