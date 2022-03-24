import DomainObjects.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletWithdrawal", value = "/ServletWithdrawal")
public class ServletWithdrawal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        log("Beløbet er: " + amount);
        HttpSession session = request.getSession();
        int totalAmount = 0;

        try {
            totalAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            String exceptionMsg = "Husk beløbet skal være et tal";
            request.setAttribute("exceptionMsg", exceptionMsg);
            request.getRequestDispatcher("WEB-INF/userpage.jsp").forward(request, response);
        }

        Konto konto = (Konto) session.getAttribute("konto");
        konto.withdraw(totalAmount);
        session.setAttribute("konto", konto);
        request.getRequestDispatcher("WEB-INF/userpage.jsp").forward(request, response);

    }
}
