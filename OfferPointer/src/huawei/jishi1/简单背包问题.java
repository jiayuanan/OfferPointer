package huawei.jishi1;

/**
 * 2018��4��10�� @author jiayuanan
 * �򵥱�������.java
 * 
 */

public class �򵥱������� {
    public static int f(int[] price, int[] value, int[] q, int nunmber, int money) { 
    	// ��һά����ǰ�ڼ�����Ʒ���ڶ�ά����ǰ�ı������أ�ֵ����ǰ��������ֵ
        int[][] dp = new int[nunmber + 1][money + 1];  //��ֹԽ��
  
        for (int i = 1; i <= nunmber; i++) {    //i��������
            for (int j = 1; j <= money; j++) {  //j��۸����
                    if (price[i - 1] <= j) {   //����ǲ��ŵ�i����Ʒ���ұ��Ƿŵ�i����Ʒ
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1]] + value[i - 1]);  //ת�Ʒ���
                    }     
            }     
        }  
        return dp[nunmber][money];  
    }  
}