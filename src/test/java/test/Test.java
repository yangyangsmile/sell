package test;


import java.io.*;

/**
 * Created by Administrator on 2017/9/18.
 */
public class Test extends B {

    public  void doString(){
        System.out.print("A方法");
    }
    public static void main(String [] args){
     /**
        String a = new String ("abc");
        String b = new String ("abc");
       System.out.println(a.equals(b));
        System.out.println(a=="abc");
        StringBuffer aB = new StringBuffer("abc");
        StringBuffer aA = new StringBuffer("abc");
        System.out.println(aA.equals(aB));
        System.out.println(aA==aB);
        Integer i = new Integer(200);
        Integer k =new Integer(200);
        System.out.print(i.equals(k));
    }*/
//        String a = "abc def ghi klm nop";
//        String[]b = a.split(" ");
//        for (String x :b){
//            System.out.print(x+"\n");
//        }

        Test.copyOf("C:\\Users\\Administrator\\Desktop\\nginx-1.13.5\\conf\\nginx.conf","C:\\Users\\Administrator\\Desktop\\nginx-1.13.5\\conf\\bb");





    }
    public static void copyOf(String oldFile,String newFile){
        File file = new File(oldFile);
        int byteread = 0;
        int bytesum =0;
        if (file.exists()){
            try {
                InputStream  input = new FileInputStream(oldFile);
                OutputStream ouput = new FileOutputStream(newFile);
                byte[]a = new byte[1024];
              while((byteread= input.read(a))!=-1){
                    bytesum = bytesum+byteread;
                  ouput.write(a,0,byteread);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
class B{
    public  void doString(){
        System.out.print("B方法");
    }
}
