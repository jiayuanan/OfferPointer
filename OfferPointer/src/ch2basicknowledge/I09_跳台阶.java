package ch2basicknowledge;

/**
 * 2018年3月20日 @author jiayuanan
 * 牛客网的题目：跳台阶和变态跳台阶
 * 变态跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 说明：该题系统有bug，怎么都无法通过
 */
public class I09_跳台阶 {
	//找规律可破
    public static int JumpFloor(int target) {
        if(target <= 0)
            throw new RuntimeException("target should be above 0");
        return (int) Math.pow(2, target -1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(JumpFloor(3));
	}

}
