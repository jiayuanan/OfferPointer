package offerpointer1;
//item2： 实现单例模式 2018.03.19
public class I02单例模式 {
	
}




//实例3，多线程，效率高
class Singleton {
	private Singleton() {
	}
	
	private volatile static Singleton single;
	
	public static Singleton getSingleton() {
		//下述代码块只在第一次加载时执行
		if(single == null) {
			synchronized(Singleton.class) {
				if(single == null)
					single = new Singleton();
			}
		}
		return single;
	}
}


//实例2，多线程，但效率低
class Singleton2 {
	private Singleton2() {
	}
	
	private static Singleton2 single;
	
	public synchronized Singleton2 getSingleton() {
		if(single == null)
			single = new Singleton2();
		return single;
	}
}


//实例1，只适用于单线程环境
class Singleton1 {
	private static  Singleton1 single;
	
	private Singleton1() {
		
	}
	
	public static Singleton1 getSingleton() {
		if(single == null) {
			single = new Singleton1();
		} 
		return single;
	}
}
