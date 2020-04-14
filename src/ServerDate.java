import java.util.HashMap;

/**
 * @author
 */
public class ServerDate {
    private static int accountInitId = 100000;//账号初始ID
    private static int bookInitId = 100000;//书籍初始ID
    private static HashMap<Integer, Book> allBooks;//书籍数据
    private static HashMap<String, Book> allBooks1;//按书名存的书籍数据
    private static HashMap<Integer, Account> accounts;//账号数据

    public ServerDate() {
        allBooks = new HashMap<Integer, Book>();
        accounts = new HashMap<Integer, Account>();
    }

    public static int getAccountInitId() {
        return accountInitId;
    }

    public static void setAccountInitId(int accountInitId) {
        ServerDate.accountInitId = accountInitId;
    }

    public static int getBookInitId() {
        return bookInitId;
    }

    public static void setBookInitId(int bookInitId) {
        ServerDate.bookInitId = bookInitId;
    }

    public static HashMap<Integer, Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(HashMap<Integer, Book> allBooks) {
        ServerDate.allBooks = allBooks;
    }

    public static HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(HashMap<Integer, Account> accounts) {
        ServerDate.accounts = accounts;
    }

    //功能

    //判断身份，略写
    public static int identifyJudge(String name,String studentId){
        if(studentId.length() == 6) {
            return 2;//管理员
        } else if(studentId.length() == 11) {
            return 1;//用户
        } else {
            return 0;//非法用户
        }
    }

    //登录
    public static Account accountLogin(int id, String password){
        if(accounts.get(id).getPassword().equals(password)){
            return accounts.get(id);
        } else {
            return null;
        }
    }
    //注册
    public static Account accountRegister(String name, String studentId, String password){
        int studentID = Integer.parseInt(studentId);
        Account account = new Account();

        if(ServerDate.identifyJudge(name, studentId) == 0){//非法用户
            return null;
        }
        else if(ServerDate.identifyJudge(name, studentId) == 1){//用户
            account =new Account(accountInitId++, password, name, studentID);
        }
        else if(ServerDate.identifyJudge(name, studentId) == 2){//管理员
            account =new Account(accountInitId++, password, name, studentID);
            account.setStatus(true);
        }
        accounts.put(account.getAccountId(), account);
        return account;
    }
    //按书名查书
    public static Book searchBook(String bookName){
        if(allBooks1.containsKey(bookName)){
            return allBooks.get(bookName);
        } else {
            return null;
        }
    }
    //按书的ID查书
    public static Book searchBook(int bookId){
        if(allBooks.containsKey(bookId)){
            return allBooks.get(bookId);
        } else {
            return null;
        }
    }
    //借书
    public static Boolean borrowBook(int accountId,int bookId){
        if(!allBooks.containsKey(bookId)){
            return false;
        }
        if(!accounts.containsKey(accountId)){
            return false;
        }
        Account account = accounts.get(accountId);
        Book book = allBooks.get(bookId);
        if(book.getState() == false ){
            book.borrowBook(accountId);
            account.borrowBook(book);
            return true;
        } else {
            return false;
        }
    }
    //还书
    public static Boolean returnBook(int accountId,int bookId){
        if(!allBooks.containsKey(bookId)){
            return false;
        }
        if(!accounts.containsKey(accountId)){
            return false;
        }
        Account account = accounts.get(accountId);
        Book book = allBooks.get(bookId);
        book.borrowBook(accountId);
        account.borrowBook(book);
        return true;
    }
    //添加书籍
    public static Book addBook(String name, String info){
        Book book = new Book(bookInitId ++ ,name,info);
        allBooks.put(book.getBookId(),book);
        allBooks1.put(book.getName(),book);
        return book;
    }
    //删除书籍
    public static void removeBook(int bookId){
        if(allBooks.containsKey(bookId)){
            Book book = allBooks.get(bookId);
            allBooks.remove(bookId);
            if(allBooks1.containsKey(book.getName())){
                allBooks1.remove(book.getName());
            }
        }
    }
    //添加管理员账号
    public static Boolean addAdmin(int adminAccountId, int userAccountId){//添加管理员
        if(accounts.containsKey(adminAccountId) && accounts.containsKey(userAccountId)){//账号是否存在
            Account admin = accounts.get(adminAccountId);
            Account user = accounts.get(userAccountId);
            if(admin.getStatus()){//处理账号是否为管理员
                user.setStatus(true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //删除用户账号
    public static Boolean removeUser(int adminAccountId, int userAccountId){
        if(accounts.containsKey(adminAccountId) && accounts.containsKey(userAccountId)) {//账号是否存在
            Account admin = accounts.get(adminAccountId);
            Account user = accounts.get(userAccountId);
            if(admin.getStatus() ==true && user.getStatus() == false){
                accounts.remove(user.getAccountId());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

