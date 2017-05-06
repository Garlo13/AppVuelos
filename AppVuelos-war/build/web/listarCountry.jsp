<%-- 
    Document   : listarCountry
    Created on : 03-may-2017, 19:49:27
    Author     : Adrián
--%>

<%@page import="appvuelos.entity.Country"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //List<Country> countries = (List<Country>) request.getAttribute("countries");
    List<Country> countries = (List<Country>) session.getAttribute("countries");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .checkbox-grid li {
                display: block;
                float: left;
                width: 20%;
            }

            .boton {
                top: 80%;
                left: 50%;
                position: absolute;
            }

        </style>
    </head>
    <body>
        <form action="ServletListarVuelos" metho="post">
            <ul class="checkbox-grid">
                <%
                    for (Country country : countries) {
                %>
                <li><input type="checkbox" name="countries" value="<%= country.getCountryIsoCode()%>"> <%= country.getCountry()%></li>
                <%
                    }
                %>
            </ul>
            <input class="boton" type="submit" value="Enviar" >
        </form>

    </body>
</html>
