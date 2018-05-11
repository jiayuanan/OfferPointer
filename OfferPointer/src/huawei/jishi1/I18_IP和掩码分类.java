package huawei.jishi1;

/**
 * 2018年4月8日 @author jiayuanan
题目描述
请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。


所有的IP地址划分为 A,B,C,D,E五类
A类地址1.0.0.0~126.255.255.255;
B类地址128.0.0.0~191.255.255.255;
C类地址192.0.0.0~223.255.255.255;
D类地址224.0.0.0~239.255.255.255；
E类地址240.0.0.0~255.255.255.255
私网IP范围是：
10.0.0.0～10.255.255.255
172.16.0.0～172.31.255.255
192.168.0.0～192.168.255.255
子网掩码为前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
本题暂时默认以0开头的IP地址是合法的，比如0.1.1.2，是合法地址
输入描述:
多行字符串。每行一个IP地址和掩码，用~隔开。
输出描述:
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 */
import java.util.*;
public class I18_IP和掩码分类 {
//开始理解错了，把ip和子网掩码单独分开看了
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
     * 将整数转成对应的八位二进制字符串
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

		//将mask变换成32位binary串
		String binary = "";
		for(int i = 0; i < 4; ++i) {
			String temp = Integer.toBinaryString(Integer.parseInt(mask[i]));
			int length = temp.length(); 
			if (length == 8) {
				binary += temp;
			} else {
				for(int j = 0; j < 8 - length; ++j) { //补齐
					binary += "0";
				}
				binary += temp;
			}
		}
		//一位位判断————出现第一个0后的数字应该都是0
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
        	
        	//第一种情形，存在空
        	if(ip.length != 4 || mask.length != 4) {
        		++cons[5];
        		continue;
        	} 
        	//情形2，数字范围不对
    		int ipa = Integer.parseInt(ip[0]);
    		int ipb = Integer.parseInt(ip[1]);
    		int ipc = Integer.parseInt(ip[2]);
    		int ipd = Integer.parseInt(ip[3]);
    		if(!okay(ipa) || !okay(ipb) || !okay(ipc) || !okay(ipd)) {
    			++cons[5];
    			continue;
    		}
        	//情形3：mask有误
        	if(!isMask(ips[1])) {
        		++cons[5];
        		continue;
        	}
        	//最后，对ip进行判定

    		if(ipa == 0) {
    			; //0开头算作正常地址，不处理
    			//下面的处理必须连mask一起判断
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
    		//私有地址与上述重合，再处理一次
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
