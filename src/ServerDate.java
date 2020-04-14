import java.util.HashMap;

/**
 * @author 贺文超
 */
public class ServerDate {

    /**
     * 账号初始ID
     */
    private static int accountInitId = 100000;

    /**
     * 书籍初始ID
     */
    private static int bookInitId = 100000;

    /**
     * 按照书籍Id管理的书籍数据管理
     */
    private static HashMap<Integer, Book> allBooks;

    /**
     * 按照书名管理的书籍数据存储
     */
    private static HashMap<String, Book> allBooks1;

    /**
     * 账号数据
     */
    private static HashMap<Integer, Account> allAccounts;

    public ServerDate() {
        allBooks = new HashMap<Integer, Book>();
        allAccounts = new HashMap<Integer, Account>();
    }

    public static HashMap<Integer, Book> getAllBooks() {
        return allBooks;
    }

    /**
     * 设置储存的所有书籍
     *
     * @param allBooks 所有书籍
     */
    public static void setAllBooks(HashMap<Integer, Book> allBooks) {
        ServerDate.allBooks = allBooks;
    }

    /**
     * 获取所有的账户
     *
     * @return 返回所有的账户
     */
    public static HashMap<Integer, Account> getAccounts() {
        return allAccounts;
    }

    /**
     * 设置所有的账户
     *
     * @param accounts 所有的账户
     */
    public static void setAccounts(HashMap<Integer, Account> accounts) {
        ServerDate.allAccounts = accounts;
    }

    /**
     * 判断用户 普通用户返回1 管理员返回2 非法用户返回0
     *
     * @param studentId 用户Id
     * @return int类型
     */
    public static int identifyJudge(String studentId){
        if(allAccounts.containsKey(Integer.parseInt(studentId))){
            if(allAccounts.get(Integer.parseInt(studentId)).getStatus()){
                return 2;
            }else {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 用户登录
     *
     * @param id 用户Id
     * @param password 用户密码
     * @return 返回该用户是否存在
     */
    public static boolean accountLogin(String id, String password){
        if(allAccounts.containsKey(Integer.parseInt(id))){
            return allAccounts.get(Integer.parseInt(id)).getPassword().equals(password);
        }
        return false;
    }

    /**
     * 用户注册
     *
     * @param name 用户真实姓名
     * @param password 用户密码
     * @return 返回一个Account实例
     */
    public static Account accountRegister(String name, String password){
        Account account= new Account(String.valueOf(accountInitId),password,name);
        allAccounts.put(accountInitId,account);
        accountInitId++;
        return account;
    }

    /**
     * 按书籍名称查找书籍
     *
     * @param bookName 书籍名称
     * @return 返回查找到的书籍
     */
    public static Book searchBook(String bookName){
        if(allBooks1.containsKey(bookName)){
            return allBooks1.get(bookName);
        } else {
            return null;
        }
    }

    /**
     *按书籍id查找查书
     *
     * @param bookId 书籍id
     * @return 返回查找到的书籍
     */
    public static Book searchBook(Integer bookId){
        if(allBooks.containsKey(bookId)){
            return allBooks.get(bookId);
        } else {
            return null;
        }
    }

    /**
     * 用户借书
     *
     * @param accountId 用户Id
     * @param bookId 书籍Id
     * @return 用户是否借书成功
     */
    public static Boolean borrowBook(int accountId,int bookId){
        if(!allBooks.containsKey(bookId)||!allAccounts.containsKey(accountId)){
            return false;
        }
        Account account = allAccounts.get(accountId);
        Book book = allBooks.get(bookId);
        if(!book.getState()){
            book.borrowBook(accountId);
            account.borrowBook(book);
            return true;
        }
        return false;
    }

    /**
     * 用户还书
     *
     * @param accountId 用户Id
     * @param bookId 书籍Id
     * @return 用户是否还书成功
     */
    public static Boolean returnBook(int accountId,int bookId){
        if(!allBooks.containsKey(bookId)||!allAccounts.containsKey(accountId)){
            return false;
        }
        Account account = allAccounts.get(accountId);
        Book book = allBooks.get(bookId);
        book.returnBook(accountId);
        account.returnBook(book);
        return true;
    }

    /**
     * 增添新的书籍
     *
     * @param name 书籍名字
     * @param info 书籍信息
     * @return 增添的新的book实例
     */
    public static Book addBook(String name, String info){
        Book book = new Book(bookInitId++ ,name,info);
        allBooks.put(book.getBookId(),book);
        allBooks1.put(book.getName(),book);
        return book;
    }

    /**
     * 删除书籍
     *
     * @param bookId 书籍Id
     */
    public static boolean removeBook(String bookId){
        int bookIdTemp=Integer.parseInt(bookId);
        if(allBooks.containsKey(bookIdTemp)){
            Book book = allBooks.get(bookIdTemp);
            allBooks.remove(bookIdTemp);
            if(allBooks1.containsKey(book.getName())){
                allBooks1.remove(book.getName());
                return true;
            }
        }
        return false;
    }

    /**
     * 将某个用户变成一个管理员
     *
     * @return 是否修改成功
     */
    public static boolean addAdmin(String userAccountId){
        if(allAccounts.containsKey(Integer.parseInt(userAccountId))){
            allAccounts.get(Integer.parseInt(userAccountId)).setStatus(true);
            return true;
        }
        return false;
    }

    /**
     * 删除用户帐号
     *
     * @param userAccountId 需删除的用户Id
     * @return 是否删除成功
     */
    public static boolean removeUser(String userAccountId){
        if(allAccounts.containsKey(Integer.parseInt(userAccountId))){
            Account user=allAccounts.get(Integer.parseInt(userAccountId));
            if(!user.getStatus()){
                allAccounts.remove(Integer.parseInt(user.getAccountId()));
                return true;
            }
        }
        return false;
    }

    /**
     * 按照用户Id查找用户的具体信息
     *
     * @param userId 用户Id
     * @return 返回一个Account实例
     */
    public static Account findAccount(String userId){
        if(allAccounts.containsKey(Integer.parseInt(userId))){
            return allAccounts.get(Integer.parseInt(userId));
        }
        return null;
    }
}
