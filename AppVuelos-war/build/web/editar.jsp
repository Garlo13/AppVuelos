<%-- 
    Document   : editar
    Created on : 04-may-2017, 19:58:42
    Author     : Adrián
--%>

<%@page import="appvuelos.entity.City"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<City> aeropuertos = (List<City>) request.getAttribute("aeropuertos");

    String idVuelo = (String) request.getAttribute("idVuelo");
    int segmentNumber = (Integer) request.getAttribute("segmentNumber");
    City aeropuertoOridgen = (City) request.getAttribute("aeropuertoOrigen");
    String horaSalidaString = (String) request.getAttribute("horaSalida");
    City aeropuertoDestino = (City) request.getAttribute("aeropuertoDestino");
    String horaLlegadaString = (String) request.getAttribute("horaLlegada");
    Character meal = (Character) request.getAttribute("meal");
    Double flyingTime = (Double) request.getAttribute("flyingTime");
    int miles = (Integer) request.getAttribute("miles");
    String aircraft = (String) request.getAttribute("aircraft");
    
    String checkB = "";
    String checkL = "";
    String checkS = "";
    String checkD = "";
    
    switch(meal){
        case 'B': checkB = "selected";
        break;
        case 'L': checkL = "selected";
        break;
        case 'S': checkS = "selected";
        break;
        case 'D': checkD = "selected";
        break;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="ServletActualizarVuelo" method="post">
            <input type="hidden" name="idVuelo" value="<%=idVuelo%>" />
            <input type="hidden" name="segmentNumber" value="<%=segmentNumber %>" />
            Aeropuerto de origen: <select name="aeropuertoOrigen" >
                <%
                    for (City aeropuerto : aeropuertos) {
                        if (aeropuerto.getAirport().equals(aeropuertoOridgen.getAirport())) {
                %>
                <option selected="selected" value="<%=aeropuerto.getAirport()%>"><%=aeropuerto.getCityName()%></option>
                <%
                } else {
                %>
                <option value="<%=aeropuerto.getAirport()%>"><%=aeropuerto.getCityName()%></option>
                <%
                        }
                    }
                %>
            </select>
            <br/>
            Hora de partida: <input type="time" step="1" name="horaPartida" value="<%= horaSalidaString%>">
            <br/>
            Aeropuerto de destino: <select name="aeropuertoDestino" >
                <%
                    for (City aeropuerto : aeropuertos) {
                        if (aeropuerto.getAirport().equals(aeropuertoDestino.getAirport())) {
                %>
                <option selected="selected" value="<%=aeropuerto.getAirport()%>"><%=aeropuerto.getCityName()%></option>
                <%
                } else {
                %>
                <option value="<%=aeropuerto.getAirport()%>"><%=aeropuerto.getCityName()%></option>
                <%
                        }
                    }
                %>
            </select>
            <br/>
            Hora de Llegada <input type="time" step="1" name="horaLlegada" value="<%= horaLlegadaString%>">
            <br/>
            Comida: <select name="comida">
                <option value="B" <%=checkB%> >B</option>
                <option value="L" <%=checkL%> >L</option>
                <option value="S" <%=checkS%> >S</option>
                <option value="D" <%=checkD%> >D</option>
            </select>
            <br/>
            Tiempo de vuelo: <input type="number" name="tiempoDeVuelo" value="<%=flyingTime%>">
            <br/>
            Millas: <input type="number" name="miles" value="<%=miles%>">
            <br/>
            Aircraft: <input type="text" name="aircraft" value="<%=aircraft%>">
            <br/>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
