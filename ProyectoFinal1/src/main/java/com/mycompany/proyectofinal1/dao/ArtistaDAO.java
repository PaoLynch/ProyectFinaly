/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dao;

import com.mycompany.proyectofinal1.dto.ArtistaDTO;
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
public class ArtistaDAO {
    private static final String SQL_INSERT = "insert into Artista(NombreA, Trayectoria, NombreR, Nacionalidad) values ( ?, ?, ?, ? )";
    private static final String SQL_UPDATE = "update Artista set NombreR = ?, Trayectoria = ? where NombreA = ?";
    private static final String SQL_DELETE = "delete from Artista where NombreA = ?";
    private static final String SQL_READ = "select NombreA, Trayectoria, Nacionalidad from Artista where NombreA = ?";
    private static final String SQL_READ_ALL = "select * from Artista";

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

    public void create(ArtistaDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {
            ps.setString(1, dto.getEntidad().getNombreA());
            ps.setString(2, dto.getEntidad().getTrayectoria());
            ps.setString(3, dto.getEntidad().getNombreR());
            ps.setString(4, dto.getEntidad().getNacionalidad());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(ArtistaDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, dto.getEntidad().getNombreA());
            ps.setString(2, dto.getEntidad().getTrayectoria());
            ps.setString(3, dto.getEntidad().getNombreR());
            ps.setString(4, dto.getEntidad().getNacionalidad());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(ArtistaDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_DELETE)) {
            ps.setString(1, dto.getEntidad().getNombreA());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public ArtistaDTO read(ArtistaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setString(1, dto.getEntidad().getNombreA());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (ArtistaDTO) resultados.get(0);
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
            ArtistaDTO dto = new ArtistaDTO();
            dto.getEntidad().setNombreA(rs.getString("El artista es:"));
            dto.getEntidad().setTrayectoria(rs.getString("Con una trayectoria de:"));
            dto.getEntidad().setNacionalidad(rs.getString("De nacionalidad:"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        ArtistaDTO dto = new ArtistaDTO();
        dto.getEntidad().setNombreA("Danna Paola");

        ArtistaDAO dao = new ArtistaDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
