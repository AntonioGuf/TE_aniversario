<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Evento"%>
<%
    Evento even = (Evento) request.getAttribute("id");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> <h1><c:if test="${even.id == 0}">
                Nuevo
            </c:if> <c:if test="${even.id != 0}">
                Editar
            </c:if>
        </h1> <form action="MainController" method="post">
            <table>
                <input type="hidden" name="id" value="${even.id}">
                <tr>
                    <td>Titulo</td> <td><input type="text" name="titulo" value="${even.titulo}"></td>
                </tr>
                <tr>
                    <td>Expositor</td> <td><input type="text" name="expositor" value="${even.expositor}"></td>
                </tr>
                <tr>
                    <td>Fecha</td> <td><input type="text" name="fecha" value="${even.fecha}"></td>
                </tr>
                <tr>
                    <td>Hora</td> <td><input type="text" name="hora" value="${even.hora}"></td>
                </tr>
                <tr>
                    <td>Cupo</td> <td><input type="text" name="cupo" value="${even.cupo}"></td>
                </tr>
                <tr>
                    <td></td> <td><input type="submit" value="Enviar" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
