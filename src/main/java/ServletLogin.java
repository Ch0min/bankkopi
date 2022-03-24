import DomainObjects.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Map<String, Konto> kontosMap2 = (Map<String, Konto>) getServletContext().getAttribute("kontosMap");

        Konto konto = kontosMap2.getOrDefault(name, null);

        String exceptionMsg;

        if (konto == null ) {

            exceptionMsg = "Kontoen findes ikke!";
            request.setAttribute("exceptionMsg", exceptionMsg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (!konto.getPassword().equals(password)) {
            exceptionMsg = "Dit login er forkert, prøv igen";
            request.setAttribute("exceptionMsg", exceptionMsg);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("konto", konto);
        request.getRequestDispatcher("WEB-INF/userpage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
