/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.VO_MarcaPC;
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
public class MarcaPCDAO 
{
    
    private Conexion oConexion = new Conexion();

    public List<VO_MarcaPC> getListarMarcaPC()
    {
        Connection oConnection = null;
        Statement oStatement = null;
        ResultSet rs = null;
        List<VO_MarcaPC> ListaMarcaPC = new ArrayList<VO_MarcaPC>();
        String sSql;
        VO_MarcaPC vo_usuario ;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        sSql ="select codigomarcapc, descripcionmarcapc from marcapcs";
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaPCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = oStatement.executeQuery(sSql);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaPCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next())
            {
                vo_usuario = new VO_MarcaPC();
                vo_usuario.setCodigoMarcaPC(rs.getString(1));
                vo_usuario.setDescripcionMarcaPC(rs.getString(2));
                ListaMarcaPC.add(vo_usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaPCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        oConexion.getDesconectar();
        return ListaMarcaPC;
    }
    
    
}
