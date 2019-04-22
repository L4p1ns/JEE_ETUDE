//package controller;
//
//import dbutil.MedecinDbUtil;
//import dbutil.PersonnelDbUtil;
//import model.Medecin;
//import model.Personnel;
//
//import javax.annotation.Resource;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/Medecin")
//public class MedecinController extends HttpServlet {
//
//    private MedecinDbUtil medecinDbUtil;
//    private PersonnelDbUtil personnelDbUtil;
//
//    @Resource(name = "jdbc/ges_cons")
//    private DataSource dataSource;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        try {
//            personnelDbUtil = new PersonnelDbUtil(dataSource);
//            medecinDbUtil = new MedecinDbUtil(dataSource);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            // read the "command" parameter
//            String theCommand = request.getParameter("command");
//            if (theCommand == null) {
//                theCommand = "LIST";
//            }
//            // route to the appropriate method
//            switch (theCommand) {
//
//                case "LIST":
//                    listMedecin(request, response);
//                    break;
//
//                case "ADD":
//                    ajout(request, response);
//                    break;
//
//                case "LOAD":
//                    loadMedecin(request, response);
//                    break;
//
//                case "UPDATE":
//                    modifier(request, response);
//                    break;
//
//                case "DELETE":
//                    supprimer(request, response);
//                    break;
//
//                default:
//                    listMedecin(request, response);
//            }
//        } catch (Exception e) {
//            System.out.println("Erreeur Servlet Specialite: " + e);
//            System.out.println(e.getMessage());
//            throw new ServletException(e);
//        }
//    }
//
//    private void supprimer(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void modifier(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void loadMedecin(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void ajout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String matricule = request.getParameter("matricule");
//        String nom = request.getParameter("nom");
//        String dateNaissance = request.getParameter("dateNaissance");
//        String sexe = request.getParameter("sexe");
//        String telephone = request.getParameter("tel");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String grade = request.getParameter("grade");
//
//        Medecin medecin = new Medecin(null, matricule, nom, dateNaissance, telephone, sexe, email, password, grade);
//
//        medecinDbUtil.addMedecin(medecin);
//        listMedecin(request, response);
//    }
//
//    private void listMedecin(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<Personnel> medecins = personnelDbUtil.getMedecins();
//        request.setAttribute("LIST_MEDECIN", medecins);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-medecins.jsp");
//        dispatcher.forward(request, response);
//    }
//}
