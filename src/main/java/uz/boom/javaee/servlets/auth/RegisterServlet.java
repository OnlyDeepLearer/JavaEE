package uz.boom.javaee.servlets.auth;

import uz.boom.javaee.config.ApplicationContextHolder;
import uz.boom.javaee.config.PasswordEncoder;
import uz.boom.javaee.dao.UserDao;
import uz.boom.javaee.exceptions.IllegalInputException;
import uz.boom.javaee.servlets.domains.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = ApplicationContextHolder.getBean(UserDao.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/auth/register.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        User user = userDao.findByUsername(username);

        if (Objects.nonNull(user))
            throw new IllegalInputException("Username already taken");
        if (Objects.isNull(password))
            throw new IllegalInputException("Password can not be null");
        if (Objects.equals(password, confirm_password))
            throw new IllegalInputException("Password do not match");

        user = User.builder()
                .username(username)
                .password(PasswordEncoder.encode(password))
                .build();
        userDao.save(user);

        resp.sendRedirect("/login");
    }
}

