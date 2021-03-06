package servlet;

import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tracy on 2017/10/9.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        if (!name.trim().isEmpty()&&!gender.trim().isEmpty()&&!phone.trim().isEmpty()&&!email.trim().isEmpty()&&!description.trim().isEmpty()){
            user.setName(name);
            user.setGender(gender);
            user.setPhone(phone);
            user.setEmail(email);
            user.setDescription(description);
            userService.add(user);
            request.setAttribute("msg", "恭喜，成功添加客户");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }else {
            request.setAttribute("msg", "信息不完整");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
