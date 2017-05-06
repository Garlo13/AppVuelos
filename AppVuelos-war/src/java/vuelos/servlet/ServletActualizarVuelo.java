/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos.servlet;

import appvuelos.ejb.CityFacade;
import appvuelos.ejb.FlightFacade;
import appvuelos.entity.City;
import appvuelos.entity.Flight;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
@WebServlet(name = "ServletActualizarVuelo", urlPatterns = {"/ServletActualizarVuelo"})
public class ServletActualizarVuelo extends HttpServlet {

    @EJB
    private CityFacade cityFacade;

    @EJB
    private FlightFacade flightFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idVuelo = request.getParameter("idVuelo");
        String segmentNumber = request.getParameter("segmentNumber");
        String aeropuertoOrigen = request.getParameter("aeropuertoOrigen");
        String horaPartidaString = request.getParameter("horaPartida");
        String aeropuertoDestino = request.getParameter("aeropuertoDestino");
        String horaLlegadaString = request.getParameter("horaLlegada");
        String comida = request.getParameter("comida");
        String tiempoDeVueloString = request.getParameter("tiempoDeVuelo");
        String millasString = request.getParameter("miles");
        String aircraft = request.getParameter("aircraft");

        Flight vuelo = this.flightFacade.findByPK(idVuelo, Integer.parseInt(segmentNumber));
       
        City ciudadOrigen = this.cityFacade.findByAirport(aeropuertoOrigen);
        City ciudadDestino = this.cityFacade.findByAirport(aeropuertoDestino);

        Date horaPartida = null;
        Date horaLlegada = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            horaPartida = sdf.parse(horaPartidaString);
            horaLlegada = sdf.parse(horaLlegadaString);
            
        } catch (ParseException ex) {
            Logger.getLogger(ServletActualizarVuelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        vuelo.setOrigAirport(ciudadOrigen);
        vuelo.setDepartTime(horaPartida);
        vuelo.setDestAirport(ciudadDestino);
        vuelo.setArriveTime(horaLlegada);
        vuelo.setMeal(comida.charAt(0));
        vuelo.setFlyingTime(Double.parseDouble(tiempoDeVueloString));
        vuelo.setMiles(Integer.parseInt(millasString));
        vuelo.setAircraft(aircraft);
        
        this.flightFacade.edit(vuelo);
        
        response.sendRedirect("ServletListarVuelos");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
