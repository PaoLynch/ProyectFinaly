/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dao;

import com.mycompany.proyectofinal1.dto.DisqueraDTO;
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
public class DisqueraDAO {
    private static final String SQL_INSERT = "insert into Disquera(NombreD) values ( ? )";
    private static final String SQL_UPDATE = "update Disquera set DirCiudad = ?, DirPais = ? where NombreD = ?";
    private static final String SQL_DELETE = "delete from Disquera where NombreD = ? ";
    private static final String SQL_READ = "select DirPais from Disquera where NombreD = ? ";
    private static final String SQL_READ_ALL = "select * from Disquera";

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

    public void create(DisqueraDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {
            ps.setString(1, dto.getEntidad().getNombreD());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(DisqueraDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, dto.getEntidad().getNombreD());
            ps.setString(2, dto.getEntidad().getDirCiudad());
            ps.setString(3, dto.getEntidad().getDirPais());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(DisqueraDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_DELETE)) {
            ps.setString(1, dto.getEntidad().getNombreD());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public DisqueraDTO read(DisqueraDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setString(1, dto.getEntidad().getNombreD());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (DisqueraDTO) resultados.get(0);
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
            DisqueraDTO dto = new DisqueraDTO();
            dto.getEntidad().setNombreD(rs.getString("Disquera:"));
            dto.getEntidad().setDirPais(rs.getString("Del pais:"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        DisqueraDTO dto = new DisqueraDTO();
        dto.getEntidad().setNombreD("Universal Music México");
        //dto.getEntidad().setNombreEstado("escom");

        DisqueraDAO dao = new DisqueraDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(DisqueraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
