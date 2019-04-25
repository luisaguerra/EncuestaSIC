/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import VO.VO_Sesion;

/**
 *
 * @author Luis Augusto Guerra
 */
public interface IIngreso <Objeto>
{
    public VO_Sesion Validar(Objeto Login);
}
