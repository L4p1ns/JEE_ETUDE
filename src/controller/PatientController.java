package controller;

import dbutil.PatientDbUtil;
import model.Patient;

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

@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
    private PatientDbUtil patientDbUtil;

    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            patientDbUtil = new PatientDbUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

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
                    listPatients(request, response);
                    break;

                case "ADD":
                    addPatient(request, response);
                    break;

                case "LOAD":
                    loadPatient(request, response);
                    break;

                case "UPDATE":
                    updatePatient(request, response);
                    break;
                case "DELETE":
                    deletePatient(request, response);
                    break;

                default:
                    listPatients(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Patient: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("patientId"));
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String dateNaissance = request.getParameter("dateNaissance");
        String telephone = request.getParameter("tel");
        String sexe = request.getParameter("sexe");
        String groupeSanguin = request.getParameter("groupeSanguin");

        // create a new patient object
        Patient patient = new Patient(id, matricule, nom, dateNaissance, telephone, sexe, groupeSanguin);
        // perform update on database
        patientDbUtil.updatePatient(patient);

        // send them back to the "list patients" page
        listPatients(request, response);
    }

    private void loadPatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read patient id from form data
        String idP = request.getParameter("patientId");

        // get patient from database (db util)
        Patient patient = patientDbUtil.getPatient(idP);

        // place patient in the request attribute
        request.setAttribute("THE_PATIENT", patient);

        // send to jsp page: update-patient-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-patient-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read patient info from form data
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String dateNaissance = request.getParameter("dateNaissance");
        String telephone = request.getParameter("tel");
        String sexe = request.getParameter("sexe");
        String groupeSanguin = request.getParameter("groupeSanguin");

        // create a new patient object
        Patient patient = new Patient(matricule, nom, dateNaissance, telephone, sexe, groupeSanguin);

        // add the patient to the database
        patientDbUtil.addPatient(patient);

        // send back to main page (the patient list)
        listPatients(request, response);
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get patient from db util
        List<Patient> patients = patientDbUtil.getPatients();

        // add patients to the request
        request.setAttribute("PATIENT_LIST", patients);

        // send to JSP page (view)
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-patients.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read patient id from form data
        String patientId = request.getParameter("patientId");

        // delete patient from database
        patientDbUtil.deletePatient(patientId);

        // send them back to "list patients"
        listPatients(request, response);
    }

}
