package huawei.jishi1;




/**
 * 2018年4月7日 @author jiayuanan
题目描述
明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
请你协助明明完成“去重”与“排序”的工作。 
Input Param 
     n               输入随机数的个数     
 inputArray      n个随机整数组成的数组 

Return Value
     OutputArray    输出处理后的随机整数

注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
输入描述:
输入多行，先输入随机整数的个数，再输入相应个数的整数

输出描述:
返回多行，处理后的结果 
 */
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
public class I03_数列的去重和排序 {
//用TreeSet或者数组
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Set<Integer> tree = new TreeSet<Integer>();
		while(scan.hasNext()) {
			int sum = scan.nextInt();
			for(int i = 0; i < sum; ++i) {
				tree.add(scan.nextInt());
			}
			
			for(Integer i : tree)
				System.out.println(i);
		}
		
		Iterator<Integer> it = tree.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
