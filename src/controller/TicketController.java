package controller;

import dbutil.*;
import model.*;
import org.apache.taglibs.standard.lang.jstl.Logger;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/Ticket")
public class TicketController extends HttpServlet {
    private TicketDbUtil ticketDbUtil;
    private PatientDbUtil patientDbUtil;
    private CaissierDbUtil caissierDbUtil;
    private SpecialiteDbUtil specialiteDbUtil;
    private PersonnelDbUtil personnelDbUtil;

    @Resource(name = "jdbc/ges_cons")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ticketDbUtil = new TicketDbUtil(dataSource);
            patientDbUtil = new PatientDbUtil(dataSource);
            caissierDbUtil = new CaissierDbUtil(dataSource);
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
            if (theCommand == null) {
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listTicket(request, response);
                    break;

                case "ADD":
                    ajoutTicket(request, response);
                    break;

                case "LOADFORSELECTBOX":
                    charger(request, response);
                    break;

                case "LOAD":
                    loadTicket(request, response);
                    break;

                case "UPDATE":
                    modifier(request, response);
                    break;

                case "DELETE":
                    supprimer(request, response);
                    break;

                default:
                    listTicket(request, response);
            }
        } catch (Exception e) {
            System.out.println("Erreeur Servlet Ticket: " + e);
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    private void charger(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Patient> patients = patientDbUtil.getPatients();
        List<Caissier> caissiers = caissierDbUtil.getCaissiers();
        List<Specialite> specialites = specialiteDbUtil.getSpecialites();
        List<Personnel> personnels = personnelDbUtil.getPersonnels();

        request.setAttribute("LIST_PATIENTS", patients);
        request.setAttribute("LIST_CAISSIERS", caissiers);
        request.setAttribute("LIST_SPECIALITES", specialites);
        request.setAttribute("LIST_PERSONNELS", personnels);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add-ticket-form.jsp");
        dispatcher.forward(request, response);
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response) {
    }

    private void loadTicket(HttpServletRequest request, HttpServletResponse response) {
    }

    private void ajoutTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer specialite = Integer.parseInt(request.getParameter("id_specialite"));
        Integer id_patient = Integer.parseInt(request.getParameter("id_patient"));
        Integer id_caissier = Integer.parseInt(request.getParameter("id_caissier"));
        Integer personnel = Integer.parseInt(request.getParameter("id_personnel"));
        Double montant = Double.parseDouble(request.getParameter("montant"));
//        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        System.out.println("Avant Ajout: "+specialite+" - "+id_caissier+" - "+id_caissier+" - "+personnel+"_"+montant);
        Ticket ticket = new Ticket(null,new Date(), specialite, id_patient, id_caissier, personnel, montant);
        ticketDbUtil.addTicket(ticket);
        System.out.println("Apres Ajout: "+specialite+" - "+id_caissier+" - "+id_caissier+" - "+personnel+"_"+montant);
        System.out.println("Ticket: "+ticket);
        listTicket(request, response);
    }

    private void listTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Ticket> tickets = ticketDbUtil.getTickets();
        request.setAttribute("LIST_TICKETS", tickets);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-tickets.jsp");
        dispatcher.forward(request, response);
    }
}
