import java.util.HashMap;

/**
 * @author
 */
public class Account {

    /**
     * accountId 账号Id
     */
    private int accountId;

    /**
     * password 账号密码
     */
    private String password;

    /**
     * status 身份 是否为管理员
     */
    private boolean status;

    /**
     * name 用户姓名
     */
    private String name;

    /**
     * 用户学号
     */
    private int studentId;

    /**
     * 已借书籍
     */
    HashMap<Integer,Book>borrowBooks;

    /**
     * 收藏书籍
     */
    HashMap<Integer,Book>bookCollection;

    /**
     * 借阅历史
     */
    HashMap<Integer,Book>borrowHistory;

    public Account() {
        this.bookCollection = new HashMap<Integer,Book>();
        this.borrowBooks = new HashMap<Integer,Book>();
        this.borrowHistory = new HashMap<Integer,Book>();
    }

    public Account(int accountId, String password, String name, int studentId) {
        this();
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public HashMap<Integer, Book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(HashMap<Integer, Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public HashMap<Integer, Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(HashMap<Integer, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public HashMap<Integer, Book> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(HashMap<Integer, Book> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    public void borrowBook(Book book){
        borrowBooks.put(book.getBookId(),book);
        borrowHistory.put(book.getBookId(),book);
    }
    public void returnBook(Book book){
        borrowBooks.remove(book.getBookId(),book);
    }
}

