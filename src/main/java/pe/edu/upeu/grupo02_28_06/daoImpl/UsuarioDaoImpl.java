/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.grupo02_28_06.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.grupo02_28_06.config.Conexion;
import pe.edu.upeu.grupo02_28_06.dao.UsuarioDao;
import pe.edu.upeu.grupo02_28_06.model.Usuario;

/**
 *
 * @author dreyna
 */
public class UsuarioDaoImpl implements UsuarioDao{
private PreparedStatement ps = null;
private ResultSet rs = null;
private Connection cx= null;
    @Override
    public int validar(String user, String pass) {
        int x = 0;
        String SQl = "select *from usuario where username = ? and password=? and estado = 1";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQl);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                x = 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int create(Usuario u) {
        int x = 0;
        String SQl = "INSERT INTO usuario(idusurio, username, password, estado, idempleado) values(null, ?, ?, 1, ?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQl);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getIdempleado());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Usuario u) {
         int x = 0;
        String SQl = "update usuario set username=?, password=?, idempleado=? where idusuario=?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQl);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getIdempleado());
            ps.setInt(4, u.getIdusuario());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQl = "delete from usuario where idusuario = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQl);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Usuario read(int id) {
       Usuario u = new Usuario();
        String SQL="select *from usuario where idusuario=?" ;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEstado(rs.getInt("estado"));
                u.setIdempleado(rs.getInt("idempleado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return u;
    }

    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        String SQL="select *from usuario" ;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEstado(rs.getInt("estado"));
                u.setIdempleado(rs.getInt("idempleado"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
