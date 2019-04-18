package controller;

import dbutil.ConsultationDbUtil;
import dbutil.PersonnelDbUtil;
import dbutil.TicketDbUtil;
import model.Consultation;
import model.Personnel;
import model.Ticket;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@WebServlet("/Consultation")
public class ConsultationController extends HttpServlet {
    private ConsultationDbUtil consultationDbUtil;
    private PersonnelDbUtil personnelDbUtil;
    private TicketDbUtil ticketDbUtil;
    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            personnelDbUtil = new PersonnelDbUtil(dataSource);
            consultationDbUtil = new ConsultationDbUtil(dataSource);
            ticketDbUtil = new TicketDbUtil(dataSource);
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
                    listConsultation(request, response);
                    break;

                case "ADD":
                    ajoutConsultation(request, response);
                    break;

                case "LOADFORSELECTBOX":
                    charger(request, response);
                    break;

                case "LOAD":
                    loadConsultation(request, response);
                    break;

                case "UPDATE":
                    modifier(request, response);
                    break;

                case "DELETE":
                    supprimer(request, response);
                    break;

                default:
                    listConsultation(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Consultation: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response) {
    }

    private void loadConsultation(HttpServletRequest request, HttpServletResponse response) {
    }

    private void charger(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Personnel> medecins = personnelDbUtil.getMedecins();
        List<Ticket> tickets = ticketDbUtil.getTickets();

        request.setAttribute("LIST_MEDECINS", medecins);
        request.setAttribute("LIST_TICKETS", tickets);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add-consultation-form.jsp");
        dispatcher.forward(request, response);
    }

    private void ajoutConsultation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer medecin = Integer.parseInt(request.getParameter("id_medecin"));
        Integer ticket = Integer.parseInt(request.getParameter("id_ticket"));
        String motif = request.getParameter("motif");

        Consultation consultation = new Consultation(new java.sql.Date(Calendar.getInstance().getTime().getTime()), medecin, ticket, motif);
        consultationDbUtil.addConsultation(consultation);
        listConsultation(request, response);
    }

    private void listConsultation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Consultation> consultations = consultationDbUtil.getConsultations();
        request.setAttribute("LIST_CONSULTATIONS", consultations);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-consultations.jsp");
        dispatcher.forward(request, response);
    }
}
