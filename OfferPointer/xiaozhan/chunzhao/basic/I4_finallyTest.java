package chunzhao.basic;

/**
 * 2018Äê4ÔÂ15ÈÕ @author jiayuanan
 * I4_finallyTest.java
 * 
 */
public class I4_finallyTest {
public static void main(String...args) {
	System.out.println(FinallyTest.testFinally());
}
}

class FinallyTest {
	public static int testFinally () {
		try {
			int i = 5;
			if(i == 5)
				throw new Exception();
			return i;
		} catch (Exception e) {
			return 6;
		} finally {
			System.out.println("finally");
			//return 7;
			
		}
	}
}