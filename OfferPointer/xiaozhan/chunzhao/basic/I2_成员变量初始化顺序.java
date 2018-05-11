package chunzhao.basic;

/**
 * 2018年4月14日 @author jiayuanan
 * I2_成员变量初始化顺序.java
 * 
 */
class Test1 {
	public Test1() {
		System.out.println("Test1");
	}
}
class Test2 {
	static int i;
	static interface in {
		
	}
	public Test2() {
		System.out.println("Test2");
	}
}
class Test {
	Test2 t2;
	Test1 t1;
	public Test(Test1 t1, Test2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
}
public class I2_成员变量初始化顺序 {
	public static void main(String...args) {
		Test1 t1 = new Test1();
		Test2 t2 = new Test2();
		new Test(t1,t2);
		Class<?> c = Integer.class;
		System.out.println(new Test1().getClass().getSuperclass().getName());
	}
}
