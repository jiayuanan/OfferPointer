package chunzhao.basic;

/**
 * 2018年4月14日 @author jiayuanan
 * I3_接口.java
 * 
 */
public interface I3_接口 {
	public static final int i = 3;
	int j = 3;
	
	public abstract int sum();
	
	public static int add() {
		return 0;
	}
}

class TestInterface implements C,B{


	
}
interface a {
	default String testString() {
		System.out.println("A");
		return "A";
	}
}

interface B extends a {
/*	default String testString() {
		System.out.println("B");
		return "B";
	}*/
}

interface C extends a {
/*	default String testString() {
		System.out.println("C");
		return "C";
	}*/
}
