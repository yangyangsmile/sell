package test.relfex;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/10/30.
 */
public class T2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类的所有方法
        Class cc = Class.forName("test.relfex.Person");
        Method[] methods = cc.getMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
        Class [] classes = cc.getInterfaces();
        for (Class c   : classes){
            System.out.println(c);
        }
    }
}
