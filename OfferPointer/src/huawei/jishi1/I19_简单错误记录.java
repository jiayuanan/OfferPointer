package huawei.jishi1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2018年4月8日 @author jiayuanan
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理： 
1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
3、 输入的文件可能带路径，记录文件名称不能带路径。
输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
输出描述:
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如： 
 */
public class I19_简单错误记录 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        Map<String,Integer> map = new LinkedHashMap<String,Integer>(); //存放记录
        while((str=br.readLine())!=null){
            String[] strs = str.split(" ");
            String fileName = strs[0];  //文件名
            String line = strs[1];      //文件名所在行数
             
            //获得相对路径
            if(fileName.contains("\\"))
            	fileName = fileName.substring(fileName.lastIndexOf('\\') + 1); //所要多加一道斜杠,要+1
             
            //路径名过长，继续处理
            if(fileName.length()>16)
                fileName = fileName.substring(fileName.length()-16);
            
            //这里的相同是指record相同
            String record = fileName + " " + line;
             
            if(map.containsKey(record)){
                map.put(record,map.get(record)+1);
            }else{
                map.put(record,1);
            }
        }
         
        int count=0;
        for(String string : map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //只输出最后8条信息
                System.out.println(string+" "+map.get(string));
        }
             
    }

}
