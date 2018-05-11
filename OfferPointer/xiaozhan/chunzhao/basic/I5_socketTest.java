package chunzhao.basic;

/**
 * 2018年4月15日 @author jiayuanan
 * I5_socketTest.java
 * 
 */
import java.net.*;
import java.io.*;
public class I5_socketTest {

}
//服务端
class Server {
	public static void main(String...agrs) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			ServerSocket server = new ServerSocket(2000);//创建ServerSocket对象
			Socket socket = server.accept();          //开启接听模式
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //获取输入流
			pw = new PrintWriter(socket.getOutputStream(), true); //获取输出流
			String s = br.readLine();
			pw.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (Exception e) {
				//
			}
		}
	}	
}

//客户端
class Client {
	public static void main(String...args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket("localhost",2000);//注意，这里是socket
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //获取输入流
			pw = new PrintWriter(socket.getOutputStream(), true); //获取输出流
			pw.println("Hello");   //向服务器发送信息
			String s = null;
			while(true) {   //一直等待接收回复
				s = br.readLine();
				if(s != null)
					break;
			}
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (Exception e) {
				//
			}
		}
	}
}