package info.stepanoff.trsis.lab1.servlets;

import info.stepanoff.trsis.lab1.model.DataModel;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Удаление</title>");
            out.println("</head>");
            out.println("<body>");
            if(request.getParameter("group") != null){
                if(request.getParameter("group").equals(""))
                    out.println("<p>Введите номер группы!</p>");
                else
                    out.println("<p>Расписание группы " + request.getParameter("group") + " удалено!</p>");
                }
            out.println("<form action=\"delete\" method=\"POST\">");

            out.println("<h1>Выбор группы</h1>");
            out.println("Введите номер группы: <input name=\"group\">");
            out.println("<br>");
            out.println("<button onclick=\"location.href='/show'\"" +
                    "style=\"width: 180px; height:20px;\">Удалить расписание" +
                    "</button>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href=\"/example\"> Назад </a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String group = req.getParameter("group");
        DataModel model = new DataModel();
        if(!group.equals(""))
            model.getSchedule().remove(Integer.parseInt(group));
        processRequest(req, resp);
    }
}
