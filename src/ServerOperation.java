
public class ServerOperation {
    //按ID和Password登陆成功返回account，失败返回null
    public static Account Login(String id, String password){
        if(!ServerOperation.judgeIsNumber(id)){//如果账号不是纯数字
            return null;
        }
        int accountId = Integer.parseInt(id);//将id转化为int类型
        Account account = ServerDate.accountLogin(accountId,password);//登录
        return account;
    }
    //按姓名，学号ID和Password注册成功返回account，失败返回null
    public static Account Register(String name, String studentId, String password){
        Account account = ServerDate.accountRegister(name, studentId, password);
        return account;
    }
    //按书名查找书籍，成功返回Book,失败返回null
    public static Book searchBook(String bookName){
        return ServerDate.searchBook(bookName);
    }
    //按书ID查找书籍，成功返回Book,失败返回null
    public static Book searchBook(int bookID){
        return searchBook(bookID);
    }
    //按用户账号ID和书的ID来借书。返回Boolean;
    public static Boolean borrowBook(int accountId,int bookId){
        return ServerDate.borrowBook(accountId,bookId);
    }
    //按用户账号ID和书的ID来还书。返回Boolean;
    public static Boolean returnBook(int accountId,int bookId){
        return ServerDate.returnBook(accountId,bookId);
    }
    //按书名和书籍信息来添加书籍
    public static Book addBook(String name, String info){
        return ServerDate.addBook(name, info);
    }
    //按书籍ID来删除书籍
    public static void removeBook(int bookId){
        ServerDate.removeBook(bookId);
    }

    /**
     * 作用：将一个用户账户变成一个管理员账户
     *
     * @param adminAccountId 管理员账户
     * @param userAccountId 用户账户
     * @return 是否成功
     */
    public static Boolean addAdmin(int adminAccountId, int userAccountId) {
        return ServerDate.addAdmin(adminAccountId, userAccountId);
    }
    //按管理员ID和用户ID删除用户账号
    public static Boolean removeUser(int adminAccountId, int userAccountId){
        return ServerDate.removeUser(adminAccountId, userAccountId);
    }
    //工具

    //判断是否为纯数字
    public static boolean judgeIsNumber(String id){
        Boolean is = true;
        char[] s = id.toCharArray();
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if ((s[i] <= '0') && (s[i] >= '9')) {
                is = false;
            }
        }
        return is;
    }
    //判断密码是否大于六位，包括英文大小写和数字
    public static boolean judgePassword(String password){
        Boolean containNumber = false;
        Boolean containUpper = false;
        Boolean containLover = false;
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
