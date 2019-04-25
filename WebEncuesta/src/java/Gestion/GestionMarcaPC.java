/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import DAO.MarcaPCDAO;
import Interfaces.IGestion;
import VO.VO_MarcaPC;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Augusto Guerra
 */
public class GestionMarcaPC implements IGestion <VO_MarcaPC>
{
    private List<VO_MarcaPC> ListaMarcaPCs = new ArrayList<VO_MarcaPC>();

    public GestionMarcaPC() {
        MarcaPCDAO oMarcaPCDAO = new MarcaPCDAO();
        this.ListaMarcaPCs =  oMarcaPCDAO.getListarMarcaPC();
    }
    
    @Override
    public void Insertar(VO_MarcaPC Insertar) 
    {
        this.ListaMarcaPCs.add(Insertar);
    }

    @Override
    public void Eliminar(VO_MarcaPC Eliminar) 
    {
        VO_MarcaPC vo_MarcaPC = this.ListaMarcaPCs.stream().filter(p->p.getCodigoMarcaPC().equals(Eliminar.getCodigoMarcaPC())).findFirst().get();
        this.ListaMarcaPCs.remove(vo_MarcaPC);
    }

    
    public VO_MarcaPC Consultar(VO_MarcaPC Consultar) 
    {
        VO_MarcaPC vo_MarcaPC = new VO_MarcaPC();
        try { 
            vo_MarcaPC = this.ListaMarcaPCs.stream().filter(p->p.getCodigoMarcaPC().equals(Consultar.getCodigoMarcaPC())).findFirst().get();
        }
        catch (Exception e)
        {
            vo_MarcaPC = null;
        }
        if (vo_MarcaPC != null)
            return vo_MarcaPC;
        else
            return null;
    }

    @Override
    public List<VO_MarcaPC> Listar() 
    {
        return this.ListaMarcaPCs;
    }
    
    
}
