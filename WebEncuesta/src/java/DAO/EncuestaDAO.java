/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.VO_Encuesta;
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
public class EncuestaDAO 
{
    
    private Conexion oConexion = new Conexion();

    public List<VO_Encuesta> getListarEncuestas()
    {
        Connection oConnection = null;
        Statement oStatement = null;
        ResultSet rs = null;
        List<VO_Encuesta> ListaEncuesta = new ArrayList<VO_Encuesta>();
        String sSql;
        VO_Encuesta vo_Encuesta ;
        boolean bValido = oConexion.getConectar();
        if (bValido)
        {
            oConnection = oConexion.getoConnection();
        }
        sSql ="SELECT NumeroDocumento,Email,Comentarios,MarcaPC,FechaRespuesta,HoraRespuesta FROM Encuestas";
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = oStatement.executeQuery(sSql);
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next())
            {
                vo_Encuesta = new VO_Encuesta();
                vo_Encuesta.setNumeroDocumento(rs.getLong(1));
                vo_Encuesta.setEmail(rs.getString(2));
                vo_Encuesta.setComentarios(rs.getString(3));
                vo_Encuesta.setMarcaPC(rs.getString(4));
                vo_Encuesta.setFechaRespuesta(rs.getString(5));
                vo_Encuesta.setHoraRespuesta(rs.getString(6));
                ListaEncuesta.add(vo_Encuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        oConexion.getDesconectar();
        return ListaEncuesta;
    }

    public boolean setInsertarEncuesta(VO_Encuesta vo_Encuesta)
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
        sSql ="insert into Encuestas (NumeroDocumento,Email,Comentarios,MarcaPC,FechaRespuesta,HoraRespuesta) values (";
        sSql = sSql + vo_Encuesta.getNumeroDocumento().toString();
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Encuesta.getEmail().toString()+ "' ";
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Encuesta.getComentarios().toString()+ "' ";
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Encuesta.getMarcaPC().toString()+ "' ";
        sSql = sSql + " ,";
        sSql = sSql + " '" + vo_Encuesta.getFechaRespuesta().toString()+ "' ";
        sSql = sSql + " , ";
        sSql = sSql + " '" + vo_Encuesta.getHoraRespuesta().toString()+ "' ";
        sSql = sSql + " ) ";
                
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            oStatement.execute(sSql);
            bEjecucion = true;
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oConexion.getDesconectar();
        return bEjecucion;
    }
    
    public boolean setEliminarEncuesta(VO_Encuesta vo_Encuesta)
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
        sSql ="delete from Encuestas where NumeroDocumento = ";
        sSql = sSql + vo_Encuesta.getNumeroDocumento().toString();
                
        try { 
            oStatement = oConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            oStatement.execute(sSql);
            bEjecucion = true;
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oConexion.getDesconectar();
        return bEjecucion;
    }

}