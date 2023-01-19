package uz.boom.javaee.servlets.errorhandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/400")
public class BadRequestHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Throwable th = (Throwable) req.getParameter("javax.servlet.trho");
//        String message = th.getMessage();
//        req.setAttribute("message", message);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/errors.jsp");
        requestDispatcher.forward(req, resp);
    }
}
