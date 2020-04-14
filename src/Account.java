import java.util.HashMap;

public class Account {
    private int accountId;//账号id
    private String password;//账号密码
    private boolean status;//身份，即是否为管理员
    private String name;//姓名
    private int stuentId;//学号
    HashMap<Integer, Book>borrowBooks;//已借书籍
    HashMap<Integer,Book>bookCollection;//收藏


    public Account() {
        this.bookCollection = new HashMap<Integer,Book>();
        this.borrowBooks = new HashMap<Integer,Book>();
    }

    public Account(int accountId, String password, String name, int stuentId) {
        this();
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.stuentId = stuentId;
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

    public int getStuentId() {
        return stuentId;
    }

    public void setStuentId(int stuentId) {
        this.stuentId = stuentId;
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

    public void borrowBook(Book book){
        borrowBooks.put(book.getBookId(),book);
    }

    public void returnBook(Book book){
        borrowBooks.remove(book.getBookId(),book);
    }
}
