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
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/Personnel")
public class PersonnelController extends HttpServlet {
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    list(request, response);
                    break;

                case "ADD":
                    ajout(request, response);
                    break;

                case "LOAD":
                    charge(request, response);
                    break;

                case "UPDATE":
                    modif(request, response);
                    break;

                case "DELETE":
                    supr(request, response);
                    break;

                default:
                    list(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Personnel: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void charge(HttpServletRequest request, HttpServletResponse response) {

    }

    private void supr(HttpServletRequest request, HttpServletResponse response) {
    }

    private void modif(HttpServletRequest request, HttpServletResponse response) {
    }

    private void ajout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String dateNaissance = request.getParameter("dateNaissance");
        String telephone = request.getParameter("tel");
        String sexe = request.getParameter("sexe");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String domaine = request.getParameter("domaine");
        String grade = request.getParameter("grade");
        String type = request.getParameter("type");

        Personnel personnel = new Personnel(null,matricule, nom, dateNaissance, telephone, sexe, email, password, domaine, grade, type);

        personnelDbUtil.addPersonnel(personnel);

        // Charger la list
        list(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Personnel> personnels = personnelDbUtil.getPersonnels();

        request.setAttribute("PERSONNEL_LIST", personnels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-personnels.jsp");
        dispatcher.forward(request, response);
    }
}
