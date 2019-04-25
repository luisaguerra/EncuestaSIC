/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import DAO.PersonaDAO;
import VO.VO_Usuario;
import java.util.List;
import Interfaces.IIngreso;
import VO.VO_Sesion;
import java.util.ArrayList;

/**
 *
 * @author Luis Augusto Guerra
 */
public class GestionLogin implements IIngreso<VO_Usuario>
{

    public GestionLogin() 
    {
        PersonaDAO oPersonaDAO = new PersonaDAO();
        ListaUsuarios = oPersonaDAO.getListarUsuarios();
    }
    private List<VO_Usuario> ListaUsuarios =  new ArrayList<VO_Usuario>();
    
    @Override
    public VO_Sesion Validar(VO_Usuario Login) 
    {
        VO_Sesion vo_Sesion = null;
        VO_Usuario vo_Usuario = this.ListaUsuarios.stream().filter(p->p.getCodigoUsuario().equals(Login.getCodigoUsuario())).findFirst().get();
        if (vo_Usuario != null)
        {
            if (vo_Usuario.getClaveUsuario().equalsIgnoreCase(Login.getClaveUsuario()))
            {
                vo_Sesion = GenerarSesion(Login);
            }
        }
        else
            vo_Sesion = null;
        return vo_Sesion;
    }
    
    private VO_Sesion GenerarSesion(VO_Usuario Login)
    {
        GestionSesion oGestionSesion= new GestionSesion();
        VO_Sesion vo_Sesion = new VO_Sesion();
        Long Tiempo = System.currentTimeMillis();
        
        vo_Sesion.setCodigoUsuario(Login.getCodigoUsuario());
        vo_Sesion.setEstadoSesion("A");
        vo_Sesion.setSesion(Login.getCodigoUsuario()+ Tiempo.toString());
        oGestionSesion.InsertarSesion(vo_Sesion);
        return vo_Sesion;
    }
    
}
