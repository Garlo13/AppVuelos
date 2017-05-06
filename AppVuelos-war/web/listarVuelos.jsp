<%-- 
    Document   : listarvuelos
    Created on : 04-may-2017, 0:38:16
    Author     : Adrián
--%>

<%@page import="appvuelos.entity.Flight"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Flight> vuelos = (List<Flight>) request.getAttribute("vuelos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <%
                for (Flight vuelo : vuelos) {
            %>
            <tr>
                <td><%= vuelo.getFlightPK().getFlightId()%></td>
                <td><%= vuelo.getFlightPK().getSegmentNumber()%></td>
                <td><%= vuelo.getOrigAirport().getCityName()%></td>
                <td><%= vuelo.getDeparTimeString()%></td>
                <td><%= vuelo.getDestAirport().getCityName()%></td>
                <td><%= vuelo.getArriveTimeString()%></td>
                <td><%= vuelo.getMeal()%></td>
                <td><%= vuelo.getFlyingTime()%></td>
                <td><%= vuelo.getMiles() %></td>
                <td><%= vuelo.getAircraft() %></td>
                <td><a href="ServletEditarVuelo?idVuelo=<%=vuelo.getFlightPK().getFlightId()%>&segmentNumber=<%=vuelo.getFlightPK().getSegmentNumber()%>">Editar</a></td>
                <td><a href="ServletBorrarVuelo?idVuelo=<%=vuelo.getFlightPK().getFlightId()%>&segmentNumber=<%=vuelo.getFlightPK().getSegmentNumber()%>">Borrar</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
