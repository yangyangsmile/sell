package test.designMode;

/**
 * Created by Administrator on 2017/10/30.
 */
public class aaa

{
    public static void main(String[] args) {

        SingletonPattern singletonPattern = SingletonPattern.getSingletionPattern();
        SingletonPattern singletonPattern1 = SingletonPattern.getSingletionPattern();
        int  aa = singletonPattern.getTest();
        System.out.println(aa);
        singletonPattern.setTest(6);
        singletonPattern.setTest(10);
        System.out.println(singletonPattern.getTest());

        System.out.println("第二个未赋值的数据"+singletonPattern1.getTest());

    }


}


