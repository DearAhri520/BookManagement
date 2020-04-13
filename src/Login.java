import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DearAhri520
 */

public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("userName");
        String userPassword=req.getParameter("userPassword");
        System.out.println("用户登录:"+" username "+username+"userPassword "+userPassword);
            //没有找到该数据 返回登陆界面
            //这里可以考虑使用异步更新，就不要重新加载登录网页
    }
}
