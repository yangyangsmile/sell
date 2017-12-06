package test.relfex;

/**
 * Created by Administrator on 2017/10/30.
 */
public class T1 {
    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * 获取一个类的三种方式
         */
        System.out.println();
                Class cc =   Class.forName("test.relfex.Person");
        Class dd = Person.class;
        Person person = new Person();
        Class yy = person.getClass();

    }
}
