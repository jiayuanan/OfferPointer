package offerpointer3;

/**
 * 2018年3月26日 @author jiayuanan
 * item46:求1+2+3+4+……+n
 * 问题描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路：使用与运算 截断功能
 */
class Solution46 {
    public int Sum_Solution(int n) {
        int result = n;
        boolean helper = (result > 0) && (result += Sum_Solution(n - 1)) > 0; //Java里缺少部分类型转换，必须补全
        return result;
    }
}
public class I46_sumOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution46().Sum_Solution(5));
	}

}
