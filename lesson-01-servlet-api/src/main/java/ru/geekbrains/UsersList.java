package ru.geekbrains;

import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users")
public class UsersList extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<h1>Users</h1>");
        resp.getWriter().println("<table>"); //style="width:100%"
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th> Id </th>");
        resp.getWriter().println("<th> Name </th>");
        resp.getWriter().println("<tr>");
        for (User user:userRepository.findAll()) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<th>" + user.getId() + "</th>");
            resp.getWriter().println("<th> <a href="+getServletContext().getContextPath()+"/users/"+user.getId()+">" + user.getUsername() + "</a></th>");
            resp.getWriter().println("<tr>");
        }
        resp.getWriter().println("</table>");
    }
}
