import java.util.Date;

public class Book {
    /**
     * 书籍的专属ID
     */
    private int bookId;

    /**
     * 书籍名称
     */
    private String name;

    /**
     * 书籍信息
     */
    private String info;

    /**
     * 书籍是否被借阅
     */
    private boolean state;

    /**
     * 借书人Id
     */
    private int borrowId;

    /**
     * 借书时间
     */
    private Date borrowTime;

    /**
     * 还书时间
     */
    private Date returnTime;

    public Book() {
    }

    public Book(int ID, String name, String info) {
        this.bookId = ID;
        this.name = name;
        this.info = info;
        this.state = false;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
    public void borrowBook(int accountId){
        this.state = true;
        this.borrowId = accountId;
        this.borrowTime = new Date();
    }
    public void returnBook(int accountId){
        this.state = false;
        this.borrowId = 0;
        this.borrowTime = null;
    }
}
