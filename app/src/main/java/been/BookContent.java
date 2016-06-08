package been;

import android.util.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 果占先 on 2016/5/30.
 */
public class BookContent {
    public static class Book
    {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();

    public static Map<Integer,Book> ITEM_MAP = new HashMap<Integer,Book>();

    static
    {
        addItem(new Book(1,"魔兽世界","这是一个世界，也是一个寂寞！！！"));
        addItem(new Book(2,"英雄联盟","这是一个游戏，也是一份追逐！！！"));
        addItem(new Book(3,"魔兽争霸","这是一个历史，也是一份传承！！！"));
        addItem(new Book(4,"真三无双","这是一份怀念，也是一份经典！！！"));
    }

    private static void addItem(Book book)
    {
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
