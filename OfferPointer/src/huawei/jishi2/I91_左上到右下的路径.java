package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I91_左上到右下的路径.java
 * 
 */
import java.util.Scanner;
public class I91_左上到右下的路径{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	int m = scan.nextInt();
        	//System.out.println(n + " " + m);
        	System.out.println(Paths(0, 0, n, m));
        }
        scan.close();
    }
    public static int Paths(int startX, int startY, int endX, int endY) {
    	if(startX == endX || startY == endY)
    		return 1;
    	return Paths(startX + 1, startY, endX, endY) + Paths(startX, startY + 1, endX, endY);
    }
}
/*
动态规划法
int main() {
    int m, n;
    while (cin >> m >> n) {
        vector<vector<int> > dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {    // 上边界
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {    // 左边界
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        cout << dp[n][m] << endl;
    }
 
    return 0;
}


*/