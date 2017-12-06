package test.relfex;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Person implements InterFace {
    private String id;
    private String name;
    private String age;

    public Person() {
        this.id = id;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String id, String age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public static void update(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void read() {

    }
}
