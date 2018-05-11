package offerpointer2;

/**
 * 2018��3��21�� @author jiayuanan
 * item20:˳ʱ���ӡ����
 * ��������������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * ˼·�������һ����һȦһȦ��ÿȦ��Ϊ4�����裻�Ѷ�����ȷ���߽�������ѭ���˳�����
 * ��������⣺1.ע��4������3�в�һ�����ڣ���Ҫ�жϣ�
 *           2.�Ľ��ϵĵ���ܻᱻ�ظ���ӡ����Ҫ���ж�������ж����������ǵ����У����º�������������Ҫ�������´�ӡ
 *           3.���Ϳ�Ҫ��Ӧ���ˣ�����Ҵ�ͷ��β������������
 */

import java.util.ArrayList;
class Solution20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix == null) 
    	   return null;
       ArrayList<Integer> result = new ArrayList<>();
       
       int endX = matrix[0].length - 1;    //��ʼX��YŪ���ˣ�һ��ע��Y�ڵ�һλ��X�ڵڶ�λ
       int endY = matrix.length - 1;
       int start = 0;//ÿ��ѭ������ʼ�㣬����������ͬ��
       int circle = (Math.min(endX + 1, endY + 1) + 1) / 2; //ѭ����Ȧ��, endX��endY�����+1��������
       while(circle-- > 0) {
    	   //�����Ҵ�ӡһ��
    	   for(int i = start; i <= endX; ++i ) {
    		   result.add(matrix[start][i]);
    	   }
    		   
    	   //�����ϵ����´�ӡһ�С�����Ҫ��ǰ�ж�
    	   if(endY > start) {
    		   for(int i = start + 1; i <= endY; ++i)
    			   result.add(matrix[i][endX]);
    	   }
    	   //�����µ����´�ӡһ�¡�����Ҫ��ǰ�ж�
    	   if(endX > start && endY >start) {//ע��ڶ����߽�����
    		   for(int i = endX - 1; i >= start; --i) 
    			   result.add(matrix[endY][i]); //���endX��endYŪ����
    	   }
    	   //�����µ����ϴ�ӡһ�С�������ǰ�ж�
    	   if(endX > start && endY > start + 1) { //ע��ڶ����߽�����
    		   for(int i = endY - 1; i >= start + 1; --i)
    			   result.add(matrix[i][start]);
    	   }
    	   ++start;--endX;--endY;
       }     
       return result;
    }
}


public class I20_˳ʱ���ӡ���� {

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
