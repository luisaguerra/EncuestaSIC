/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Luis Augusto Guerra
 */
public class VO_DatosConexion 
{
        private String sDireccionIP;
        private String sPuerto;
        private String sBaseDatos;
        private String sUsuarioSQL;
        private String sClaveSQL;

    public VO_DatosConexion() 
    {
        this.sDireccionIP = "127.0.0.1";
        this.sPuerto = "1433";
        this.sBaseDatos = "Encuesta";
        this.sUsuarioSQL = "sa";
        this.sClaveSQL = "12345";

    }

        
        
    public VO_DatosConexion( String sDireccionIP, String sPuerto, String sBaseDatos, String sUsuarioSQL, String sClaveSQL) {
        this.sDireccionIP = sDireccionIP;
        this.sPuerto = sPuerto;
        this.sBaseDatos = sBaseDatos;
        this.sUsuarioSQL = sUsuarioSQL;
        this.sClaveSQL = sClaveSQL;
    }

    public String getsDireccionIP() {
        return sDireccionIP;
    }

    public void setsDireccionIP(String sDireccionIP) {
        this.sDireccionIP = sDireccionIP;
    }

    public String getsPuerto() {
        return sPuerto;
    }

    public void setsPuerto(String sPuerto) {
        this.sPuerto = sPuerto;
    }

    public String getsBaseDatos() {
        return sBaseDatos;
    }

    public void setsBaseDatos(String sBaseDatos) {
        this.sBaseDatos = sBaseDatos;
    }

    public String getsUsuarioSQL() {
        return sUsuarioSQL;
    }

    public void setsUsuarioSQL(String sUsuarioSQL) {
        this.sUsuarioSQL = sUsuarioSQL;
    }

    public String getsClaveSQL() {
        return sClaveSQL;
    }

    public void setsClaveSQL(String sClaveSQL) {
        this.sClaveSQL = sClaveSQL;
    }
        
    
}
