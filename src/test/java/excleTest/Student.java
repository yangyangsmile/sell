package excleTest;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/13.
 */
@Data
public class Student {
    private long id;
    private String name;
    private int age;
    private boolean sex;
    private Date birthday;

}
