package offerpointer1;
//item3:在二维数组中查找一个数
/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class I03_在二维数组中查找一个数 {
	public static void main(String...args) {
		int[][] arr = new int[3][4];
		System.out.println(arr[0].length);
	}
}

class Solution3 {
    public boolean Find(int target, int [][] array) {
    	//得到行数和列数
    	int rows = array.length;
    	int colomns = array[0].length;
    	if(array == null || colomns <= 0 || rows <= 0)
    		return false;
    	//从右上角开始查找
    	int row = 0; 
    	int colomn = colomns -1;
    	//查找流程
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
