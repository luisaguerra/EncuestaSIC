/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Gestion.GestionEncuesta;
import Gestion.GestionMarcaPC;
import Gestion.GestionSesion;
import Utilitarios.ManejoFechas;
import VO.VO_Encuesta;
import VO.VO_MarcaPC;
import VO.VO_Sesion;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis Augusto Guerra
 */
@Path("/Encuesta")
public class ServiciosEncuesta 
{
    public  List<VO_Encuesta> ListaEncuestas = new ArrayList<VO_Encuesta>();
 
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{ParaSesion}/{ParaUsuario}")
    public String Listar
            (
            @PathParam("ParaSesion") String Sesion, 
            @PathParam("ParaUsuario") String Usuario
    )
    {
        VO_Sesion vo_Sesion = new VO_Sesion();
        
        vo_Sesion.setSesion(Sesion);
        vo_Sesion.setCodigoUsuario(Usuario);
        GestionSesion oGestionSesion = new GestionSesion();
        VO_Encuesta vo_Encuesta = new VO_Encuesta();
        if (oGestionSesion.Validar(vo_Sesion))
        {

            GestionEncuesta oGestionEncuesta = new GestionEncuesta();
            ListaEncuestas = oGestionEncuesta.Listar();
        }
        else
        {
            vo_Encuesta.setComentarios("Sesion Invalida");
            ListaEncuestas.add(vo_Encuesta);
        }
        String json = new Gson().toJson(ListaEncuestas );
        return json;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{ParaSesion}/{ParaUsuario}/{ParaNumeroDocumento}/{ParaEmail}/{ParaComentarios}/{ParaMarcaPC}")
    public String Insertar
        (
            @PathParam("ParaSesion") String Sesion, 
            @PathParam("ParaUsuario") String Usuario,
            @PathParam("ParaNumeroDocumento") String NumeroDocumento, 
            @PathParam("ParaEmail") String Email,
            @PathParam("ParaComentarios") String Comentarios, 
            @PathParam("ParaMarcaPC") String MarcaPC
    )
    {
        GestionMarcaPC oGestionMarcaPC = new GestionMarcaPC();
        VO_MarcaPC vo_MarcaPC =  new VO_MarcaPC();

        VO_Sesion vo_Sesion = new VO_Sesion();
        
        vo_Sesion.setSesion(Sesion);
        vo_Sesion.setCodigoUsuario(Usuario);
        GestionSesion oGestionSesion = new GestionSesion();
        if (oGestionSesion.Validar(vo_Sesion))
        {
            VO_Encuesta vo_Encuesta = new VO_Encuesta();
            ManejoFechas mf = new ManejoFechas();
            Calendar cFecha = Calendar.getInstance();
            String sFecha = mf.DatetoStr(cFecha.getTime());
            String sHora = mf.TimetoStr(cFecha.getTime());
            Long ConsecutivoEncuesta = System.currentTimeMillis();

            vo_MarcaPC.setCodigoMarcaPC(MarcaPC);
            vo_MarcaPC = oGestionMarcaPC.Consultar(vo_MarcaPC);
            if (vo_MarcaPC != null)
            {
                vo_Encuesta.setNumeroDocumento(Long.valueOf(NumeroDocumento));        
                vo_Encuesta.setEmail(Email);
                vo_Encuesta.setComentarios(Comentarios);
                vo_Encuesta.setMarcaPC(MarcaPC);
                vo_Encuesta.setFechaRespuesta(sFecha);
                vo_Encuesta.setHoraRespuesta(sHora);
                GestionEncuesta ticket = new GestionEncuesta();
                ticket.Insertar(vo_Encuesta);
                return "Insertar "+vo_Encuesta.getNumeroDocumento().toString();
            }
            else
                return "Marca de PC " + MarcaPC + ", No Existe";
        }
        else
            return "Sesion Invalida";
    }    
        
    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{ParaSesion}/{ParaUsuario}/{ParaNumeroDocumento}")
    public String Eliminar(
            @PathParam("ParaSesion") String Sesion, 
            @PathParam("ParaUsuario") String Usuario,
            @PathParam("ParaNumeroDocumento") String NumeroDocumento
    )
    {
        VO_Sesion vo_Sesion = new VO_Sesion();
        
        vo_Sesion.setSesion(Sesion);
        vo_Sesion.setCodigoUsuario(Usuario);
        GestionSesion oGestionSesion = new GestionSesion();
        if (oGestionSesion.Validar(vo_Sesion))
        {
            GestionEncuesta ticket = new GestionEncuesta();
            VO_Encuesta vo_Encuesta = new VO_Encuesta();

            vo_Encuesta.setNumeroDocumento(Long.valueOf(NumeroDocumento));
            ticket.Eliminar(vo_Encuesta);
            return "Eliminar "+vo_Encuesta.getNumeroDocumento().toString();
        }    
               else
            return "Sesion Invalida";
    }
    
}
