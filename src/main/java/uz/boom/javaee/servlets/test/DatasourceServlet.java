package uz.boom.javaee.servlets.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DatasourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String username = context.getInitParameter("datasource.username");
        String password = context.getInitParameter("datasource.password");
        PrintWriter writer = resp.getWriter();
        writer.write("Username : " + username + "\n");
        writer.write("Password : " + password + "\n");

        ServletConfig config = getServletConfig();
        String id = config.getInitParameter("aws.secret_id");
        String key = config.getInitParameter("aws.secret_key");
        writer.write("AWS Id : " + id + "\n");
        writer.write("AWS Key : " + key + "\n");
    }
}
