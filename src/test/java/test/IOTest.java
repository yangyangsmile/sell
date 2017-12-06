package test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/10/10.
 */
public class IOTest {
    public static void main(String [] args) throws Exception{
      String str ="中国人";
       /*   FileOutputStream fos = new FileOutputStream("1.txt");

        fos.write(str.getBytes("utf-8"));
        fos.close();
*/
     /*   FileWriter fw = new FileWriter("1.txt");
        fw.write(str);
        fw.close();
    */

     /*   PrintWriter pw = new PrintWriter("1.txt");
        pw.write(str);
        pw.close();
*/
        FileReader fr = new FileReader("1.txt");
        char[] buf = new char[1024];
        int len = fr.read(buf);
        String myStr = new String(buf,0,len);













    }
}
