package huawei.jishi1;


/**
 * 2018��4��9�� @author jiayuanan
��Ŀ����
��һ�ּ��ɿ��Զ����ݽ��м��ܣ���ʹ��һ��������Ϊ�����ܳס�
���������Ĺ���ԭ�����ȣ�ѡ��һ��������Ϊ�ܳף���TRAILBLAZERS����������а������ظ�����ĸ��ֻ������1�������༸�����������ڣ��޸Ĺ����Ǹ�����������ĸ������棬������ʾ��
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
������������ĸ����ʣ�����ĸ����������ڶ���Ϣ���м���ʱ����Ϣ�е�ÿ����ĸ���̶��ڶ������У������������еĶ�Ӧ��ĸһһȡ��ԭ�ĵ���ĸ(��ĸ�ַ��Ĵ�Сд״̬Ӧ�ñ���)��
��ˣ�ʹ������ܳף�Attack AT DAWN(����ʱ����)�ͻᱻ����ΪTpptad TP ITVH��
��ʵ�������ӿڣ�ͨ��ָ�����ܳ׺����ĵõ����ġ�
��ϸ������
�ӿ�˵��
ԭ�ͣ�
voidencrypt(char * key,char * data,char * encrypt);
���������
char * key���ܳ�
char * data������
���������
char * encrypt������
����ֵ��
void
��������:
������key��Ҫ���ܵ��ַ���
�������:
���ؼ��ܺ���ַ���
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class I36_�ַ������� {
	public static void encrypt(String key, String content) {
		//����list
		ArrayList<Character> list = new ArrayList<>();
		for(int i = 0; i < key.length(); ++i) {
			if(!list.contains(key.charAt(i)))
				list.add(Character.toLowerCase(key.charAt(i)));
		}
	
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < alpha.length(); ++i){
			if(!list.contains(alpha.charAt(i)))
				list.add(Character.toLowerCase(alpha.charAt(i)));
		}
		//����map;
		HashMap<Character,Character> map = new HashMap<>();
		for(int i = 0; i < alpha.length(); ++i){
			map.put(alpha.charAt(i), list.get(i) );
		}
		
		//��������
		char[] result = new char[content.length()];
		for(int i = 0; i < content.length(); ++i) {
			char c = content.charAt(i);
			if(Character.isLetter(c)) {
				boolean Upper = Character.isUpperCase(c);
				if(!Upper) {
					result[i] = map.get(c);
				} else {
					result[i] = Character.toUpperCase(map.get(c));
				}
			} else {
				result[i] = c;
			}
		
		}
		//���
		for(int i = 0; i < result.length; ++i)
			System.out.print(result[i]);
		System.out.println();
		
	}
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String key = scan.nextLine();
			String content = scan.nextLine();
			encrypt(key,content);
		}
	}
}
