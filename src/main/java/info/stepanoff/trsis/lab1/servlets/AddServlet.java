package info.stepanoff.trsis.lab1.servlets;

import info.stepanoff.trsis.lab1.entities.Day;
import info.stepanoff.trsis.lab1.entities.Week;
import info.stepanoff.trsis.lab1.model.DataModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
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
            out.println("<div>");
            if(request.getParameter("group") != null) {
                if(request.getParameter("group").equals(""))
                    out.println("<p>Введите номер группы!</p>");
                else
                    out.println("<p>Расписание группы " + request.getParameter("group") + " добавлено!</p>");
            }
            out.println("</div>");
            out.println("<form action=\"add\" method=\"POST\">");
            out.println("Введите номер группы: <input name=\"group\"");
            out.println("<br>");

            out.println("<h1>Введите расписание</h1>");
            out.println("Понедельник<br>");
            out.println("1 пара: <input name=\"subj1\"><br>");
            out.println("2 пара: <input name=\"subj2\"><br>");
            out.println("3 пара: <input name=\"subj3\"><br>");
            out.println("4 пара: <input name=\"subj4\"><br>");
            out.println("5 пара: <input name=\"subj5\"><br>");
            out.println("6 пара: <input name=\"subj6\"><br>");
            out.println("<br>");

            out.println("Вторник<br>");
            out.println("1 пара: <input name=\"subj7\"><br>");
            out.println("2 пара: <input name=\"subj8\"><br>");
            out.println("3 пара: <input name=\"subj9\"><br>");
            out.println("4 пара: <input name=\"subj10\"><br>");
            out.println("5 пара: <input name=\"subj11\"><br>");
            out.println("6 пара: <input name=\"subj12\"><br>");
            out.println("<br>");

            out.println("Среда<br>");
            out.println("1 пара: <input name=\"subj13\"><br>");
            out.println("2 пара: <input name=\"subj14\"><br>");
            out.println("3 пара: <input name=\"subj15\"><br>");
            out.println("4 пара: <input name=\"subj16\"><br>");
            out.println("5 пара: <input name=\"subj17\"><br>");
            out.println("6 пара: <input name=\"subj18\"><br>");
            out.println("<br>");

            out.println("Четверг<br>");
            out.println("1 пара: <input name=\"subj19\"><br>");
            out.println("2 пара: <input name=\"subj20\"><br>");
            out.println("3 пара: <input name=\"subj21\"><br>");
            out.println("4 пара: <input name=\"subj22\"><br>");
            out.println("5 пара: <input name=\"subj23\"><br>");
            out.println("6 пара: <input name=\"subj24\"><br>");
            out.println("<br>");

            out.println("Пятница<br>");
            out.println("1 пара: <input name=\"subj25\"><br>");
            out.println("2 пара: <input name=\"subj26\"><br>");
            out.println("3 пара: <input name=\"subj27\"><br>");
            out.println("4 пара: <input name=\"subj28\"><br>");
            out.println("5 пара: <input name=\"subj29\"><br>");
            out.println("6 пара: <input name=\"subj30\"><br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button onclick=\"location.href='/add'\"" +
                    "style=\"width: 180px; height:20px;\">Сохранить" +
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
        String[] subjArray = new String[30];
        for(int i = 0; i < 30; i++)
            subjArray[i] = "";
        DataModel dataModel = new DataModel();
        String group = req.getParameter("group");

        if(!group.equals("")) {
            for (int i = 0; i < subjArray.length; i++) {
                subjArray[i] = req.getParameter("subj" + (i + 1));
            }

            Day[] days = new Day[5];
            StringBuilder rasp = new StringBuilder();
            for (int i = 0; i < 30; i++) {
                if (!subjArray[i].equals("")) {
                    rasp.append(i % 6 + 1).append(" пара - ").append(subjArray[i]).append("<br>");
                }
                if (i == 5 || i == 11 || i == 17 || i == 23 || i == 29) {
                    days[i / 6] = new Day(String.valueOf(rasp.append("<br>")));
                    rasp = new StringBuilder();
                }
            }
            Week week = new Week();
            week.setDay(days);
            if (!dataModel.getSchedule().containsKey(Integer.parseInt(group)))
                dataModel.setSchedule(Integer.parseInt(group), week);
        }
        processRequest(req, resp);
    }
}
