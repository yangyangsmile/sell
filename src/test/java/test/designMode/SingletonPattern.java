package test.designMode;

/**
 * Created by Administrator on 2017/10/30.
 */
public class SingletonPattern {
    private static  SingletonPattern singletionPattern = null;
    private SingletonPattern( ){
    }
    public static SingletonPattern getSingletionPattern(){
        if (singletionPattern ==null){
            singletionPattern = new SingletonPattern(5);
        }
        return singletionPattern;
    }

    private  SingletonPattern(int test){
        this.test = test;
    }
    private int test;
    public int getTest(){
        return test;
    }
    public void setTest(int test){
        this.test = test;
    }
}
