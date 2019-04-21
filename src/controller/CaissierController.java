package controller;

import dbutil.CaissierDbUtil;
import dbutil.PersonnelDbUtil;
import model.Caissier;
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

@WebServlet("/Caissier")
public class CaissierController extends HttpServlet {
    private CaissierDbUtil caissierDbUtil;
    private PersonnelDbUtil personnelDbUtil;

    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            caissierDbUtil = new CaissierDbUtil(dataSource);
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
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listCaissier(request, response);
                    break;

                case "ADD":
                    ajout(request, response);
                    break;

                case "LOAD":
                    loadCaissier(request, response);
                    break;

                case "UPDATE":
                    modifier(request, response);
                    break;

                case "DELETE":
                    supprimer(request, response);
                    break;

                default:
                    listCaissier(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Caissier: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response) {
    }

    private void loadCaissier(HttpServletRequest request, HttpServletResponse response) {
    }

    private void ajout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String telephone = request.getParameter("tel");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        Caissier caissier = new Caissier(null, matricule, nom, dateNaissance, telephone, sexe, email, password);
        caissierDbUtil.addCaissier(caissier);
        listCaissier(request, response);
    }

    private void listCaissier(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Personnel> caissiers = personnelDbUtil.getCaissiers();
        request.setAttribute("LIST_CAISSIER", caissiers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-caissiers.jsp");
        dispatcher.forward(request, response);
    }
}
