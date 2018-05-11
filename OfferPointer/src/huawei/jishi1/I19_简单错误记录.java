package huawei.jishi1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2018��4��8�� @author jiayuanan
����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš�
���� 
1�� ��¼���8�������¼��ѭ����¼������ͬ�Ĵ����¼�����ļ����ƺ��к���ȫƥ�䣩ֻ��¼һ��������������ӣ�
2�� ����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
3�� ������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·����
��������:
һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������
�������:
�����еļ�¼ͳ�Ʋ�������������ʽ���ļ��� �������� ��Ŀ��һ���ո�������磺 
 */
public class I19_�򵥴����¼ {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        Map<String,Integer> map = new LinkedHashMap<String,Integer>(); //��ż�¼
        while((str=br.readLine())!=null){
            String[] strs = str.split(" ");
            String fileName = strs[0];  //�ļ���
            String line = strs[1];      //�ļ�����������
             
            //������·��
            if(fileName.contains("\\"))
            	fileName = fileName.substring(fileName.lastIndexOf('\\') + 1); //��Ҫ���һ��б��,Ҫ+1
             
            //·������������������
            if(fileName.length()>16)
                fileName = fileName.substring(fileName.length()-16);
            
            //�������ͬ��ָrecord��ͬ
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
            if(count>(map.keySet().size()-8)) //ֻ������8����Ϣ
                System.out.println(string+" "+map.get(string));
        }
             
    }

}
