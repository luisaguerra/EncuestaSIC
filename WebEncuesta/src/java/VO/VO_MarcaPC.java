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
public class VO_MarcaPC 
{
    private String CodigoMarcaPC;
    private String DescripcionMarcaPC;

    public VO_MarcaPC() {
    }

    public VO_MarcaPC(String CodigoMarcaPC) {
        this.CodigoMarcaPC = CodigoMarcaPC;
    }

    public String getCodigoMarcaPC() {
        return CodigoMarcaPC;
    }

    public void setCodigoMarcaPC(String CodigoMarcaPC) {
        this.CodigoMarcaPC = CodigoMarcaPC;
    }

    public String getDescripcionMarcaPC() {
        return DescripcionMarcaPC;
    }

    public void setDescripcionMarcaPC(String DescripcionMarcaPC) {
        this.DescripcionMarcaPC = DescripcionMarcaPC;
    }
    
    
}
