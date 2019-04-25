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
public class VO_Usuario 
{

    public VO_Usuario() {
    }
    
    private String CodigoUsuario;
    private String ClaveUsuario;
    private String NombreUsuario;

    public VO_Usuario(String CodigoUsuario, String ClaveUsuario, String NombreUsuario) {
        this.CodigoUsuario = CodigoUsuario;
        this.ClaveUsuario = ClaveUsuario;
        this.NombreUsuario = NombreUsuario;
    }

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getClaveUsuario() {
        return ClaveUsuario;
    }

    public void setClaveUsuario(String ClaveUsuario) {
        this.ClaveUsuario = ClaveUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
    
    
}
