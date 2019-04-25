/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Gestion.GestionLogin;
import VO.VO_Sesion;
import VO.VO_Usuario;
import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis Augusto Guerra
 */
@Path("/Login")
public class ServicioLogin 
{
    public static List<VO_Usuario> ListaUsuarios = new ArrayList<VO_Usuario>();
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{ParaUsuario}/{ParaClave}")
    public String ValidarLogin( 
            @PathParam("ParaUsuario")   String Usuario,
            @PathParam("ParaClave")     String Clave)
    {
        VO_Usuario vo_Usuario = new VO_Usuario();
        VO_Sesion vo_Sesion = null;

        String sMensaje;
        sMensaje = "";
        
        vo_Usuario.setClaveUsuario(Clave);
        vo_Usuario.setCodigoUsuario(Usuario);
        GestionLogin oGestionLogin = new GestionLogin();
        vo_Sesion = oGestionLogin.Validar(vo_Usuario);
        if (vo_Sesion!= null)
            sMensaje = "Login Valido" + "|" + vo_Sesion.getSesion();
        else
            sMensaje = "Login Invalido"+"|"+"0";
        
        return sMensaje;
    }
    
   
}
