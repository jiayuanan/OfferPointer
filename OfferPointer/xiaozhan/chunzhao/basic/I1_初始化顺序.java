package chunzhao.basic;

/**
 * 2018年4月14日 @author jiayuanan
 * I1_初始化顺序.java
 * 
 */
class Disp {
	static int cnt = 0;
	public Disp() {
		++cnt;
		System.out.println("display" + cnt);
	}
	public Disp(String s) {
		System.out.println(s);
	}
}
class Father {
	static {
		System.out.println("Father static block1");
	}
	{
		System.out.println("non static block1");
	}
	Disp fDisp = new Disp("haha");
	static Disp subDisp = new Disp();
	static {
		System.out.println("Father static block2");
	}
	{
		System.out.println("non static block2");
	}
}

class Son extends Father {
	static {
		System.out.println("Son static block");
	}
	static Disp sonDisp = new Disp();
}



public class I1_初始化顺序 {
	public static void main(String...args) {
		new Son();
	}
}
