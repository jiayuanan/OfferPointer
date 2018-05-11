package offerpointer1;
//item3:�ڶ�ά�����в���һ����
/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class I03_�ڶ�ά�����в���һ���� {
	public static void main(String...args) {
		int[][] arr = new int[3][4];
		System.out.println(arr[0].length);
	}
}

class Solution3 {
    public boolean Find(int target, int [][] array) {
    	//�õ�����������
    	int rows = array.length;
    	int colomns = array[0].length;
    	if(array == null || colomns <= 0 || rows <= 0)
    		return false;
    	//�����Ͻǿ�ʼ����
    	int row = 0; 
    	int colomn = colomns -1;
    	//��������
    	while(row < rows && colomn >= 0) {
    		if(array[row][colomn] == target)
    			return true;
    		else if (array[row][colomn] < target)
    			++row;
    		else
    			--colomn;
    	}
    	return false;
    }
}
