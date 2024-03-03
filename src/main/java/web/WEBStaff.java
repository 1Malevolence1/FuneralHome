package web;

import basedate.connect.PoolConnectBuilder;
import basedate.dataaccess.DataManager;
import org.example.answer.AnswerStaff;
import org.example.domain.person.Staff;
import org.example.exception.ValidatorDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/staff")
public class WEBStaff extends HttpServlet {

    private DataManager dataManager;

    public void init() throws ServletException {
        dataManager = new DataManager();
        dataManager.setConnectBuilder(new PoolConnectBuilder());
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Staff staff = new Staff(
                req.getParameter("surname"),
                req.getParameter("name"),
                req.getParameter("patronymic"),
                LocalDate.parse(req.getParameter("dateOfBirthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                req.getParameter("telephone"),
                req.getParameter("post")

        );


        AnswerStaff answerStaff = new AnswerStaff();
        answerStaff.setStaff(staff);

        try {
            if (answerStaff.getStaff() != null) {
                dataManager.loaderStaff(answerStaff);
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("The data has been uploaded successfully");
                out.println("</body></html>");
            } else {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("Error: Incorrect data for the staff");
                out.println("</body></html>");
            }
        } catch (ValidatorDataBase  | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
