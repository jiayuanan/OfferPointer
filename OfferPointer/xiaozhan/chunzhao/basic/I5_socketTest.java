package chunzhao.basic;

/**
 * 2018��4��15�� @author jiayuanan
 * I5_socketTest.java
 * 
 */
import java.net.*;
import java.io.*;
public class I5_socketTest {

}
//�����
class Server {
	public static void main(String...agrs) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			ServerSocket server = new ServerSocket(2000);//����ServerSocket����
			Socket socket = server.accept();          //��������ģʽ
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡ������
			pw = new PrintWriter(socket.getOutputStream(), true); //��ȡ�����
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

//�ͻ���
class Client {
	public static void main(String...args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket("localhost",2000);//ע�⣬������socket
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //��ȡ������
			pw = new PrintWriter(socket.getOutputStream(), true); //��ȡ�����
			pw.println("Hello");   //�������������Ϣ
			String s = null;
			while(true) {   //һֱ�ȴ����ջظ�
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