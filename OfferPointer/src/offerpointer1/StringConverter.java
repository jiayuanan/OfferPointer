package offerpointer1;
/*
 * ΢����������⣺
 * ��һ���ַ���ת����һ����
 */
public class StringConverter {
	public static int strToInt(String s) {
		int length = s.length();
		int num = 0;  //��ֵ
		boolean negtive = false; //�������
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
