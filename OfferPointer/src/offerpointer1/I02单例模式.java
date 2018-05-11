package offerpointer1;
//item2�� ʵ�ֵ���ģʽ 2018.03.19
public class I02����ģʽ {
	
}




//ʵ��3�����̣߳�Ч�ʸ�
class Singleton {
	private Singleton() {
	}
	
	private volatile static Singleton single;
	
	public static Singleton getSingleton() {
		//���������ֻ�ڵ�һ�μ���ʱִ��
		if(single == null) {
			synchronized(Singleton.class) {
				if(single == null)
					single = new Singleton();
			}
		}
		return single;
	}
}


//ʵ��2�����̣߳���Ч�ʵ�
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


//ʵ��1��ֻ�����ڵ��̻߳���
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
