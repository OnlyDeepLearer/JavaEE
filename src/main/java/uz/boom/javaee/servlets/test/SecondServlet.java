package uz.boom.javaee.servlets.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        String message = (String) req.getAttribute("message");
        String message = null;
//        for (Cookie cookie : req.getCookies()) {
//            if (cookie.getName().equals("message")) {
//                message = cookie.getValue();
//            }
//        }
        message = (String) req.getSession().getAttribute("message");
        resp.getWriter().println(message);
    }
}
