package web;

import basedate.connect.PoolConnectBuilder;
import basedate.dataaccess.DataManager;
import org.example.answer.AnswerService;
import org.example.domain.service.Service;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/home"}
)
public class WEBSerice extends HttpServlet {
    private DataManager dataManager;

    public void init() throws ServletException {
        dataManager = new DataManager();
        dataManager.setConnectBuilder(new PoolConnectBuilder());
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Service service = new Service();

        service.setNameService(req.getParameter("nameService"));
        service.setDescriptionService(req.getParameter("descriptionService"));

        String priseServiceStr = req.getParameter("priseService");
        int priseService = 0;
        try {
            priseService = Integer.parseInt(priseServiceStr);

        } catch (NumberFormatException e) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("Error: Incorrect value for the cost of the service");
            out.println("</body></html>");
            return;
        }

        service.setPriseService(priseService);

        AnswerService answerService = new AnswerService();
        answerService.setService(service);

        try {
            if (answerService.getService() != null) {
                dataManager.loaderService(answerService);
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("The data has been uploaded successfully");
                out.println("</body></html>");
            } else {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("Error: Incorrect data for the service");
                out.println("</body></html>");
            }
        } catch (ValidatorDataBase | ValidatorService | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
