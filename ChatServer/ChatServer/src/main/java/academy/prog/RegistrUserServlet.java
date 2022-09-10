package academy.prog;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistrUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("user_login");
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/plain");

        if (!login.matches("\\S+[A-z]") || !login.matches("^[\\w].+")) {
            pw.write("The username cannot be empty, contain spaces, or start with spaces" +
                    " or start with special characters");
            pw.close();
            return;
        }

        if (UserSession.setUserLogin(login)) {
            pw.write("Nickname busy");
            pw.close();
            return;
        }
        pw.close();

    }
}
