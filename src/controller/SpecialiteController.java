package controller;

import dbutil.PersonnelDbUtil;
import dbutil.SpecialiteDbUtil;
import model.Personnel;
import model.Specialite;

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

@WebServlet("/Specialite")
public class SpecialiteController extends HttpServlet {
    private SpecialiteDbUtil specialiteDbUtil;
    private PersonnelDbUtil personnelDbUtil;

    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            specialiteDbUtil = new SpecialiteDbUtil(dataSource);
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

            // if the command is missing, then default to listing patients
            if (theCommand == null) {
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listSpecialite(request, response);
                    break;
                case "LOADPERSONNEL":
                    chargerPersonnel(request, response);
                    break;

                case "ADD":
                    ajout(request, response);
                    break;

                case "LOAD":
                    loadSpecialte(request, response);
                    break;

                case "UPDATE":
                    modifier(request, response);
                    break;

                case "DELETE":
                    supprimer(request, response);
                    break;

                default:
                    listSpecialite(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Specialite: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void chargerPersonnel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Personnel> personnels = personnelDbUtil.getPersonnels();
//        List<Personnel> personnels = personnelDbUtil.getMedecins();
        request.setAttribute("LIST_PERSONNEL", personnels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add-specialite-form.jsp");
        dispatcher.forward(request, response);
    }

    private void loadSpecialte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String idspecialite = request.getParameter("specialiteId");
        Specialite specialite = specialiteDbUtil.getSpecialite(idspecialite);

        // place patient in the request attribute
        request.setAttribute("THE_SPECIALITE", specialite);

        // send to jsp page: update-patient-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-specialite.jsp");
        dispatcher.forward(request, response);
    }

    private void ajout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nom = request.getParameter("nom");
        int tarif = Integer.parseInt(request.getParameter("tarif"));
        int personnel_id = Integer.parseInt(request.getParameter("personnel_id"));

        Specialite specialite = new Specialite(null, nom, tarif, personnel_id);

        specialiteDbUtil.addSpecialite(specialite);

        listSpecialite(request, response);
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        Integer tarif = Integer.valueOf(request.getParameter("tarif"));
        Integer personnel_id = Integer.valueOf(request.getParameter("personnel_id"));

        Specialite specialite = new Specialite(id, nom, tarif, personnel_id);
        specialiteDbUtil.updateSpecialite(specialite);
        listSpecialite(request, response);
    }

    private void listSpecialite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Personnel> personnels = personnelDbUtil.getPersonnels();
        request.setAttribute("LIST_PERSONNEL", personnels);
        personnels.forEach(p -> System.out.println("Matricule: " + p.getMatricule()));

        List<Specialite> specialites = specialiteDbUtil.getSpecialites();
        request.setAttribute("SPECIALTE_LIST", specialites);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-specialites.jsp");
        dispatcher.forward(request, response);
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String specialiteId = request.getParameter("specialiteId");

        specialiteDbUtil.deleteSpecialite(specialiteId);

        listSpecialite(request, response);
    }

}
