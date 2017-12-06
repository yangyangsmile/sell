package test.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/10/30.
 */
public class reflexTest
{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
       Class c = Class.forName("User");
        Field f = c.getDeclaredField("a");
        System.out.println(f.getName());
        f.setAccessible(true);
       int y = 44;
        Object o = c.newInstance();
       f.set(o,y);
        System.out.println("反射后的值是"+f.get(o));
        Method [] methods = c.getMethods();
        for (Method method :methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaredAnnotations());
            System.out.println(method.getDeclaringClass());
        }
        ;
     //   System.out.println(f.get(c));
//        try {
//             c = Class.forName("java.lang.Integer");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Class d = java.lang.Integer.class;
//        Field[] fs = c.getDeclaredFields();
//        StringBuffer sb = new StringBuffer();
//        sb.append(Modifier.toString(c.getModifiers())+"class"+c.getSimpleName());
//        for (int i = 0; i <fs.length ; i++) {
//            sb.append("\n"+fs[i]);
//        }
//        System.out.println(sb);
//        System.out.println("");
//        System.out.println(d.getSuperclass());

    }
}
