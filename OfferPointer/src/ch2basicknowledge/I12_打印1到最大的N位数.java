package ch2basicknowledge;

/**
 * 2018��3��20�� @author jiayuanan
 * item12:��ӡ1������Nλ��
 * ˼·�����ǵ�n���Ժܴ����Բ�������/�ַ���ģ������
 * �ַ���������ָofferP95�� ȫ���С�����ָofferP97
 */
public class I12_��ӡ1������Nλ�� {

	public void print(int n) {
		if(n <= 0)
			return;
		int[] number = new int[n];
		
		while(!isLast(number)) {  //�����ж�
			increase(number);    //ģ���1����
			printNumber(number); //��ӡ����
		}
	
	}
	//�ж��Ƿ�Ϊ����Nλ��
	boolean isLast(int[] number) {
		for(int index = 0; index < number.length; ++ index) {
			if(number[index] != 9)
				return false;
		}
		return true;
	}
	//��ӡһ����
	static void printNumber(int[] number) {
		for(int index = 0; index < number.length; ++ index) {
			//�ҵ��Ӵ�С��һ������λ������λ��ʼ��ӡ�������ÿ��Ǵ��������
			if(number[index] == 0)
				continue;
			else {
				printNumberRest(number, index, number.length); //��ʼû��break��䣬bug
				break;
			}
				
			
		}
	}
	static void printNumberRest(int[] number, int start, int end) {
		for(int index = start; index < end; ++index) {  //����������ˣ�Ҳ���׻���
			System.out.print(number[index]);
		}
		System.out.println();
	}
	
	void increase(int[] number) {
		int digit = number.length;
		//��Խ�1�ص������ơ����ѵ����ڲ�ȷ������ʵ��λ�����޷�ʹ��if��switch���
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = { 0,0,1,2};
		printNumber(number);
	}

}
