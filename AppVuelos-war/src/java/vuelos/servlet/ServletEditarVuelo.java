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
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
@WebServlet(name = "ServletEditarVuelo", urlPatterns = {"/ServletEditarVuelo"})
public class ServletEditarVuelo extends HttpServlet {

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
        
        String flightId = request.getParameter("idVuelo");
        String segmentNumberString = request.getParameter("segmentNumber");
        int segmentNumber = Integer.parseInt(segmentNumberString);
        
        Flight vuelo = this.flightFacade.findByPK(flightId, segmentNumber);
        List<City> aeropuertos = this.cityFacade.findAll();
        
        request.setAttribute("idVuelo", vuelo.getFlightPK().getFlightId());
        request.setAttribute("segmentNumber", vuelo.getFlightPK().getSegmentNumber());
        
        request.setAttribute("aeropuertoOrigen", vuelo.getOrigAirport());
        request.setAttribute("horaSalida", vuelo.getDeparTimeString());
        request.setAttribute("aeropuertoDestino", vuelo.getDestAirport());
        request.setAttribute("horaLlegada", vuelo.getArriveTimeString());
        request.setAttribute("meal", vuelo.getMeal());
        request.setAttribute("flyingTime", vuelo.getFlyingTime());
        request.setAttribute("miles", vuelo.getMiles());
        request.setAttribute("aircraft", vuelo.getAircraft());
        
        request.setAttribute("aeropuertos",aeropuertos);
        
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/editar.jsp");
        rd.forward(request, response);
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
