/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dao;

import com.mycompany.proyectofinal1.dto.DiscoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 18072
 */
public class DiscoDAO {
    private static final String SQL_INSERT = "insert into Disco(idDisco, Nombre, Genero, No.Canciones, Artista_Nombre ) values ( ?, ?, ?, ?, ? )";
    private static final String SQL_UPDATE = "update Disco set Nombre = ? where idDisco = ?";
    private static final String SQL_DELETE = "delete from Disco where idDisco = ?";
    private static final String SQL_READ = "select Nombre, Genero from Disco where idDisco = ?";
    private static final String SQL_READ_ALL = "select * from Disco";

    private Connection conexion;

    private void conectar() {
        String usuario = "team";
        String clave = "12345";
        String url = "jdbc:mysql://localhost:3306/BDWeb";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(DiscoDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {
            ps.setInt(1, dto.getEntidad().getIdDisco());
            ps.setString(2, dto.getEntidad().getNombre());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(DiscoDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, dto.getEntidad().getIdDisco());
            ps.setString(2, dto.getEntidad().getNombre());
            ps.setString(3, dto.getEntidad().getGenero());
            ps.setString(4, dto.getEntidad().getNoCanciones());
            ps.setString(4, dto.getEntidad().getArtista_Nombre());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(DiscoDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, dto.getEntidad().getIdDisco());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public DiscoDTO read(DiscoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdDisco());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (DiscoDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    public List readAll() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            DiscoDTO dto = new DiscoDTO();
            dto.getEntidad().setNombre(rs.getString("El disco es:"));
            dto.getEntidad().setArtista_Nombre(rs.getString("De:"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        DiscoDTO dto = new DiscoDTO();
        dto.getEntidad().setIdDisco(06);
        //dto.getEntidad().setNombreEstado("escom");

        DiscoDAO dao = new DiscoDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(DiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
