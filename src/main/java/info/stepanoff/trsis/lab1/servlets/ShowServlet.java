package info.stepanoff.trsis.lab1.servlets;

import info.stepanoff.trsis.lab1.entities.Day;
import info.stepanoff.trsis.lab1.entities.Week;
import info.stepanoff.trsis.lab1.model.DataModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Выбор</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"show\" method=\"POST\">");
            out.println("<h1>Выбор группы</h1>");
            out.println("Введите номер группы: <input name=\"group\">");
            out.println("<br>");
            out.println("<button onclick=\"location.href='/show'\"" +
                    "style=\"width: 180px; height:20px;\">Посмотреть расписание" +
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String group = req.getParameter("group");
        DataModel dataModel = new DataModel();
        Week week = dataModel.getSchedule().get(Integer.parseInt(group));

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Table example</title>");
            out.println("</head>");
            out.println("<body>");
            if (week == null) {
                out.println("<h1>Расписания группы " + group + " не существует!</h1>");
                out.println("<form action=\"show\" method=\"POST\">");
                out.println("<h1>Выбор группы</h1>");
                out.println("Введите номер группы: <input name=\"group\">");
                out.println("<br>");
                out.println("<button onclick=\"location.href='/show'\"" +
                        "style=\"width: 180px; height:20px;\">Посмотреть расписание" +
                        "</button>");
                out.println("<br>");
                out.println("<br>");

            } else {
                Day[] days = week.getDay();
                out.println("<form action=\"show\" method=\"POST\">");
                out.println("<h1>Выбор группы</h1>");
                out.println("Введите номер группы: <input name=\"group\">");
                out.println("<br>");
                out.println("<button onclick=\"location.href='/show'\"" +
                        "style=\"width: 180px; height:20px;\">Посмотреть расписание" +
                        "</button>");
                out.println("<br>");
                out.println("<br>");
                out.println("<h1>Расписание</h1>");

                out.println("<table>");
                out.println("<tbody>");

                for (int i = 0; i < 5; i++) {
                    switch (i) {
                        case 0 -> out.println("Понедельник<br>");
                        case 1 -> out.println("Вторник<br>");
                        case 2 -> out.println("Среда<br>");
                        case 3 -> out.println("Четверг<br>");
                        case 4 -> out.println("Пятница<br>");
                    }

                    if (!days[i].getSchedule().equals("<br>"))
                        out.println(days[i].getSchedule());
                    else
                        out.println("Выходной<br>");
                    out.println("<br>");                }
            }
            out.println("<a href=\"/example\"> Назад </a>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
