package uz.boom.javaee.servlets.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/first.html");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("gjkee.html");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String message = "Hello-" + name;
//        Cookie cookie = new Cookie("message", message);
        HttpSession session = req.getSession();
        session.setAttribute("message", message);
//        req.setAttribute("message", message);
//        resp.addCookie(cookie);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/second");
        dispatcher.forward(req, resp);
    }
}
