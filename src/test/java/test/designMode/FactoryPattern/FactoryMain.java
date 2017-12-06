package test.designMode.FactoryPattern;

/**
 * Created by Administrator on 2017/10/30.
 */
public class FactoryMain {
    public static void main(String [] args) {


    Factory factory = new Factory();
        System.out.println(factory.getFactoyr("AA").getClass());
        System.out.println(factory.getFactoyr("BB").getClass());
    }
}
