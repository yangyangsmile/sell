package excleTest;

import lombok.Data;

/**
 * Created by Administrator on 2017/10/13.
 */
@Data
public class Book {
    private int bookId;
    private String name;
    private String author;
    private float price;
    private String isbn;
    private String pubName;
    private byte[] preface;
}
