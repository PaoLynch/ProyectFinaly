/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1.dao;


import com.mycompany.proyectofinal1.dto.CanciónDTO;
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
public class CanciónDAO {
    private static final String SQL_INSERT = "insert into Canción idCancion values ( ? )";
    private static final String SQL_UPDATE = "update Cancion set Nombre = ? where idCancion = ?  ";
    private static final String SQL_DELETE = "delete from Cancion where idCancion = ? ";
    private static final String SQL_READ = "select Nombre from Cancion where idCancion = ?";
    private static final String SQL_READ_ALL = "select * from Cancion";

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

    public void create(CanciónDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {
            ps.setInt(1, dto.getEntidad().getIdCancion());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(CanciónDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, dto.getEntidad().getIdCancion());
            ps.setString(2, dto.getEntidad().getNombre());
            ps.setString(3, dto.getEntidad().getDuracion());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(CanciónDTO dto) throws SQLException {
        conectar();
        try (PreparedStatement ps = conexion.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, dto.getEntidad().getIdCancion());
            ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public CanciónDTO read(CanciónDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCancion());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (CanciónDTO) resultados.get(0);
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
            CanciónDTO dto = new CanciónDTO();
            dto.getEntidad().setNombre(rs.getString("El nombre:"));
            dto.getEntidad().setDuracion(rs.getString("Que dura:"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        CanciónDTO dto = new CanciónDTO();
        dto.getEntidad().setIdCancion(021);
        //dto.getEntidad().setNombreEstado("escom");

        CanciónDAO dao = new CanciónDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CanciónDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
