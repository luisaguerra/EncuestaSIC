/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Luis Augusto Guerra
 */
public class VO_Sesion 
{
    private String Sesion;
    private String CodigoUsuario;
    private String EstadoSesion;

    public VO_Sesion() {
    }

    public VO_Sesion(String Sesion, String CodigoUsuario, String EstadoSesion) {
        this.Sesion = Sesion;
        this.CodigoUsuario = CodigoUsuario;
        this.EstadoSesion = EstadoSesion;
    }

    public String getSesion() {
        return Sesion;
    }

    public void setSesion(String Sesion) {
        this.Sesion = Sesion;
    }

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getEstadoSesion() {
        return EstadoSesion;
    }

    public void setEstadoSesion(String EstadoSesion) {
        this.EstadoSesion = EstadoSesion;
    }
    
    
    
    
}
