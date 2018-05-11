package huawei.jishi1;


/**
 * 2018年4月9日 @author jiayuanan
题目描述
若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，
例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，
当然密码学会希望你寻找出“最佳方案”。
输入:
有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
输出:
输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
输入描述:
输入说明
1 输入一个正偶数n
2 输入n个整数
输出描述:
求得的“最佳方案”组成“素数伴侣”的对数。
 */
//这里，素数=奇+偶。。所以分为两堆，进行二分图的最大匹配，使用匈牙利算法
import java.util.Scanner;
import java.util.ArrayList;
public class I28_素数伴侣____二分图的最大匹配_匈牙利算法 {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			//读取所有的数
			int N = scan.nextInt();
			int[] numbers = new int[N];
			for(int i = 0; i < N; ++i)
				numbers[i] = scan.nextInt();
			//奇偶分离
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();
            for(int i = 0;i < N; i++){
                if (numbers[i] % 2 == 0) {           
                    evens.add(numbers[i]);
                }else {                          
                    odds.add(numbers[i]);
                }
            }
            //从奇数出发，开始配对
            int[] evensMatch = new int[evens.size()]; //表示与对应位置偶数配对的奇数的位置
            int result = 0;
            //int[] used = new int[evens.size()];  //用来表示偶数的配对状况——0表示未被配对
            for(int i = 0;i < odds.size(); i++){
                int[] used = new int[evens.size()];  //用来表示偶数的配对状况——0表示未被配对,注意它的位置，在里面就行了，对于被它霸占的偶数对应的奇数，会去一一霸占的
                if (find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);
 
        }
	}
	
	public static boolean find(int x, ArrayList<Integer> evens, int[] used, int[] evensMatch) {
        int j;
        //对传进来的奇数，用偶数进行一一匹配
        for(j = 0;j < evens.size(); j++){
        	//若能搭配成素数，且该偶数还未被配对
            if (isPrime(x + evens.get(j)) && used[j] == 0) {
                used[j] = 1;
                //若当前数还没有被配对或者被配对的奇数能找到另一个偶数——则配对成功
                if (evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)) {
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
	
	
	//素数判断
	public static boolean isPrime(int num) {
	    if (num == 2)
	        return true;
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0)
	            return false;
	    }
	    return true;
	}
}
