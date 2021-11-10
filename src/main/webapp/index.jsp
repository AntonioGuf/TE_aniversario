<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Evento"%>
<%
    List<Evento> lista = (List<Evento>) request.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2" cellpadding="4" cellspacing="0">
            <tr>
                <th><h1>SEGUNDO PARCIAL DE EMERGENTES II </h1>
                    <h4><b>Nombre:</b>JOSE ANTONIO GUTIERREZ FLORES</h4>
                    <h4><b>Carnet:</b>5471404</h4></th></tr>
        </table>
        <br>
        <h1>Listado de Eventos</h1> <p> <a href="MainController?op=nuevo" >Nuevo</a> </p> <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Expositor</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Cupos</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.expositor}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td> <a href="MainController?op=editar&id=${item.id}">Editar</a> </td>
                    <td> <a href="MainController?op=eliminar&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar ?'))" >Eliminar</a> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
