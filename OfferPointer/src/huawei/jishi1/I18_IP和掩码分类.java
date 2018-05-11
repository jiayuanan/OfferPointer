package huawei.jishi1;

/**
 * 2018��4��8�� @author jiayuanan
��Ŀ����
�����IP��ַ�Ͷ�Ӧ�����룬���з���ʶ��Ҫ����A/B/C/D/E���ַ���࣬���Ϸ��ĵ�ַ�����뵥�����ࡣ


���е�IP��ַ����Ϊ A,B,C,D,E����
A���ַ1.0.0.0~126.255.255.255;
B���ַ128.0.0.0~191.255.255.255;
C���ַ192.0.0.0~223.255.255.255;
D���ַ224.0.0.0~239.255.255.255��
E���ַ240.0.0.0~255.255.255.255
˽��IP��Χ�ǣ�
10.0.0.0��10.255.255.255
172.16.0.0��172.31.255.255
192.168.0.0��192.168.255.255
��������Ϊǰ����������1��Ȼ��ȫ��0�������磺255.255.255.32����һ���Ƿ������룩
������ʱĬ����0��ͷ��IP��ַ�ǺϷ��ģ�����0.1.1.2���ǺϷ���ַ
��������:
�����ַ�����ÿ��һ��IP��ַ�����룬��~������
�������:
ͳ��A��B��C��D��E������IP��ַ��������롢˽��IP�ĸ�����֮���Կո������
 */
import java.util.*;
public class I18_IP��������� {
//��ʼ�����ˣ���ip���������뵥���ֿ�����
	public static boolean okay(int i) {
		if(i >= 0 && i <= 255)
			return true;
		return false;
	}
    private static boolean isMask(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }
     
    /**
     * ������ת�ɶ�Ӧ�İ�λ�������ַ���
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
	/*public static boolean isMask (String[] mask) {

		//��mask�任��32λbinary��
		String binary = "";
		for(int i = 0; i < 4; ++i) {
			String temp = Integer.toBinaryString(Integer.parseInt(mask[i]));
			int length = temp.length(); 
			if (length == 8) {
				binary += temp;
			} else {
				for(int j = 0; j < 8 - length; ++j) { //����
					binary += "0";
				}
				binary += temp;
			}
		}
		//һλλ�жϡ����������ֵ�һ��0�������Ӧ�ö���0
		for(int i = 0; i < 32; ++i) {
			if(binary.charAt(i) == '1')
				continue;
			else {
				for(int j = i; j < 32; ++j) {
					if(binary.charAt(j) != '0')
						return false;
				}
			}
		}
		
		return true;
	}*/
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int[] cons = new int[7];
        while(scan.hasNext()) {
        	String line = scan.nextLine();
        	String[] ips = line.split("~");
        	String[] ip = ips[0].split("\\.");
        	String[] mask = ips[1].split("\\.");
        	
        	//��һ�����Σ����ڿ�
        	if(ip.length != 4 || mask.length != 4) {
        		++cons[5];
        		continue;
        	} 
        	//����2�����ַ�Χ����
    		int ipa = Integer.parseInt(ip[0]);
    		int ipb = Integer.parseInt(ip[1]);
    		int ipc = Integer.parseInt(ip[2]);
    		int ipd = Integer.parseInt(ip[3]);
    		if(!okay(ipa) || !okay(ipb) || !okay(ipc) || !okay(ipd)) {
    			++cons[5];
    			continue;
    		}
        	//����3��mask����
        	if(!isMask(ips[1])) {
        		++cons[5];
        		continue;
        	}
        	//��󣬶�ip�����ж�

    		if(ipa == 0) {
    			; //0��ͷ����������ַ��������
    			//����Ĵ��������maskһ���ж�
    		} else if (ipa >=1 && ipa <= 126) { //A
    			++cons[0];
    		} else if (ipa >=128 && ipa <=191 ) {//B
    			++cons[1];
    		} else if (ipa >=192 && ipa <=223  ) {//C
    			++cons[2];
    		} else if (ipa >=224 && ipa <=239 ) {//D
    			++cons[3];
    		} else if (ipa >=240 && ipa <=255 )  {//E
    			++cons[4];
    		} 
    		//˽�е�ַ�������غϣ��ٴ���һ��
    		if((ipa == 10  ) ||
    		   (ipa ==172 &&  16 <= ipb && ipb <=31 ) ||
    		   (ipa == 192 && ipb == 168  )  ) {
    			++cons[6];
    		}       		
        	
        }
        
        boolean first = true;
        for(int i = 0; i < cons.length; ++i) {
        	if(first) {
        		System.out.print(cons[i]);
        		first = false;
        	} else {
        		System.out.print(" " + cons[i]);
        	}
        }
        scan.close();
        
    }


}
