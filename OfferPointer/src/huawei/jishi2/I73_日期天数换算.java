package huawei.jishi2;

/**
 * 2018年4月13日 @author jiayuanan
 * I73_日期天数换算.java
 * 
 */
import java.util.Scanner;
public class I73_日期天数换算{
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
    	String compensate = "0010112234455";   //按闰年计算的天数快速补偿
    	
    	boolean isLeapYear = year % 100 == 0 ? (year % 400 == 0) : year % 4 == 0;
    	int days = (month - 1) * 30 + compensate.charAt(month) - '0' + day;    //总天数计算——按闰年算的，且不考虑天数上的错误
    	if(isLeapYear) {
    		daysOfMonth[2] = 29;
    		if(day > daysOfMonth[month])
    			return -1;
    	} else {
    		if(day > daysOfMonth[month])
    			return -1;
    		if(month > 2)
    			--days;   //这个是有条件的
    	}

    	return days;
    }
}
