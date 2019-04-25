/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import DAO.EncuestaDAO;
import Interfaces.IGestion;
import VO.VO_Encuesta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Augusto Guerra
 */
public class GestionEncuesta implements IGestion<VO_Encuesta>
{
    EncuestaDAO oEncuestaDAO;

    public GestionEncuesta() 
    {
        oEncuestaDAO = new EncuestaDAO();
        ListaEncuestas = oEncuestaDAO.getListarEncuestas();
    }
    
    public List<VO_Encuesta> getListaEncuestas() {
        return ListaEncuestas;
    }

    public void setListaEncuestas(List<VO_Encuesta> ListaEncuestas) {
        this.ListaEncuestas = ListaEncuestas;
    }
    private List<VO_Encuesta> ListaEncuestas = new ArrayList<VO_Encuesta>();
    
    @Override
    public void Insertar(VO_Encuesta Insertar) 
    {
        oEncuestaDAO.setInsertarEncuesta(Insertar);
        this.ListaEncuestas.add(Insertar);
    }

    @Override
    public void Eliminar(VO_Encuesta Eliminar) 
    {
        VO_Encuesta vo_Encuesta = new VO_Encuesta();
        try
        {
         vo_Encuesta = this.ListaEncuestas.stream().filter(p->p.getNumeroDocumento().equals(Eliminar.getNumeroDocumento())).findFirst().get();
            
        }
        catch (Exception e)
        {
            vo_Encuesta = null;
            e.printStackTrace();
        }    
                 if (vo_Encuesta != null)
                 {
            oEncuestaDAO.setEliminarEncuesta(vo_Encuesta);
            this.ListaEncuestas.remove(vo_Encuesta);
                 }

    }

    @Override
    public List<VO_Encuesta> Listar() 
    {
        return this.ListaEncuestas;
    }
    
}
