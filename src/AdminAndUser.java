import java.util.*;

/**
 * @author DearAhri520
 */
public class AdminAndUser{

    /**
     * 该静态变量是普通用户的初始账号 每创建一个初始用户 该静态变量便自增
     */
    private static int theUserAccount=100000;
    private int theUserAccountFirstValue=100000;

    static class User{
        String userName;
        String password;

        /**
         * 所有借阅的书籍
         */
        HashMap<String,Integer> allBorrowBooks=new HashMap<>();

        User(String userName,String password){
            this.password=password;
            this.userName=userName;
        }

        /**
         * 设置用户新密码
         *
         * @param password 新密码
         * @return boolean变量
         */
        boolean setUserPassword(String password){
            this.password=password;
            return true;
        }
        
        /**
         * 注意 这里的equals方法只使用了userName与password 即 若用户名和密码相同 则认为其元素相同
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(userName, user.userName) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName, password);
        }
    }


    /**
     * allUser:储存所有的普通用户
     */
    private ArrayList<User> allUser=new ArrayList<>();

    /**
     * allAdmin:储存所有的管理员
     */
    private ArrayList<User> allAdmin=new ArrayList<>();

    /**
     * 构造函数私有化
     */
    private AdminAndUser(){}

    /**
     * 这里采用的是单例设计模式
     */
    private static AdminAndUser instance=new AdminAndUser();

    /**
     *返回一个AdminAndUser实例
     *
     * @return 返回一个AdminAndUser的实例
     */
    static AdminAndUser getAdminAndUserInstance(){
        return instance;
    }

    /**
     * 返回所有的用户信息
     *
     * @return ArrayList
     */
    ArrayList<User> getAllUser(){
        return this.allUser;
    }

    /**
     * 返回所有的管理员信息
     *
     * @return ArrayList
     */
    ArrayList<User> getAllAdmin(){
        return this.allAdmin;
    }
    
    /**
     * 添加一个普通用户（即注册时需要调用的函数）
     *
     * @param password  用户密码
     * @return String类型 为用户的账号
     */
    String addUser(String password){
      allUser.add(theUserAccount-theUserAccountFirstValue,new User(String.valueOf(theUserAccount),password));
      theUserAccount++;
      return String.valueOf(theUserAccount-1);
    }

    /**
     * 添加一个管理员
     *
     * @param userName 管理员名
     * @param password 管理员密码
     * @return boolean变量 判断是否添加成功
     */
    boolean addAdmin(String userName,String password){
        return allAdmin.add(new User(userName, password));
    }

    /**
     * 删除一个普通用户
     * 思路：替换成null
     *
     * @param userName 普通用户名
     * @return  boolean变量 判断是否删除成功
     */
    boolean deleteUser(String userName){
        User theUserTemp=allUser.get(Integer.parseInt(userName)-theUserAccountFirstValue);
        if(!theUserTemp.userName.equals(userName)){
            return false;
        }
        allUser.set((Integer.parseInt(userName)-theUserAccountFirstValue),null);
        return true;
    }

    /**
     * 根据用普通用户账号查询该普通用户是否存在（只查询该用户是否存在 不作它用）
     * 
     * @param userName 用户账号
     * @return 布尔变量 该账号存在返回true 否则返回false
     */
    boolean findUser(String userName){
        return allUser.get(Integer.parseInt(userName) - theUserAccountFirstValue).userName.equals(userName);
    }

    /**
     *修改普通用户的密码
     *
     * @param userName 用户账号
     * @param oldPassword 用户老密码
     * @param newPassword 用户新密码
     * @return boolean变量 判断更改密码是否成功
     */
    boolean changeUserPassword(String userName,String oldPassword,String newPassword){
        int index=Integer.parseInt(userName)-theUserAccountFirstValue;
        User userTemp=allUser.get(index);
        if(!userTemp.userName.equals(userName)||!userTemp.password.equals(oldPassword)){
            return false;
        }
        if(newPassword.equals(oldPassword)){
            return false;
        }
        return allUser.get(index).setUserPassword(newPassword);
    }

    /**
     *修改管理员用户的密码
     *
     * @param userName 管理员账号
     * @param oldPassword 管理员老密码
     * @param newPassword 管理员新密码
     * @return boolean变量 判断更改密码是否成功
     */
    boolean changeAdminPassword(String userName,String oldPassword,String newPassword){
        for(int i=0;i<allAdmin.size();i++){
            if(allAdmin.get(i).userName.equals(userName)&&allAdmin.get(i).userName.equals(oldPassword)){
                allAdmin.get(i).setUserPassword(newPassword);
                return true;
            }
        }
        return false;
    }
    /**
     *用户借书
     *
     * @param userName 用户账号
     * @param bookName 书籍名称
     * @param bookNumber 借走的书籍数量
     * @return boolean变量
     */
    boolean userBorrowBook(String userName, String bookName, int bookNumber){
        int index=Integer.parseInt(userName)-theUserAccountFirstValue;
        User user=this.allUser.get(index);
        //如果用户的借书名单中有这本书 则修改借书数据
        if(user.allBorrowBooks.containsKey(bookName)){
            Integer oldBookNumber=this.allUser.get(index).allBorrowBooks.remove(bookName);
            this.allUser.get(index).allBorrowBooks.put(bookName,oldBookNumber+bookNumber);
        }else{
            //如果用户的借书名单中没有这本书 则直接添加数据
            this.allUser.get(index).allBorrowBooks.put(bookName,bookNumber);
        }
        return true;
    }

    /**
     *用户还书
     *
     * @param userName 用户账号
     * @param bookName 书籍名称
     * @param bookNumber 归还的书籍数量
     * @return boolean变量 返回用户是否借书成功
     */
    boolean userReturnBook(String userName,String bookName,int bookNumber){
        int index=Integer.parseInt(userName)-theUserAccountFirstValue;
        User user=this.allUser.get(index);
        //如果用户的借书名单中有这本书籍
        if(user.allBorrowBooks.containsKey(bookName)){
            //如果用户的借阅的书籍数量大于等于用户想归还的书籍数量
            if(user.allBorrowBooks.get(bookName)>=bookNumber){
                Integer oldBookNumber=this.allUser.get(index).allBorrowBooks.remove(bookName);
                this.allUser.get(index).allBorrowBooks.put(bookName,oldBookNumber-bookNumber);
                return true;
            }
        }
        return false;
    }
}
