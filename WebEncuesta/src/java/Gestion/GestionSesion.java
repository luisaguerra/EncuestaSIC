/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import DAO.SesionDAO;
import Interfaces.ISesion;
import VO.VO_Sesion;
import VO.VO_Sesion;
import VO.VO_Sesion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Augusto Guerra
 */
public class GestionSesion implements ISesion<VO_Sesion>{
    SesionDAO oSesionDAO;
    public GestionSesion()
    {
        oSesionDAO = new SesionDAO();
        ListaSesions = oSesionDAO.getListarSesions();
    }

    private List<VO_Sesion> ListaSesions = new ArrayList<VO_Sesion>();
    
    
    @Override
    public boolean Validar(VO_Sesion Login) 
    {
        VO_Sesion vo_Sesion = null;
        try 
        {
        vo_Sesion = 
                this.ListaSesions.stream().filter(p->p.getSesion().equals(Login.getSesion())).findFirst().get();
        }
        catch (Exception e)
        {
            return false;
        }
        
        if (vo_Sesion == null)
            return false;
        return vo_Sesion.getCodigoUsuario().equalsIgnoreCase(Login.getCodigoUsuario()) && 
                vo_Sesion.getEstadoSesion().equalsIgnoreCase("A");
    }
    
    public void InsertarSesion(VO_Sesion vo_Sesion)
    {
        oSesionDAO.setInsertarSesion(vo_Sesion);
        this.ListaSesions.add(vo_Sesion);
    }        
    
    public void EliminarSesion(VO_Sesion Eliminar)
    {
        oSesionDAO.setEliminarSesion(Eliminar);
        VO_Sesion vo_Sesion = this.ListaSesions.stream().filter(p->p.getSesion().equals(Eliminar.getSesion())).findFirst().get();
        this.ListaSesions.remove(vo_Sesion);
    }        
}
