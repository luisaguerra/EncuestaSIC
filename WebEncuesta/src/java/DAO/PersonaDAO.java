/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.VO_Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Augusto Guerra
 */
public class PersonaDAO 
{
    
    private Conexion oConexion = new Conexion();

    public List<VO_Usuario> getListarUsuarios()
    {
        Connection oConnection = null;
        Statement oStatement = null;
        ResultSet rs = null;
        List<VO_Usuario> ListaUsuario = new ArrayList<VO_Usuario>();
        String sSql;
        VO_Usuario vo_usuario ;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        sSql ="select codigousuario, nombreusuario, claveusuario from usuarios";
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = oStatement.executeQuery(sSql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next())
            {
                vo_usuario = new VO_Usuario();
                vo_usuario.setCodigoUsuario(rs.getString(1));
                vo_usuario.setNombreUsuario(rs.getString(2));
                vo_usuario.setClaveUsuario(rs.getString(3));
                ListaUsuario.add(vo_usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        oConexion.getDesconectar();
        return ListaUsuario;
    }
    
}