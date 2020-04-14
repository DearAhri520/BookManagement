/**
 * @author 贺文超
 */

public class ServerOperation {
    /**
     * 按ID和Password登陆成功返回true，失败返回false
     *
     * @param id 用户id
     * @param password 用户密码
     * @return 返回是否登陆成功
     */
    public static boolean login(String id, String password){
        if(!judgeIsNumber(id)){
            return false;
        }
        return ServerDate.accountLogin(id,password);
    }

    /**
     *按姓名，学号ID和Password注册成功返回account
     *
     * @param name 用户真实姓名
     * @param password 学生密码
     * @return 返回一个Account实例
     */
    public static Account register(String name, String password){
        return ServerDate.accountRegister(name,password);
    }

    /**
     * 按书名查找书籍，成功返回Book,失败返回null
     *
     * @param bookName 想要查询的书籍名称
     * @return 查询成功则返回Book的一个实例 未查询到则返回null（特别注意这个地方 防止空指针）
     */
    public static Book searchBook(String bookName){
        return ServerDate.searchBook(bookName);
    }

    /**
     *按书ID查找书籍，成功返回Book,失败返回null
     *
     * @param bookID 想要查询的书籍ID
     * @return 查询成功则返回Book的一个实例 未查询到则返回null（特别注意这个地方 防止空指针）
     */
    public static Book searchBook(int bookID){
        return ServerDate.searchBook(bookID);
    }

    /**
     *按用户账号ID和书的ID来借书。返回boolean
     *
     * @param accountId 用户账号
     * @param bookId 书籍ID
     * @return 返回是否借书成功
     */
    public static boolean borrowBook(int accountId,int bookId){
        return ServerDate.borrowBook(accountId,bookId);
    }

    /**
     *按用户账号ID和书的ID来还书。返回boolean
     *
     * @param accountId 用户账号
     * @param bookId 书籍ID
     * @return 返回是否还书成功
     */
    public static boolean returnBook(int accountId,int bookId){
        return ServerDate.returnBook(accountId,bookId);
    }

    /**
     *按书名和书籍信息来添加书籍
     *
     * @param bookName 书籍名称
     * @param bookInfo 书籍信息
     * @return 返回一个book实例
     */
    public static Book addBook(String bookName, String bookInfo){
        return ServerDate.addBook(bookName, bookInfo);
    }

    /**
     *按书籍ID来删除书籍
     *
     * @param bookId 书籍Id
     */
    public static boolean removeBook(String bookId){
        return ServerDate.removeBook(bookId);
    }

    /**
     * 作用：将一个普通用户账户变成一个管理员账户
     *
     * @param userAccountId 用户账户
     * @return 是否成功
     */
    public static boolean addAdmin(String userAccountId) {
        return ServerDate.addAdmin(userAccountId);
    }

    /**
     * 按照用户Id删除某个用户
     *
     * @param userAccountId 用户Id
     * @return 返回是否删除成功
     */
    public static boolean removeUser(String userAccountId){
        return ServerDate.removeUser(userAccountId);
    }

    /**
     * 判断是否为纯数字
     *
     * @param id 某个用户Id
     * @return 返回是否为纯数字构成的字符串
     */
    public static boolean judgeIsNumber(String id){
        boolean is = true;
        char[] s = id.toCharArray();
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if ((s[i] <= '0') && (s[i] >= '9')) {
                is = false;
            }
        }
        return is;
    }

    /**
     * 按照id查找某个用户的信息(如果该用户不存在 则直接返回null)
     *
     * @return 返回一个Account实例
     */
    public static Account findAccount(String userId){
        return ServerDate.findAccount(userId);
    }

    /**
     * 判断用户 普通用户返回1 管理员返回2 非法用户返回0
     *
     * @param studentId 用户Id
     * @return int类型
     */
    public static int identifyJudge(String studentId){
        return ServerDate.identifyJudge(studentId);
    }

    //判断密码是否大于六位，包括英文大小写和数字
    public static boolean judgePassword(String password){
        boolean containNumber = false;
        boolean containUpper = false;
        boolean containLover = false;
        if(password.length()<6) {
            return false;
        }
        char[] s = password.toCharArray();
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if ((s[i] >= '0') && (s[i] <= '9')) {
                containNumber = true;
            }
            else if ((s[i] >= 'A') && (s[i] <= 'Z')) {
                containUpper = true;
            }
            else if ((s[i] >= 'a') && (s[i] <= 'z')) {
                containLover = true;
            }
        }
        if(containLover && containNumber && containUpper) {
            return true;
        } else {
            return false;
        }
    }
}
