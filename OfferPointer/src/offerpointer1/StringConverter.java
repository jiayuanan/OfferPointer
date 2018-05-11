package offerpointer1;
/*
 * 微软最常见面试题：
 * 将一个字符串转换成一个数
 */
public class StringConverter {
	public static int strToInt(String s) {
		int length = s.length();
		int num = 0;  //数值
		boolean negtive = false; //负数标记
		if (length == 0)
			try {
				throw new Exception("no length!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else 
			return 0;
		return length;
	}
	public static void main(String...args) {
		System.out.println("fuck");
	}
}
