/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.Date;

/**
 *
 * @author Luis Augusto Guerra
 */
public class VO_Encuesta 
{
    private Long NumeroDocumento;
    private String Email;
    private String Comentarios;
    private String MarcaPC;
    private String FechaRespuesta;
    private String HoraRespuesta;

    public VO_Encuesta() {
    }

    public String getHoraRespuesta() {
        return HoraRespuesta;
    }

    public void setHoraRespuesta(String HoraRespuesta) {
        this.HoraRespuesta = HoraRespuesta;
    }

    public VO_Encuesta( Long NumeroDocumento, String Email, String Comentarios, String MarcaPC, String FechaRespuesta, String HoraRespuesta) {
        this.NumeroDocumento = NumeroDocumento;
        this.Email = Email;
        this.Comentarios = Comentarios;
        this.MarcaPC = MarcaPC;
        this.FechaRespuesta = FechaRespuesta;
        this.HoraRespuesta = HoraRespuesta;
    }





    public Long getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(Long NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public String getMarcaPC() {
        return MarcaPC;
    }

    public void setMarcaPC(String MarcaPC) {
        this.MarcaPC = MarcaPC;
    }

    public String getFechaRespuesta() {
        return FechaRespuesta;
    }

    public void setFechaRespuesta(String FechaRespuesta) {
        this.FechaRespuesta = FechaRespuesta;
    }
    
    
}
