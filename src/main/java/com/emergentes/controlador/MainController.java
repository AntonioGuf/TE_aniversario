package com.emergentes.controlador;

import com.emergentes.modelo.Evento;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        int id;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<Evento> lista = new ArrayList<Evento>();
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (op.equals("list")) {
            String sql = "select * from seminarios";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Evento ev = new Evento();
                    ev.setId(rs.getInt("id"));
                    ev.setTitulo(rs.getString("titulo"));
                    ev.setExpositor(rs.getString("expositor"));
                    ev.setFecha(rs.getString("fecha"));
                    ev.setHora(rs.getString("hora"));
                    ev.setCupo(rs.getString("Cupo"));
                    lista.add(ev);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (op.equals("nuevo")) {
            Evento li = new Evento();
            request.setAttribute("ev", li);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                ps = conn.prepareStatement("delete from seminarios where id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (op.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                Evento lib1 = new Evento();
                ps = conn.prepareStatement("select * from seminarios where id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    lib1.setId(rs.getInt("id"));
                    lib1.setTitulo(rs.getString("titulo"));
                    lib1.setExpositor(rs.getString("expositor"));
                    lib1.setFecha(rs.getString("fecha"));
                    lib1.setHora(rs.getString("hora"));
                    lib1.setCupo(rs.getString("Cupo"));
                }
                request.setAttribute("ev", lib1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String cupo = request.getParameter("cupo");
        Evento eve = new Evento();
        eve.setId(id);
        eve.setTitulo(titulo);
        eve.setExpositor(expositor);
        eve.setFecha(fecha);
        eve.setHora(hora);
        eve.setCupo(cupo);
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            String sql = "insert into seminarios (titulo, expositor, fecha, hora, cupo) values (?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, eve.getTitulo());
                ps.setString(2, eve.getExpositor());
                ps.setString(3, eve.getFecha());
                ps.setString(4, eve.getHora());
                ps.setString(5, eve.getCupo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String sql1 = "update seminarios set titulo=?, expositor=?, fecha=?, hora=?, cupo=? where id=?";
            try {
                ps = conn.prepareStatement(sql1);
                ps.setString(1, eve.getTitulo());
                ps.setString(2, eve.getExpositor());
                ps.setString(3, eve.getFecha());
                ps.setString(4, eve.getHora());
                ps.setString(5, eve.getCupo());
                ps.setInt(6, eve.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("MainController");
    }

}
