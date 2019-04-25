/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.VO_Sesion;
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
public class SesionDAO 
{
    
    private Conexion oConexion = new Conexion();

    public List<VO_Sesion> getListarSesions()
    {
        Connection oConnection = null;
        Statement oStatement = null;
        ResultSet rs = null;
        List<VO_Sesion> ListaSesion = new ArrayList<VO_Sesion>();
        String sSql;
        VO_Sesion vo_Sesion ;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        sSql ="SELECT Sesion,CodigoUsuario,EstadoSesion FROM Sesiones";
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = oStatement.executeQuery(sSql);
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next())
            {
                vo_Sesion = new VO_Sesion();
                vo_Sesion.setSesion(rs.getString(1));
                vo_Sesion.setCodigoUsuario(rs.getString(2));
                vo_Sesion.setEstadoSesion(rs.getString(3));
                ListaSesion.add(vo_Sesion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        oConexion.getDesconectar();
        return ListaSesion;
    }

    public boolean setInsertarSesion(VO_Sesion vo_Sesion)
    {
        Connection oConnection = null;
        Statement oStatement = null;
        String sSql;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        boolean bEjecucion = false;
        sSql ="insert into Sesiones (Sesion,CodigoUsuario,EstadoSesion) values (";

        sSql = sSql + " '" + vo_Sesion.getSesion().toString()+ "' ";
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Sesion.getCodigoUsuario().toString()+ "' ";
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Sesion.getEstadoSesion().toString()+ "' ";
        sSql = sSql + " ) ";
                
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            oStatement.execute(sSql);
            bEjecucion = true;
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oConexion.getDesconectar();
        return bEjecucion;
    }
    
    public boolean setEliminarSesion(VO_Sesion vo_Sesion)
    {
        Connection oConnection = null;
        Statement oStatement = null;
        String sSql;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        boolean bEjecucion = false;
        sSql ="delete from Sesiones where sesion = ";
        sSql = sSql + vo_Sesion.getSesion().toString();
                
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            oStatement.execute(sSql);
            bEjecucion = true;
        } catch (SQLException ex) {
            Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oConexion.getDesconectar();
        return bEjecucion;
    }

}