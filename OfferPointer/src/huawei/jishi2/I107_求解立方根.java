package huawei.jishi2;

/**
 * 2018��4��12�� @author jiayuanan
 * I107_���������.java
 * 
 */
//�õĶ��ַ����ġ���ע��������ע���1С�ĺͱ�1��ģ�ע�⸡�����ıȽϣ�ע�����
import java.util.Scanner;
import java.text.DecimalFormat;
public class I107_��������� {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            double num = scan.nextDouble();
            
            DecimalFormat df=new DecimalFormat("###.0"); //����4���������ʽ����
            System.out.println(df.format(getCubeRoot(num)));
        }
        scan.close();
    }
    
    public static double getCubeRoot(double input) {
        double result = input;
        boolean negtive = Double.compare(input, 0.0d) > 0 ? false : true;
        //System.out.println(negtive);
        if(negtive)
            input = - input;
        boolean belowOne = Double.compare(input, 1.0d) > 0 ? false : true;
        //System.out.println(belowOne);
        if(!belowOne) {
            double low = 1.0d;
            double high = input;
            double mid = (low + high) / 2;
            while(Math.abs(mid * mid * mid - input) > 1e-7) {  //����1
                if(Double.compare(mid * mid * mid, input) > 0) { //����2
                    high = mid;
                    mid = (high + low) / 2;
                    //System.out.println(mid);
                } else {
                    low = mid;
                    mid = (high + low) / 2;
                    //System.out.println(mid);
                }
            }
            result = mid;
        } else {
            double low = input;
            double high = 1.0d;
            double mid = (low + high) / 2;
            while(Math.abs(mid * mid * mid - input) > 1e-7) {
                if(Double.compare(mid * mid * mid, input) > 0) {
                    high = mid;    //����3
                    mid = (high + low) / 2;
                } else {
                    low = mid;
                    mid = (high + low) / 2;
                }
            }
            result = mid;
        }
        if(negtive)
            return -result;
        else
            return result;
    }
}
