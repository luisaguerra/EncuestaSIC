/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Augusto Guerra
 */
public class Conexion 
{
    private Connection oConnection = null;
    VO_DatosConexion vo_DatoConexion;

    public Connection getoConnection() {
        return oConnection;
    }

    public void setoConnection(Connection oConnection) {
        this.oConnection = oConnection;
    }

    public Conexion() 
    {
        vo_DatoConexion = new VO_DatosConexion();
    }
            
    public boolean getConectar() 
    {    
        String sConnectSQL;
        boolean bValidarEstado;

        
        bValidarEstado=false;
        
        try 
        {   
            sConnectSQL = "jdbc:sqlserver://";
            sConnectSQL =  sConnectSQL + vo_DatoConexion.getsDireccionIP();
            sConnectSQL =  sConnectSQL + ":";
            sConnectSQL =  sConnectSQL + vo_DatoConexion.getsPuerto();
            sConnectSQL =  sConnectSQL + ";";
            sConnectSQL =  sConnectSQL + "databaseName="+vo_DatoConexion.getsBaseDatos();
            sConnectSQL =  sConnectSQL + ";";
            sConnectSQL =  sConnectSQL + "user="+vo_DatoConexion.getsUsuarioSQL();
            sConnectSQL =  sConnectSQL + ";";
            sConnectSQL =  sConnectSQL + "password="+vo_DatoConexion.getsClaveSQL();
            
            //Establecemos la conexión
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            oConnection = DriverManager.getConnection(sConnectSQL);
            
            bValidarEstado=true;
        }        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }

        return bValidarEstado;
    }

    public void getDesconectar()
    {
        try
        {
            this.oConnection.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
}
