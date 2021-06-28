/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.grupo02_28_06.dao;

import java.util.List;
import pe.edu.upeu.grupo02_28_06.model.Usuario;

/**
 *
 * @author dreyna
 */
public interface UsuarioDao {
    int validar(String user, String pass);
    int create(Usuario u);
    int update(Usuario u);
    int delete(int id);
    Usuario read(int id);
    List<Usuario> readAll();
    
}
