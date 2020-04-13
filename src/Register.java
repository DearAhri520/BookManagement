import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author DearAhri520
 */
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theUserPassword=req.getParameter("theFirstUserPassword");
        //添加新用户

        //跳转到登录界面
        resp.sendRedirect("login.html");
    }
}
