package controller;

import dbutil.PersonnelDbUtil;
import model.Personnel;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
    private PersonnelDbUtil personnelDbUtil;

    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            personnelDbUtil = new PersonnelDbUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LOGIN";
            }
            // route to the appropriate method
            switch (theCommand) {
                case "LOGIN":
                    login(request, response);
                    break;
                case "LOGINPOST":
                    loginPost(request, response);
                    break;
                default:
                    login(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Login: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void loginPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Personnel personnel = personnelDbUtil.getPersonnelByEmailAndPassword(email, password);
        if (personnel != null) {
            if (personnel.getType().equals("MEDECIN")) {
                HttpSession session = request.getSession();
                session.setAttribute("medecin", personnel);
                response.sendRedirect(request.getContextPath() + "/Consultation");
            } else if (personnel.getType().equals("CAISSIER")) {
                HttpSession session = request.getSession();
                session.setAttribute("caissier", personnel);
                response.sendRedirect(request.getContextPath() + "/Ticket");
            } else System.out.println("Not Authorise.......");
        } else response.sendRedirect(request.getContextPath() + "/Login");

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
