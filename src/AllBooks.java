import java.util.HashMap;

/**
 * @author DearAhri520
 */
public class AllBooks {

    /**
     * 键值对
     * key：书籍名称
     * value：书籍数量
     */
    HashMap<String,Integer> allBooks=new HashMap<>();

    /**
     * 添加某本书籍（只有管理员能进行该操作）
     *
     * @param bookName 书籍名称
     * @param bookNumber 书籍数量
     * @return boolean变量 是否添加成功
     */
    boolean addBook(String bookName,int bookNumber){
        if(allBooks.containsKey(bookName)){
            Integer oldBookNumber=allBooks.remove(bookName);
            allBooks.put(bookName,oldBookNumber+bookNumber);
        }else{
            allBooks.put(bookName,bookNumber);
        }
        return true;
    }

    /**
     * 删除某本书籍 需确定删除书籍的数量 若删除的书籍的数量大于原有的书籍的数量或未找到该书籍 返回false（只有管理员能进行此操作）
     *
     * @param bookName 书籍名称
     * @param bookNumber 书籍数量
     * @return boolean变量 是否删除成功
     */
    boolean deleteBook(String bookName,int bookNumber){
        if(allBooks.containsKey(bookName)){
            if(allBooks.get(bookName)>bookNumber){
                Integer oldBookNumber=allBooks.remove(bookName);
                allBooks.put(bookName,bookNumber-oldBookNumber);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除某本书籍 无需确定删除书籍的数量而是全部删除该书籍 若未找到该书籍 返回false（只有管理员能进行此操作）
     *
     *
     * @param bookName 书籍名称
     * @return boolean变量 是否删除成功
     */
    boolean deleteBook(String bookName){
        if(allBooks.containsKey(bookName)){
            allBooks.remove(bookName);
            return true;
        }
        return false;
    }

    /**
     *
     * @param bookName 需要查询的书籍名称
     * @return 返回一个字符串
     * 如果没找到该书籍 返回 NotFound
     * 如果找到了该书籍 返回 "书籍名称 书籍数量" 中间用空格隔开
     */
    String findBook(String bookName){
        if(allBooks.containsKey(bookName)){
            return bookName+" "+allBooks.get(bookName);
        }
        return "NotFound";
    }
}
