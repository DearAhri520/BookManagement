import java.util.Date;

public class Book {
    private int bookId;//书籍的专属ID
    private String name;//书籍的名称
    private String info;//书籍信息
    private boolean state;//状态(借阅与否)
    private int borrowId;//借书人id

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

    public void borrowBook(int accountId){
        this.state = true;
        this.borrowId = accountId;
    }
    public void returnBook(int accountId){
        this.state = false;
        this.borrowId = 0;
    }
}
