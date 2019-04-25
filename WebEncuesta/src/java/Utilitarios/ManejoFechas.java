/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Luis Augusto Guerra
 */
public class ManejoFechas 
{

    public ManejoFechas() {
    }
    
    public String DatetoStr(Date dFecha)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String sFecha = sdf.format(dFecha);
        return sFecha;
    }

    public Date StrtoDate(String sFecha)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dFecha =  (Calendar.getInstance()).getTime();;
        try
        {
            dFecha = sdf.parse(sFecha);
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        return dFecha;
    }
    
    public String TimetoStr(Date dFecha)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String sHora = sdf.format(dFecha);
        return sHora;
    }        

}
