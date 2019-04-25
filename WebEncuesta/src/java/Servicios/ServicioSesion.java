/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Gestion.GestionSesion;
import VO.VO_Sesion;
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
@Path("/Sesion")
public class ServicioSesion 
{
    public static List<VO_Sesion> ListaSesions = new ArrayList<VO_Sesion>();
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{ParaSesion}/{ParaUsuario}")
    public String ValidarSesion( 
            @PathParam("ParaSesion")   String Sesion,
            @PathParam("ParaUsuario")     String Usuario)
    {
        VO_Sesion vo_Sesion = new VO_Sesion();
        boolean bValidar;
        bValidar = false;
        String sMensaje;
        sMensaje = "";
        
        vo_Sesion.setCodigoUsuario(Usuario);
        vo_Sesion.setSesion(Sesion);
        GestionSesion oGestionSesion = new GestionSesion();
        bValidar = oGestionSesion.Validar(vo_Sesion);
        if (bValidar == true)
            sMensaje = "Sesion Valida";
        else
            sMensaje = "Sesion Invalida";
        
        return sMensaje;
    }
}
