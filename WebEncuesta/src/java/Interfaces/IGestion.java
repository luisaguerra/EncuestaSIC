/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Luis Augusto Guerra
 */
public interface IGestion<Objeto> 
{
    public void Insertar(Objeto Insertar);
    public void Eliminar(Objeto Eliminar);
    public List<Objeto> Listar();
   
}
