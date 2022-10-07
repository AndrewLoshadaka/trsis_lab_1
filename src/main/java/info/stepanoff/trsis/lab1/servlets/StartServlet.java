/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package info.stepanoff.trsis.lab1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pavel.Stepanov
 */
@WebServlet(name = "ExampleServlet", urlPatterns = {"/example"})
public class StartServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Расписание</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Главная страница</h1>");
            out.println("<table>");
            out.println("<tbody>");

            out.println("<h1>Выберите</h1>");
            out.println("<button onclick=\"location.href='/show'\"" +
                    "style=\"width: 180px; height:20px;\">Посмотреть расписание" +
                    "</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href=\"/add\"> Добавить расписание</a>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href=\"/delete\"> Удалить </a>");

            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}
