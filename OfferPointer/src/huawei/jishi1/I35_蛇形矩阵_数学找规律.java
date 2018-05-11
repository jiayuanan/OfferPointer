package huawei.jishi1;

/**
 * 2018年4月9日 @author jiayuanan
题目描述
题目说明
蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
样例输入
5
样例输出
1 3 6 10 15
2 5 9 14
4 8 13
7 12
11
接口说明
原型
void GetResult(int Num, char * pResult)
输入参数：
        int Num：输入的正整数N
输出参数：
        int * pResult：指向存放蛇形矩阵的字符串指针
                指针指向的内存区域保证有效
返回值：
        void
输入描述:
输入正整数N（N不大于100）
输出描述:
输出一个N行的蛇形矩阵。
 */
import java.util.Scanner;
public class I35_蛇形矩阵_数学找规律 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) { //需要写循环语句
			int length = scan.nextInt();
			
			int[][] matrix = new int[length][length];
			int numberInMatrix = 1;
			for(int i = 0; i < length; ++i) {
				int row = i; //应该新定义一个变量，开始直接用的i，导致死循环
				int column = 0;
				while(row >= 0) {
					//System.out.println(i);
					matrix[row][column] = numberInMatrix;
					//System.out.println(numberInMatrix);
					--row;
					++column;
					++numberInMatrix;
				}
			}
			//System.out.println(0);
			for(int i = 0; i < length; ++i) {
				for(int j = 0; j < length; ++j) {
					if(matrix[i][j] != 0) {
						if(j == 0) {
							System.out.print(matrix[i][j]);
						} else {
							System.out.print(" " +matrix[i][j]); 
						}
					} else 
						break;
				}
				System.out.println();
			}
		}

	}
}
