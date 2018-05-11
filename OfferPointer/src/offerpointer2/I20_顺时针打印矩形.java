package offerpointer2;

/**
 * 2018年3月21日 @author jiayuanan
 * item20:顺时针打印矩形
 * 问题描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 思路：剥洋葱一样，一圈一圈；每圈分为4个步骤；难度在于确定边界条件和循环退出条件
 * 编程中问题：1.注意4行中有3行不一定存在，需要判断；
 *           2.四角上的点可能会被重复打印，需要在判断语句中判定——尤其是第四行，左下和左上两个点需要避免重新打印
 *           3.长和宽要对应好了，这个我从头到尾混淆了无数次
 */

import java.util.ArrayList;
class Solution20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix == null) 
    	   return null;
       ArrayList<Integer> result = new ArrayList<>();
       
       int endX = matrix[0].length - 1;    //开始X与Y弄反了，一定注意Y在第一位，X在第二位
       int endY = matrix.length - 1;
       int start = 0;//每个循环的起始点，横纵坐标相同；
       int circle = (Math.min(endX + 1, endY + 1) + 1) / 2; //循环的圈数, endX和endY后面的+1不能忘了
       while(circle-- > 0) {
    	   //从左到右打印一行
    	   for(int i = start; i <= endX; ++i ) {
    		   result.add(matrix[start][i]);
    	   }
    		   
    	   //从右上到右下打印一行——需要提前判断
    	   if(endY > start) {
    		   for(int i = start + 1; i <= endY; ++i)
    			   result.add(matrix[i][endX]);
    	   }
    	   //从右下到左下打印一下——需要提前判断
    	   if(endX > start && endY >start) {//注意第二个边界条件
    		   for(int i = endX - 1; i >= start; --i) 
    			   result.add(matrix[endY][i]); //这边endX与endY弄混了
    	   }
    	   //从左下到左上打印一行——需提前判断
    	   if(endX > start && endY > start + 1) { //注意第二个边界条件
    		   for(int i = endY - 1; i >= start + 1; --i)
    			   result.add(matrix[i][start]);
    	   }
    	   ++start;--endX;--endY;
       }     
       return result;
    }
}


public class I20_顺时针打印矩形 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] test = { {1},{2},{3},{4},{5}};
		//System.out.println(new Solution().printMatrix(matrix));
		
		int[][] test1 = {{1}};
		//System.out.println(new Solution().printMatrix(test1));
		
		int[][] test2 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
		System.out.println(new Solution20().printMatrix(test2));
	}

}
