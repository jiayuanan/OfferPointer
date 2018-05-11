package huawei.jishi2;

/**
 * 2018��4��13�� @author jiayuanan
 * I73_������������.java
 * 
 */
import java.util.Scanner;
public class I73_������������{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int year = scan.nextInt();
        	int month = scan.nextInt();
        	int day = scan.nextInt();
        	System.out.println(iConverDateToDay(year, month, day));

        }
        scan.close();
    }
    public static int iConverDateToDay(int year, int month, int day)
    {
    	if(month > 12 || month <= 0 || day > 31 || day < 1)
    		return -1;
    	int[] daysOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    	String compensate = "0010112234455";   //�����������������ٲ���
    	
    	boolean isLeapYear = year % 100 == 0 ? (year % 400 == 0) : year % 4 == 0;
    	int days = (month - 1) * 30 + compensate.charAt(month) - '0' + day;    //���������㡪����������ģ��Ҳ����������ϵĴ���
    	if(isLeapYear) {
    		daysOfMonth[2] = 29;
    		if(day > daysOfMonth[month])
    			return -1;
    	} else {
    		if(day > daysOfMonth[month])
    			return -1;
    		if(month > 2)
    			--days;   //�������������
    	}

    	return days;
    }
}
