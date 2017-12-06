package test;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/9/22.
 */
public class DoubleTest {
    public static  void main(String [] args){
        int a = 10;
        int b = 3;
        double dd = a;
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        double c = Double.parseDouble(decimalFormat.format(dd/b));
        System.out.print(c);
    }
}
