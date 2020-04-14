import java.util.HashMap;

/**
 * @author 贺文超
 */
public class Account {
    /**
     *  账号Id
     */
    private String accountId;

    /**
     * 密码
     */
    private String password;

    /**
     * 判断身份 是否为管理员
     */
    private boolean status;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户已借书籍
     */
    HashMap<Integer, Book>borrowBooks;

    /**
     * 空参构造器
     */
    public Account() {
        this.borrowBooks = new HashMap<Integer,Book>();
    }

    /**
     *
     * @param accountId 用户账号Id
     * @param password 用户密码
     * @param name  用户真实姓名
     */
    public Account(String accountId, String password, String name) {
        this();
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

    /**
     *获取用户账号Id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 获取用户密码
     *
     * @return 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     *用户设置密码
     *
     * @param password 用户设置的新的密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户是否为管理员
     *
     * @return 用户是否为管理员
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * 设置用户是否为管理员
     *
     * @param status 管理员状态参数
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 获取用户名字
     *
     * @return 用户名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名字
     *
     * @param name 用户名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户已借的书
     *
     * @return HashMap类型 用户借的书
     */
    public HashMap<Integer, Book> getBorrowBooks() {
        return borrowBooks;
    }

    /**
     * 设置用户已借的书
     *
     * @param borrowBooks HashMap 用户借的书
     */
    public void setBorrowBooks(HashMap<Integer, Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    /**
     * 用户借书
     *
     * @param book 用户借的书
     */
    public void borrowBook(Book book){
        borrowBooks.put(book.getBookId(),book);
    }

    /**
     * 还书
     *
     * @param book 用户还的书
     */
    public void returnBook(Book book){
        borrowBooks.remove(book.getBookId(),book);
    }
}
